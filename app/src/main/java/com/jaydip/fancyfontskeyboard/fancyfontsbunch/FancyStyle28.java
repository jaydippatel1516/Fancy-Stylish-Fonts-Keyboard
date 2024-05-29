package com.jaydip.fancyfontskeyboard.fancyfontsbunch;

import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyInterface;

public final class FancyStyle28 implements FancyInterface {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"𝕒", "Ｂ", "ᑕ", "ⓓ", "𝔢", "𝐅", "ⓖ", "Ĥ", "i", "𝐉", "Ｋ", "𝕝", "𝓜", "𝕟", "Ỗ", "𝓹", "𝕢", "ᖇ", "s", "т", "υ", "v", "ᗯ", "x", "ㄚ", "ℤ"};
    }

    @Override 
    public String getName() {
        return "𝕒Ｂ";
    }

    @Override 
    public String getTest() {
        return "ℱᗝภт";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"𝕒", "в", "Ⓒ", "D", "ε", "ℱ", "Ⓖ", "ᕼ", "𝐢", "ᒎ", "к", "𝐋", "м", "ภ", "ᗝ", "P", "q", "𝓇", "Ⓢ", "𝓉", "𝓾", "𝓿", "𝓌", "𝐱", "у", "z"};
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
