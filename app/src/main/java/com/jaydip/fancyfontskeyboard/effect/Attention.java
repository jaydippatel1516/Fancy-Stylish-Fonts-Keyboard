package com.jaydip.fancyfontskeyboard.effect;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.jaydip.fancyfontskeyboard.R;

public class Attention {
    public static AnimatorSet RuberBand(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.02f, 0.98f, 1.02f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.98f, 1.02f, 0.98f, 1.0f));
        return animatorSet;
    }

    public static void Bounce(Context context, View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.bounce_anim);
        loadAnimation.setInterpolator(new BounceyInterpolator(0.2d, 20.0d));
        view.startAnimation(loadAnimation);
    }

    public static AnimatorSet In(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f));
        return animatorSet;
    }
}
