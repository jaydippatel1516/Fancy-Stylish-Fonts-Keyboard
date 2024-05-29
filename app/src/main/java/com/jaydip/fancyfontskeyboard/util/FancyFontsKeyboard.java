package com.jaydip.fancyfontskeyboard.util;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.inputmethodservice.Keyboard;

public final class FancyFontsKeyboard extends Keyboard {
    public static final Companion Companion = new Companion();
    public static final int KEYCODE_LANGUAGE_SWITCH = -101;

    public static final class Companion {
        public final int getKEYCODE_LANGUAGE_SWITCH() {
            return FancyFontsKeyboard.KEYCODE_LANGUAGE_SWITCH;
        }

        private Companion() {
        }
    }

    public FancyFontsKeyboard(Context context, int i) {
        super(context, i);
    }

    public Keyboard.Key createKeyFromXml(Resources resources, Keyboard.Row row, int i, int i2, XmlResourceParser xmlResourceParser) {
        return super.createKeyFromXml(resources, row, i, i2, xmlResourceParser);
    }
}
