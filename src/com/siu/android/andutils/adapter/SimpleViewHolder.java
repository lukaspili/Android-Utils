package com.siu.android.andutils.adapter;

import android.view.View;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public abstract class SimpleViewHolder {

    protected View row;

    public void setRow(View row) {
        this.row = row;
    }

    public abstract void init();
}
