package com.jaydip.fancyfontskeyboard.signmojibunch;

import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyInterface;

public final class SignMoji12 implements FancyInterface {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"⓪", "①", "②", "③", "④", "⑤", "⑥", "⑦", "⑧", "⑨", "⑴", "⑵", "⑶", "⑷", "⑸", "⑹", "⑺", "⑻", "⑼", "Ⅰ", "Ⅱ", "Ⅲ", "Ⅳ", "Ⅴ", "Ⅵ", "Ⅶ"};
    }

    @Override 
    public String getName() {
        return "⓪①②";
    }

    @Override 
    public float getSizeFactorKeys() {
        return 0.95f;
    }

    @Override 
    public String getTest() {
        return "⓪①②③";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"⓪", "①", "②", "③", "④", "⑤", "⑥", "⑦", "⑧", "⑨", "⑴", "⑵", "⑶", "⑷", "⑸", "⑹", "⑺", "⑻", "⑼", "Ⅰ", "Ⅱ", "Ⅲ", "Ⅳ", "Ⅴ", "Ⅵ", "Ⅶ"};
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
    public boolean isUpsideDown() {
        return FancyInterface.DefaultImpls.isUpsideDown(this);
    }

    @Override 
    public CharSequence letter(int i, boolean z) {
        return FancyInterface.DefaultImpls.letter(this, i, z);
    }
}
