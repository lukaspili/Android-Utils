Android Utils
==============

Configuration
--------------

* In the root of the main project : "git submodule add git@github.com:Siu-soon/Android-Utils.git libs/andutils"

* Import actionbarsherlock module in intellij

* Import andutils module in intellij



Modifications
-------------

1. Add the conf_googleanalytics.xml file in res/values :

<resources>
    <string name="ga_api_key">UA–xxx</string>
    <bool name="ga_debug">false</bool>
    <bool name="ga_dryRun">false</bool>
    <bool name="ga_auto_activity_tracking">false</bool>
    <bool name="ga_anonymizeIp">false</bool>
    <integer name="ga_sampleRate">100</integer>
    <integer name="ga_dispatchPeriod">60</integer>
</resources>


2. Add an attribute in <application> tag in AndroidManifest.xml file : "android:theme="Theme.Sherlock.*"



AndroidManifest.xml
--------------------

ActionBarSherlock :
<application android:name="com.siu.android.andutils.Application" android:theme="@style/Theme.Sherlock.*">

Internet :
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>


Location :
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>

Mobclix ads :
<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
<application ...>
	<meta-data android:name="com.mobclix.APPLICATION_ID" android:value="APP_ID"/>
    <activity android:name="com.mobclix.android.sdk.MobclixBrowserActivity" android:theme="@android:style/Theme.Translucent.NoTitleBar"/>
</application>