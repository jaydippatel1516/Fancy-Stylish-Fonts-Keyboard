package com.jaydip.fancyfontskeyboard.fancyfontsbunch;

import androidx.exifinterface.media.ExifInterface;

import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyInterface;

public final class FancyStyle12 implements FancyInterface {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "฿", "C", "Đ", ExifInterface.LONGITUDE_EAST, "₣", "G", "H", "ł", "J", "K", "L", "M", "N", "Ø", "₱", "Q", "R", ExifInterface.LATITUDE_SOUTH, "₮", "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "₩", "X", "Y", "Z"};
    }

    @Override 
    public String getName() {
        return "A฿";
    }

    @Override 
    public String getTest() {
        return "₣ØN₮";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "฿", "C", "Đ", ExifInterface.LONGITUDE_EAST, "₣", "G", "H", "ł", "J", "K", "L", "M", "N", "Ø", "₱", "Q", "R", ExifInterface.LATITUDE_SOUTH, "₮", "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "₩", "X", "Y", "Z"};
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
