package com.jaydip.fancyfontskeyboard.util;

public class FancyFontModel {
    int backgroundColor;
    String themeName;

    public FancyFontModel(int i, String str) {
        this.backgroundColor = i;
        this.themeName = str;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public String getThemeName() {
        return this.themeName;
    }
}
