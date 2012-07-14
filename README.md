Android Utils
==============

Made by Lukas for Siu.


Configuration
--------------

*	In the root of the main project : "git submodule add git@github.com:Siu-soon/Android-Utils.git libs/andutils"
*	Import actionbarsherlock module in intellij
*	Import andutils module in intellij


Res
-------------

Add the conf_googleanalytics.xml file in res/values :

	<resources>
		<string name="ga_api_key">UA–xxx</string>
		<bool name="ga_debug">false</bool>
		<bool name="ga_dryRun">false</bool>
		<bool name="ga_auto_activity_tracking">false</bool>
		<bool name="ga_anonymizeIp">false</bool>
		<integer name="ga_sampleRate">100</integer>
		<integer name="ga_dispatchPeriod">60</integer>
	</resources>




AndroidManifest.xml
--------------------

#### ActionBarSherlock :

	<application android:name="com.siu.android.andutils.Application" android:theme="@style/Theme.Sherlock.*">


#### Internet :

	<uses-permission android:name="android.permission.INTERNET"/>
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
	<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>


#### Location :

	<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
	<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>


#### Mobclix ads :

	<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
	<application ...>
		<meta-data android:name="com.mobclix.APPLICATION_ID" android:value="APP_ID"/>
		<activity android:name="com.mobclix.android.sdk.MobclixBrowserActivity" android:theme="@android:style/Theme.Translucent.NoTitleBar"/>
	</application>


### Airpush :

	<!-- Airpush Code Start-->
    <activity android:name="com.airpush.android.PushAds" android:configChanges="orientation|keyboardHidden"/>
    <receiver android:name="com.airpush.android.UserDetailsReceiver"/>
    <receiver android:name="com.airpush.android.MessageReceiver" />
    <receiver android:name="com.airpush.android.DeliveryReceiver" />
    <receiver android:name="<Package Name>.BootReceiver">
		<intent-filter>
    		<action android:name="android.intent.action.BOOT_COMPLETED" />
    		<category android:name="android.intent.category.HOME" />
    	</intent-filter>
    </receiver>

    <service android:name="com.airpush.android.PushService">
		<intent-filter>
			<action android:name="com.airpush.android.PushServiceStart<PACKAGE>"/>
    	<intent-filter>
	</service>
    <!-- Airpush Code End-->

    <uses-permission android:name="android.permission.INTERNET" />
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
	<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
	<uses-permission android:name="android.permission.READ_PHONE_STATE" />
	<uses-permission android:name="android.permission.VIBRATE" />
	<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>



Airpush ads
------------

### AndroidManifest.xml :

	<!-- Airpush Code Start-->
    <activity android:name="com.airpush.android.PushAds" android:configChanges="orientation|keyboardHidden"/>
    <receiver android:name="com.airpush.android.UserDetailsReceiver"/>
    <receiver android:name="com.airpush.android.MessageReceiver" />
    <receiver android:name="com.airpush.android.DeliveryReceiver" />
    <receiver android:name="com.siu.android.andutils.receiver.AirPushBootReceiver">
		<intent-filter>
    		<action android:name="android.intent.action.BOOT_COMPLETED" />
    		<category android:name="android.intent.category.HOME" />
    	</intent-filter>
    </receiver>

    <service android:name="com.airpush.android.PushService">
		<intent-filter>
			<action android:name="com.airpush.android.PushServiceStart<APPID>"/>
    	<intent-filter>
	</service>
    <!-- Airpush Code End-->

    <uses-permission android:name="android.permission.INTERNET" />
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
	<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
	<uses-permission android:name="android.permission.READ_PHONE_STATE" />
	<uses-permission android:name="android.permission.VIBRATE" />
	<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>


### conf_airpush :

    <string name="ads_airpush_app">API_ID</string>
	<string name="ads_airpush_api">API_KEY</string>
	<bool name="ads_airpush_debug">true</bool>


Classes
--------

### TrackedSherlock*

Add the EasyTracker logic and add the indeterminate progress.
You need to override onCreate(Bundle savedInstanceState, int layout) instead of onCreate(Bundle savedInstanceState)

### AdsSherlock*

Extends TrackedSherlock* classes and add the moblclix ads logic.