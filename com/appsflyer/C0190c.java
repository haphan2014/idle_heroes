package com.appsflyer;

import android.content.Context;
import android.os.AsyncTask;
import com.heyzap.http.AsyncHttpResponseHandler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

class C0190c extends AsyncTask<String, Void, String> {
    private String bodyAsString;
    public Map<String, String> bodyParameters;
    private String content = "";
    private boolean error = false;
    private Context mContext;

    public C0190c(Context context) {
        this.mContext = context;
    }

    protected void onPreExecute() {
        JSONObject jSONObject = new JSONObject(this.bodyParameters);
        if (jSONObject != null) {
            this.bodyAsString = jSONObject.toString();
        }
    }

    protected String doInBackground(String... urls) {
        try {
            URL url = new URL(urls[0]);
            C0196h.logMessageMaskKey("call = " + url + " parameters = " + this.bodyParameters.toString());
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setReadTimeout(30000);
            httpsURLConnection.setConnectTimeout(30000);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, AsyncHttpResponseHandler.DEFAULT_CHARSET));
            bufferedWriter.write(this.bodyAsString);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            httpsURLConnection.connect();
            if (httpsURLConnection.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    this.content += readLine;
                }
                C0188a.afLog("Status 200 ok");
                return this.content;
            }
            this.error = true;
            return this.content;
        } catch (MalformedURLException e) {
            C0188a.afLog("MalformedURLException: " + e.toString());
        } catch (ProtocolException e2) {
            C0188a.afLog("ProtocolException: " + e2.toString());
        } catch (IOException e3) {
            C0188a.afLog("IOException: " + e3.toString());
        } catch (Exception e4) {
            C0188a.afLog("Exception: " + e4.toString());
        }
    }

    protected void onCancelled() {
    }

    protected void onPostExecute(String content) {
        if (this.error) {
            C0188a.afLog("Connection error");
        } else {
            C0188a.afLog("Connection call succeeded");
        }
    }
}
