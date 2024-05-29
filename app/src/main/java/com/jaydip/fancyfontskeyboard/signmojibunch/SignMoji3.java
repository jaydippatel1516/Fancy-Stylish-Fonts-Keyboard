package com.jaydip.fancyfontskeyboard.signmojibunch;

import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyInterface;

public final class SignMoji3 implements FancyInterface {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"♕", "␈", "𐂃", "𐂂", "𓀬", "𓆈", "𓃗", "𓃱", "𓀡", "𓀿", "𓅷", "𓆏", "𓃰", "𓄁", "𓃠", "𓅿", "𓃟", "𓂻", "♔", "𓆙", "𓃒", "𐂊", "𓂉", "⚣", "ଈ", "𖠌"};
    }

    @Override 
    public String getName() {
        return "♕␈𐂃";
    }

    @Override 
    public float getSizeFactorKeys() {
        return 0.95f;
    }

    @Override 
    public String getTest() {
        return "♕␈𐂃𐂂";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"♕", "␈", "𐂃", "𐂂", "𓀬", "𓆈", "𓃗", "𓃱", "𓀡", "𓀿", "𓅷", "𓆏", "𓃰", "𓄁", "𓃠", "𓅿", "𓃟", "𓂻", "♔", "𓆙", "𓃒", "𐂊", "𓂉", "⚣", "ଈ", "𖠌"};
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
