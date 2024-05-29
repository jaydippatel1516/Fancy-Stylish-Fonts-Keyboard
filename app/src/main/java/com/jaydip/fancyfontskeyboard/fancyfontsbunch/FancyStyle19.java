package com.jaydip.fancyfontskeyboard.fancyfontsbunch;

import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyInterface;

public final class FancyStyle19 implements FancyInterface {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"♥a♥", "♥b♥", "♥c♥", "♥d♥", "♥e♥", "♥f♥", "♥g♥", "♥h♥", "♥i♥", "♥j♥", "♥k♥", "♥l♥", "♥m♥", "♥n♥", "♥o♥", "♥p♥", "♥q♥", "♥r♥", "♥s♥", "♥t♥", "♥u♥", "♥v♥", "♥w♥", "♥x♥", "♥y♥", "♥z♥"};
    }

    @Override 
    public String getName() {
        return "♥A♥♥a♥";
    }

    @Override 
    public String getTest() {
        return "♥f♥♥o♥♥n♥♥t♥";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"♥A♥", "♥B♥", "♥C♥", "♥D♥", "♥E♥", "♥F♥", "♥G♥", "♥H♥", "♥I♥", "♥J♥", "♥K♥", "♥L♥", "♥M♥", "♥N♥", "♥O♥", "♥P♥", "♥Q♥", "♥R♥", "♥S♥", "♥T♥", "♥U♥", "♥V♥", "♥W♥", "♥X♥", "♥Y♥", "♥Z♥"};
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
