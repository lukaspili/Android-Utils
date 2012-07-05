package com.siu.android.andutils.ads;

import android.util.Log;
import android.view.View;
import com.mobclix.android.sdk.MobclixAdView;
import com.mobclix.android.sdk.MobclixAdViewListener;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public class AdViewBasicListener implements MobclixAdViewListener {

    @Override
    public void onSuccessfulLoad(MobclixAdView mobclixAdView) {
        mobclixAdView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFailedLoad(MobclixAdView mobclixAdView, int i) {
        Log.e(getClass().getName(), "Ad loading failed : " + i);
        mobclixAdView.setVisibility(View.GONE);
    }

    @Override
    public void onAdClick(MobclixAdView mobclixAdView) {
    }

    @Override
    public boolean onOpenAllocationLoad(MobclixAdView mobclixAdView, int i) {
        return false;
    }

    @Override
    public void onCustomAdTouchThrough(MobclixAdView mobclixAdView, String s) {
    }

    @Override
    public String keywords() {
        return "mobile application android";
    }

    @Override
    public String query() {
        return "query";
    }
}
