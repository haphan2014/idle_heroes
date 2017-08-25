package org.cocos2dx.lib;

import android.content.Context;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.Semaphore;

public class Cocos2dxSound {
    private static final int INVALID_SOUND_ID = -1;
    private static final int INVALID_STREAM_ID = -1;
    public static final int MAX_SIMULTANEOUS_STREAMS_DEFAULT = 5;
    public static final int MAX_SIMULTANEOUS_STREAMS_I9100 = 3;
    private static final int SOUND_PRIORITY = 1;
    private static final int SOUND_QUALITY = 5;
    private static final float SOUND_RATE = 1.0f;
    private static final String TAG = "Cocos2dxSound";
    private final Context mContext;
    private final ArrayList<SoundInfoForLoadedCompleted> mEffecToPlayWhenLoadedArray = new ArrayList();
    private float mLeftVolume;
    private final HashMap<String, Integer> mPathSoundIDMap = new HashMap();
    private final HashMap<String, ArrayList<Integer>> mPathStreamIDsMap = new HashMap();
    private float mRightVolume;
    private Semaphore mSemaphore;
    private SoundPool mSoundPool;
    private int mStreamIdSyn;
    private int simultaneousStreams;

    public class OnLoadCompletedListener implements OnLoadCompleteListener {
        public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
            if (status == 0) {
                Iterator it = Cocos2dxSound.this.mEffecToPlayWhenLoadedArray.iterator();
                while (it.hasNext()) {
                    SoundInfoForLoadedCompleted info = (SoundInfoForLoadedCompleted) it.next();
                    if (sampleId == info.soundID) {
                        Cocos2dxSound.this.mStreamIdSyn = Cocos2dxSound.this.doPlayEffect(info.path, info.soundID, info.isLoop);
                        Cocos2dxSound.this.mEffecToPlayWhenLoadedArray.remove(info);
                        break;
                    }
                }
            }
            Cocos2dxSound.this.mStreamIdSyn = -1;
            Cocos2dxSound.this.mSemaphore.release();
        }
    }

    public class SoundInfoForLoadedCompleted {
        public boolean isLoop;
        public String path;
        public int soundID;

        public SoundInfoForLoadedCompleted(String path, int soundId, boolean isLoop) {
            this.path = path;
            this.soundID = soundId;
            this.isLoop = isLoop;
        }
    }

    public Cocos2dxSound(Context pContext, int simultaneousStreams) {
        this.mContext = pContext;
        initData(simultaneousStreams);
    }

    private void initData(int simultaneousStreams) {
        this.mSoundPool = new SoundPool(simultaneousStreams, 3, 5);
        this.mSoundPool.setOnLoadCompleteListener(new OnLoadCompletedListener());
        this.mLeftVolume = 0.5f;
        this.simultaneousStreams = simultaneousStreams;
        this.mRightVolume = 0.5f;
        this.mSemaphore = new Semaphore(0, true);
    }

    public int preloadEffect(String pPath) {
        Integer soundID = (Integer) this.mPathSoundIDMap.get(pPath);
        if (soundID == null) {
            soundID = Integer.valueOf(createSoundIDFromAsset(pPath));
            if (soundID.intValue() != -1) {
                this.mPathSoundIDMap.put(pPath, soundID);
            }
        }
        return soundID.intValue();
    }

    public void unloadEffect(String pPath) {
        ArrayList<Integer> streamIDs = (ArrayList) this.mPathStreamIDsMap.get(pPath);
        if (streamIDs != null) {
            Iterator it = streamIDs.iterator();
            while (it.hasNext()) {
                this.mSoundPool.stop(((Integer) it.next()).intValue());
            }
        }
        this.mPathStreamIDsMap.remove(pPath);
        Integer soundID = (Integer) this.mPathSoundIDMap.get(pPath);
        if (soundID != null) {
            this.mSoundPool.unload(soundID.intValue());
            this.mPathSoundIDMap.remove(pPath);
        }
    }

    public int playEffect(String pPath, boolean pLoop) {
        int streamID;
        Integer soundID = (Integer) this.mPathSoundIDMap.get(pPath);
        if (soundID != null) {
            streamID = doPlayEffect(pPath, soundID.intValue(), pLoop);
        } else {
            soundID = Integer.valueOf(preloadEffect(pPath));
            if (soundID.intValue() == -1) {
                return -1;
            }
            synchronized (this.mSoundPool) {
                this.mEffecToPlayWhenLoadedArray.add(new SoundInfoForLoadedCompleted(pPath, soundID.intValue(), pLoop));
                try {
                    this.mSemaphore.acquire();
                    streamID = this.mStreamIdSyn;
                } catch (Exception e) {
                    return -1;
                }
            }
        }
        return streamID;
    }

    public void stopEffect(int pStreamID) {
        this.mSoundPool.stop(pStreamID);
        for (String pPath : this.mPathStreamIDsMap.keySet()) {
            if (((ArrayList) this.mPathStreamIDsMap.get(pPath)).contains(Integer.valueOf(pStreamID))) {
                ((ArrayList) this.mPathStreamIDsMap.get(pPath)).remove(((ArrayList) this.mPathStreamIDsMap.get(pPath)).indexOf(Integer.valueOf(pStreamID)));
                return;
            }
        }
    }

    public void pauseEffect(int pStreamID) {
        this.mSoundPool.pause(pStreamID);
    }

    public void resumeEffect(int pStreamID) {
        this.mSoundPool.resume(pStreamID);
    }

    public void pauseAllEffects() {
        this.mSoundPool.autoPause();
    }

    public void resumeAllEffects() {
        if (!this.mPathStreamIDsMap.isEmpty()) {
            for (Entry<String, ArrayList<Integer>> entry : this.mPathStreamIDsMap.entrySet()) {
                Iterator it = ((ArrayList) entry.getValue()).iterator();
                while (it.hasNext()) {
                    this.mSoundPool.resume(((Integer) it.next()).intValue());
                }
            }
        }
    }

    public void stopAllEffects() {
        if (!this.mPathStreamIDsMap.isEmpty()) {
            for (Entry<String, ArrayList<Integer>> entry : this.mPathStreamIDsMap.entrySet()) {
                Iterator it = ((ArrayList) entry.getValue()).iterator();
                while (it.hasNext()) {
                    this.mSoundPool.stop(((Integer) it.next()).intValue());
                }
            }
        }
        this.mPathStreamIDsMap.clear();
    }

    public float getEffectsVolume() {
        return (this.mLeftVolume + this.mRightVolume) / 2.0f;
    }

    public void setEffectsVolume(float pVolume) {
        if (pVolume < 0.0f) {
            pVolume = 0.0f;
        }
        if (pVolume > 1.0f) {
            pVolume = 1.0f;
        }
        this.mRightVolume = pVolume;
        this.mLeftVolume = pVolume;
        if (!this.mPathStreamIDsMap.isEmpty()) {
            for (Entry<String, ArrayList<Integer>> entry : this.mPathStreamIDsMap.entrySet()) {
                Iterator it = ((ArrayList) entry.getValue()).iterator();
                while (it.hasNext()) {
                    this.mSoundPool.setVolume(((Integer) it.next()).intValue(), this.mLeftVolume, this.mRightVolume);
                }
            }
        }
    }

    public void end() {
        this.mSoundPool.release();
        this.mPathStreamIDsMap.clear();
        this.mPathSoundIDMap.clear();
        this.mEffecToPlayWhenLoadedArray.clear();
        this.mLeftVolume = 0.5f;
        this.mRightVolume = 0.5f;
        initData(this.simultaneousStreams);
    }

    public int createSoundIDFromAsset(String pPath) {
        int soundID;
        try {
            if (pPath.startsWith("/")) {
                soundID = this.mSoundPool.load(pPath, 0);
            } else {
                soundID = this.mSoundPool.load(this.mContext.getAssets().openFd(pPath), 0);
            }
        } catch (Exception e) {
            soundID = -1;
            Log.e(TAG, "error: " + e.getMessage(), e);
        }
        if (soundID == 0) {
            return -1;
        }
        return soundID;
    }

    private int doPlayEffect(String pPath, int soundId, boolean pLoop) {
        int streamID = this.mSoundPool.play(soundId, this.mLeftVolume, this.mRightVolume, 1, pLoop ? -1 : 0, 1.0f);
        ArrayList<Integer> streamIDs = (ArrayList) this.mPathStreamIDsMap.get(pPath);
        if (streamIDs == null) {
            streamIDs = new ArrayList();
            this.mPathStreamIDsMap.put(pPath, streamIDs);
        }
        streamIDs.add(Integer.valueOf(streamID));
        return streamID;
    }
}
