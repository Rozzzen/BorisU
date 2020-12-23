package com.java.bohomolov.enums;

public enum Style {

    MODERN ("Modern"),
    CLASSIC ("Classic"),
    HIGHTEC ("High-tech"),
    BAROKKO ("Barokko");

    private final String style;

    Style(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
