package com.jaydip.fancyfontskeyboard.fancyfontsbunch;

public interface FancyInterface {
    float getExtraPaddingDownFactor();

    CharSequence[] getLowercase();

    String getName();

    float getSizeFactorButton();

    float getSizeFactorKeys();

    String getTest();

    CharSequence[] getUppercase();

    boolean isUpsideDown();

    CharSequence letter(int i, boolean z);

    public static final class DefaultImpls {
        public static float getExtraPaddingDownFactor(FancyInterface fancyInterface) {
            return 0.0f;
        }

        public static float getSizeFactorButton(FancyInterface fancyInterface) {
            return 1.0f;
        }

        public static float getSizeFactorKeys(FancyInterface fancyInterface) {
            return 1.0f;
        }

        public static boolean isUpsideDown(FancyInterface fancyInterface) {
            return false;
        }

        public static CharSequence letter(FancyInterface fancyInterface, int i, boolean z) {
            int i2 = i - 97;
            if (i2 < 0 || i2 > 25) {
                return null;
            }
            if (z) {
                try {
                    return fancyInterface.getUppercase()[i2];
                } catch (Exception unused) {
                }
            }
            return fancyInterface.getLowercase()[i2];
        }
    }
}
