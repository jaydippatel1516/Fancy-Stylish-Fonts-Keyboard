package com.jaydip.fancyfontskeyboard.fancyfontsbunch;

import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyInterface;

public final class FancyStyle2 implements FancyInterface {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"𝖆", "𝖇", "𝖈", "𝖉", "𝖊", "𝖋", "𝖌", "𝖍", "𝖎", "𝖏", "𝖐", "𝖑", "𝖒", "𝖓", "𝖔", "𝖕", "𝖖", "𝖗", "𝖘", "𝖙", "𝖚", "𝖛", "𝖜", "𝖝", "𝖞", "𝖟"};
    }

    @Override 
    public String getName() {
        return "𝕬𝖆";
    }

    @Override 
    public String getTest() {
        return "𝕱𝖔𝖓𝖙";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"𝕬", "𝕭", "𝕮", "𝕯", "𝕰", "𝕱", "𝕲", "𝕳", "𝕴", "𝕵", "𝕶", "𝕷", "𝕸", "𝕹", "𝕺", "𝕻", "𝕼", "𝕽", "𝕾", "𝕿", "𝖀", "𝖁", "𝖂", "𝖃", "𝖄", "𝖅"};
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
