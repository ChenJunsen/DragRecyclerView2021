package com.cjs.drv.recyclerview.model;

import androidx.annotation.DrawableRes;

public class RecyclerItem {
    private int icon;
    private String text;

    public RecyclerItem() {
    }

    public RecyclerItem(@DrawableRes int icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(@DrawableRes int icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "RecyclerItem{" +
                "icon=" + icon +
                ", text='" + text + '\'' +
                '}';
    }
}
