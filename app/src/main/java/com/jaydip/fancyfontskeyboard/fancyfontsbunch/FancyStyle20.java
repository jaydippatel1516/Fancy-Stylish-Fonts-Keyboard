package com.jaydip.fancyfontskeyboard.fancyfontsbunch;

import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyInterface;

public final class FancyStyle20 implements FancyInterface {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"ค", "𝐛", "𝐂", "ⓓ", "𝒆", "f", "Ⓖ", "𝔥", "𝐈", "ᒎ", "ｋ", "𝓁", "𝓶", "𝔫", "Ⓞ", "ｐ", "𝕢", "𝓻", "丂", "t", "υ", "ⓥ", "𝔀", "Ж", "y", "𝓏"};
    }

    @Override 
    public String getName() {
        return "ᗩค";
    }

    @Override 
    public String getTest() {
        return "fⓄ𝔫t";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"ᗩ", "в", "𝒸", "๔", "乇", "ⓕ", "g", "H", "I", "ڶ", "𝕜", "𝕃", "𝓜", "ⓝ", "𝑜", "ρ", "ợ", "ｒ", "ѕ", "t", "Ｕ", "Ｖ", "𝐰", "𝓧", "ㄚ", "𝐳"};
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
