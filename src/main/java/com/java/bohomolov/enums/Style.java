package com.java.bohomolov.enums;

public enum Style {

    MODERN ("Modern"),
    CLASSIC ("Classic"),
    HIGHTEC ("High-tech"),
    BAROKKO ("Barokko");

    private final String styleName;

    Style(String styleName) {
        this.styleName = styleName;
    }

    public String getStyleName() {
        return styleName;
    }
}
