package com.jaydip.fancyfontskeyboard.fancyfontsbunch;

import androidx.exifinterface.media.ExifInterface;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyInterface;

public final class FancyStyle27 implements FancyInterface {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"Ａ", "в", "ℂ", "Ⓓ", "𝕖", "𝐅", "𝓖", "ℍ", "ⓘ", "𝕛", "𝐤", "𝓛", "ｍ", "η", "Ⓞ", "𝔭", "ｑ", "ℝ", "Ⓢ", "丅", "ｕ", "𝕍", "w", "𝕏", "𝓨", "Ⓩ"};
    }

    @Override 
    public String getName() {
        return "Ａв";
    }

    @Override 
    public String getTest() {
        return "𝐅Ⓞη丅";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"Ａ", "в", "ℂ", "Ⓓ", "𝕖", "𝐅", "𝓖", "ℍ", "ⓘ", "𝕛", "𝐤", "𝓛", "ｍ", "η", "Ⓞ", "𝔭", "ｑ", "ℝ", "Ⓢ", "丅", "ｕ", "𝕍", ExifInterface.LONGITUDE_WEST, "𝕏", "𝓨", "Ⓩ"};
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
