package com.jaydip.fancyfontskeyboard.effect;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;

public class Render {
    AnimatorListenerAdapter animatorListenerAdapter;
    private AnimatorSet animatorSet;
    private Context cx;
    private long duration = 1000;

    public Render(Context context) {
        this.cx = context;
    }

    public void setAnimation(AnimatorSet animatorSet2) {
        this.animatorSet = animatorSet2;
    }

    public void start() {
        this.animatorSet.setDuration(this.duration);
        this.animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        this.animatorSet.start();
        AnimatorListenerAdapter r0 = new AnimatorListenerAdapter() {


            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Render.this.animatorSet.start();
            }
        };
        this.animatorListenerAdapter = r0;
        this.animatorSet.addListener(r0);
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void stop() {
        AnimatorListenerAdapter animatorListenerAdapter2;
        AnimatorSet animatorSet2 = this.animatorSet;
        if (animatorSet2 != null && (animatorListenerAdapter2 = this.animatorListenerAdapter) != null) {
            animatorSet2.removeListener(animatorListenerAdapter2);
            this.animatorSet.cancel();
        }
    }
}
