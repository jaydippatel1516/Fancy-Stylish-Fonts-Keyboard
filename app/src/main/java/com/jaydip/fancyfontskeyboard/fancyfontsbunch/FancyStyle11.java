package com.jaydip.fancyfontskeyboard.fancyfontsbunch;

import androidx.exifinterface.media.ExifInterface;

import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyInterface;

public final class FancyStyle11 implements FancyInterface {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"å", "ß", "¢", "Ð", "ê", "£", "g", "h", "ï", "j", "k", "l", "m", "ñ", "ð", "þ", "q", "r", "§", "†", "µ", "v", "w", "x", "¥", "z"};
    }

    @Override 
    public String getName() {
        return "Äå";
    }

    @Override 
    public String getTest() {
        return "£Öñ†";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"Ä", "ß", "Ç", "Ð", "È", "£", "G", "H", "Ì", "J", "K", "L", "M", "ñ", "Ö", "þ", "Q", "R", "§", "†", "Ú", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "×", "¥", "Z"};
    }

    @Override 
    public float getExtraPaddingDownFactor() {
        return FancyInterface.DefaultImpls.getExtraPaddingDownFactor(this);
    }

    @Override 
    public float getSizeFactorButton() {
        return FancyInterface.DefaultImpls.getSizeFactorButton(this);
    }

    @Override 
    public float getSizeFactorKeys() {
        return FancyInterface.DefaultImpls.getSizeFactorKeys(this);
    }

    @Override 
    public boolean isUpsideDown() {
        return FancyInterface.DefaultImpls.isUpsideDown(this);
    }

    @Override 
    public CharSequence letter(int i, boolean z) {
        return FancyInterface.DefaultImpls.letter(this, i, z);
    }
}
