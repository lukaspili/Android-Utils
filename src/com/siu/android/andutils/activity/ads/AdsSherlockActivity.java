package com.siu.android.andutils.activity.ads;

import android.os.Bundle;
import com.mobclix.android.sdk.MobclixAdView;
import com.siu.android.andutils.R;
import com.siu.android.andutils.activity.tracker.TrackedSherlockActivity;
import com.siu.android.andutils.ads.AdViewBasicListener;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public class AdsSherlockActivity extends TrackedSherlockActivity {

    protected MobclixAdView adBannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState, int layout) {
        super.onCreate(savedInstanceState, layout);
        initAds();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (null != adBannerView) {
            adBannerView.resume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (null != adBannerView) {
            adBannerView.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (null != adBannerView) {
            adBannerView.destroy();
        }
    }

    protected void initAds() {
        adBannerView = (MobclixAdView) findViewById(R.id.ad_banner_view);
        adBannerView.addMobclixAdViewListener(new AdViewBasicListener());
    }
}
