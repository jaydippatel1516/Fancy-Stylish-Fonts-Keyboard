package com.jaydip.fancyfontskeyboard.service;

import android.content.Context;
import android.os.Build;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.DefaultStyle;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyInterface;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle1;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle10;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle11;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle12;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle13;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle14;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle15;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle16;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle17;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle18;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle19;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle2;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle20;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle21;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle22;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle23;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle24;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle25;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle26;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle27;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle28;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle29;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle3;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle30;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle31;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle32;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle33;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle4;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle5;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle6;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle7;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle8;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle9;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji10;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji11;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji12;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji2;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji3;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji4;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji5;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji6;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji7;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji8;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji9;
import com.jaydip.fancyfontskeyboard.util.SharedPreferenceProvider;
import java.util.Arrays;
import java.util.Objects;

public final class FancyFontManager {
    public static final FancyFontManager INSTANCE = new FancyFontManager();
    private static Context context;
    private static int currentFontIndex;
    private static final FancyInterface[] fontOrderOverOrO = {new DefaultStyle(), new SignMoji4(), new SignMoji5(), new SignMoji6(), new SignMoji7(), new SignMoji8(), new SignMoji9(), new SignMoji10(), new SignMoji11(), new SignMoji12(), new SignMoji(), new SignMoji2(), new SignMoji3(), new FancyStyle1(), new FancyStyle2(), new FancyStyle3(), new FancyStyle4(), new FancyStyle5(), new FancyStyle6(), new FancyStyle7(), new FancyStyle8(), new FancyStyle9(), new FancyStyle10(), new FancyStyle11(), new FancyStyle12(), new FancyStyle13(), new FancyStyle14(), new FancyStyle15(), new FancyStyle16(), new FancyStyle17(), new FancyStyle18(), new FancyStyle19(), new FancyStyle20(), new FancyStyle21(), new FancyStyle22(), new FancyStyle23(), new FancyStyle24(), new FancyStyle25(), new FancyStyle26(), new FancyStyle27(), new FancyStyle28(), new FancyStyle29(), new FancyStyle30(), new FancyStyle31(), new FancyStyle32(), new FancyStyle33()};
    private static final FancyInterface[] fontOrderUnderO = {new DefaultStyle(), new FancyStyle1(), new FancyStyle2(), new FancyStyle3(), new FancyStyle4(), new FancyStyle5(), new FancyStyle6(), new FancyStyle7(), new FancyStyle8(), new FancyStyle9(), new FancyStyle10(), new FancyStyle11(), new FancyStyle12(), new FancyStyle13(), new FancyStyle14(), new FancyStyle15(), new FancyStyle16(), new FancyStyle17(), new FancyStyle18(), new FancyStyle19(), new FancyStyle20(), new FancyStyle21(), new FancyStyle22(), new FancyStyle23(), new FancyStyle24(), new FancyStyle25(), new FancyStyle26(), new FancyStyle27(), new FancyStyle28(), new FancyStyle29(), new FancyStyle30(), new FancyStyle31(), new FancyStyle32(), new FancyStyle33()};
    private static SharedPreferenceProvider sharedPreference;

    private FancyFontManager() {
    }

    public final Context getContext() {
        return context;
    }

    public final void setContext(Context context2) {
        if (context2 != null) {
            sharedPreference = new SharedPreferenceProvider(context2);
        }
    }

    public final FancyInterface getInitialFont() {
        SharedPreferenceProvider sharedPreferenceProvider = sharedPreference;
        Objects.requireNonNull(sharedPreferenceProvider, "sharedPreference");
        int max = Math.max(Math.min(sharedPreferenceProvider.getCurrentFontIndex(), getFontOrder().length - 1), 0);
        currentFontIndex = max;
        return getFontOrder()[max];
    }

    public final FancyInterface getCurrentFont() {
        return getFontOrder()[Math.max(Math.min(currentFontIndex, getFontOrder().length - 1), 0)];
    }

    public final void setCurrentFont(FancyInterface fancyInterface) {
        int indexOf = indexOf(getFontOrder(), fancyInterface);
        currentFontIndex = indexOf;
        SharedPreferenceProvider sharedPreferenceProvider = sharedPreference;
        Objects.requireNonNull(sharedPreferenceProvider, "sharedPreference");
        sharedPreferenceProvider.setCurrentFontIndex(indexOf);
    }

    public final FancyInterface[] getFontOrderUnderO() {
        return fontOrderUnderO;
    }

    public final FancyInterface[] getFontOrderOverOrO() {
        return fontOrderOverOrO;
    }

    public final FancyInterface[] getFontOrder() {
        if (Build.VERSION.SDK_INT >= 26) {
            return fontOrderOverOrO;
        }
        return fontOrderUnderO;
    }

    public final void nextFont() {
        currentFontIndex = (currentFontIndex + 1) % getFontOrder().length;
    }

    public static <T> int indexOf(T[] tArr, T t) {
        return Arrays.asList(tArr).indexOf(t);
    }
}
