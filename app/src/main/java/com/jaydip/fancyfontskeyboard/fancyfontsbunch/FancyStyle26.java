package com.jaydip.fancyfontskeyboard.fancyfontsbunch;

import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyInterface;

public final class FancyStyle26 implements FancyInterface {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"ⓐ", "Ｂ", "𝓒", "Ⓓ", "є", "𝒇", "Ｇ", "ᕼ", "เ", "ן", "𝓴", "𝐋", "𝕞", "ภ", "Ø", "p", "ｑ", "𝓇", "Ŝ", "Ŧ", "𝕦", "𝓿", "Ŵ", "𝕏", "Ў", "z"};
    }

    @Override 
    public String getName() {
        return "卂ⓐ";
    }

    @Override 
    public String getTest() {
        return "ℱØᑎŦ";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"卂", "в", "Ｃ", "𝐃", "𝐄", "ℱ", "ﻮ", "ђ", "ｉ", "ڶ", "K", "ⓛ", "𝓜", "ᑎ", "ㄖ", "ⓟ", "𝓠", "𝓇", "ѕ", "t", "Ữ", "𝕧", "w", "Ⓧ", "ㄚ", "Ｚ"};
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
