package ui.apps.myairtelapp;

import ui.android.AndroidInit;
import ui.interfaces.Application;
import ui.apps.myairtelapp.onboarding.Onboarding;

/**
 * Created by B0095770 on 27/01/17.
 */
public class MyAirtelapp implements Application {

    public Onboarding onboarding = new Onboarding();

    @Override
    public void forceStop() {
        AndroidInit.adb.forceStopApp(packageID());
    }

    @Override
    public Object open() {
        AndroidInit.adb.openAppsActivity(packageID(), activityID());
        return null;
    }

    @Override
    public void clearData() {
        AndroidInit.adb.clearAppData(packageID());
    }

    @Override
    public String packageID() {
        return "com.myairtelapp.debug";
    }

    @Override
    public String activityID() {
        return "com.myairtelapp.activity.OnboardingActivity";
    }

    @Override
    public Integer appVersion() {
        return AndroidInit.adb.getAppVersion(packageID());
    }

    @Override
    public void wifiEnable() {
        AndroidInit.adb.wifiEnable();
    }

    @Override
    public void wifiDisable() {
        AndroidInit.adb.wifiDisable();
    }

    @Override
    public void dataEnable() {
        AndroidInit.adb.dataEnable();
    }

    @Override
    public void dataDisable() {
        AndroidInit.adb.dataDisable();
    }
}
