package com.siu.android.andutils.util;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public final class FragmentUtils {

    public static void showDialog(FragmentManager fragmentManager, DialogFragment dialogFragment) {
        FragmentTransaction ft = fragmentManager.beginTransaction();

        Fragment prev = fragmentManager.findFragmentByTag(dialogFragment.getClass().getSimpleName());
        if (prev != null) {
            ft.remove(prev);
        }

        ft.addToBackStack(null);
        dialogFragment.show(ft, dialogFragment.getClass().getSimpleName());
    }
}
