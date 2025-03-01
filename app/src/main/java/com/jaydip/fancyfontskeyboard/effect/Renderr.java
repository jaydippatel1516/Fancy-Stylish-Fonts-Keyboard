package com.jaydip.fancyfontskeyboard.effect;

import android.animation.AnimatorSet;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;

public class Renderr {
    private AnimatorSet animatorSet;
    private Context cx;
    private long duration = 400;

    public Renderr(Context context) {
        this.cx = context;
    }

    public void setAnimation(AnimatorSet animatorSet2) {
        this.animatorSet = animatorSet2;
    }

    public void start() {
        this.animatorSet.setDuration(this.duration);
        this.animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        this.animatorSet.start();
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void stop() {
        AnimatorSet animatorSet2 = this.animatorSet;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
    }
}
