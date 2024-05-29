package com.jaydip.fancyfontskeyboard.fancyfontsbunch;


import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyInterface;

public final class FancyStyle23 implements FancyInterface {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"a", "в", "𝓒", "𝕕", "ｅ", "ᖴ", "ⓖ", "𝕙", "ⓘ", "Ĵ", "k", "Ｌ", "ᗰ", "ｎ", "𝐎", "Ⓟ", "𝐐", "𝐑", "s", "𝐭", "Ữ", "ש", "ⓦ", "x", "ㄚ", "ｚ"};
    }

    @Override 
    public String getName() {
        return "Aв";
    }

    @Override 
    public String getTest() {
        return "ᖴ𝓸Ｎ𝐭";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"ᗩ", "B", "Ⓒ", "𝐃", "є", "𝒇", "G", "𝓗", "I", "נ", "к", "𝐥", "Ⓜ", "Ｎ", "𝓸", "𝐩", "Q", "ｒ", "𝓢", "Ŧ", "ⓤ", "𝓥", "ｗ", "χ", "ч", "ℤ"};
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
