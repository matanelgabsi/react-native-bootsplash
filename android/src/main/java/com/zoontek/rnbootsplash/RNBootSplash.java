package com.zoontek.rnbootsplash;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;

public class RNBootSplash {

  private static boolean showHasRunOnce = false;

  public static void show(final int drawableResId, @NonNull final Activity activity) {
    if (showHasRunOnce) return;

    activity.runOnUiThread(new Runnable() {
      @Override
      public void run() {
        Context context = activity.getApplicationContext();
        LinearLayout layout = new LinearLayout(context);
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1);
        params.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        LayoutParams paramsParent = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        ProgressBar view = new ProgressBar(context);

        layout.setBackgroundResource(drawableResId);
        layout.setId(R.id.bootsplash_layout_id);
        layout.setLayoutTransition(null);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView(view, params);

        activity.addContentView(layout, paramsParent);
        showHasRunOnce = true;
      }
    });
  }
}
