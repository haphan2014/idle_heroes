package com.vungle.publisher;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.ContextThemeWrapper;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class nd {

    /* compiled from: vungle */
    public interface C1830a {
        void mo4497a();

        void mo4498b();

        void mo4499c();
    }

    public final AlertDialog m2193a(Context context, C1617z c1617z, final C1830a c1830a) {
        Builder builder = new Builder(new ContextThemeWrapper(context, context.getApplicationInfo().theme));
        builder.setTitle(c1617z.getIncentivizedCancelDialogTitle());
        builder.setMessage(c1617z.getIncentivizedCancelDialogBodyText());
        builder.setPositiveButton(c1617z.getIncentivizedCancelDialogKeepWatchingButtonText(), new OnClickListener(this) {
            final /* synthetic */ nd f2622b;

            public final void onClick(DialogInterface dialogInterface, int i) {
                so.m2470a(3, "VungleAd", "positive click", null);
                c1830a.mo4497a();
            }
        });
        builder.setNegativeButton(c1617z.getIncentivizedCancelDialogCloseButtonText(), new OnClickListener(this) {
            final /* synthetic */ nd f2624b;

            public final void onClick(DialogInterface dialogInterface, int i) {
                so.m2470a(3, "VungleAd", "negative click", null);
                c1830a.mo4498b();
            }
        });
        builder.setOnCancelListener(new OnCancelListener(this) {
            final /* synthetic */ nd f2626b;

            public final void onCancel(DialogInterface dialogInterface) {
                so.m2470a(3, "VungleAd", "cancel click", null);
                c1830a.mo4499c();
            }
        });
        return builder.create();
    }
}
