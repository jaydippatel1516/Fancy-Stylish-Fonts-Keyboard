package com.jaydip.fancyfontskeyboard.signmojibunch;

import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyInterface;

public final class SignMoji implements FancyInterface {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"♡", "⌫", "☏", "❥", "☾", "ఌ", "ꨄ", "𖨆", "シ", "☻", "☹", "☻", "𓁹", "𓂀", "㋛", "ت", "𓂸", "☽", "❦", "♫", "✞", "𓆉", "𓂺", "✔", "➪", "𑁍"};
    }

    @Override 
    public String getName() {
        return "♡⌫☏";
    }

    @Override 
    public float getSizeFactorKeys() {
        return 0.95f;
    }

    @Override 
    public String getTest() {
        return "♡⌫☏❥";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"♡", "⌫", "☏", "❥", "☾", "ఌ", "ꨄ", "𖨆", "シ", "☻", "☹", "☻", "𓁹", "𓂀", "㋛", "ت", "𓂸", "☽", "❦", "♫", "✞", "𓆉", "𓂺", "✔", "➪", "𑁍"};
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
