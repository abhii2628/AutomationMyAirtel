package ui.apps.myairtelapp.onboarding;

import ui.android.AndroidInit;
import ui.apps.myairtelapp.MyAirtelapp;

/**
 * Created by B0095770 on 27/01/17.
 */
public class WifiOnboardingTest {

    public static void otpRegistration() throws InterruptedException {
        MyAirtelapp myairtelapp = AndroidInit.app.myAirtelapp;
        myairtelapp.open();
        myairtelapp.onboarding.denyAlways();
        myairtelapp.onboarding.tapDenyPermission();
        myairtelapp.onboarding.checkAccountCard();
        myairtelapp.onboarding.tapPayNow();
        myairtelapp.onboarding.tapAmount();
        myairtelapp.onboarding.tapOk();
        myairtelapp.onboarding.scrollToAxis();
        myairtelapp.onboarding.payText();

    }

    public static void dataRegistration() throws InterruptedException {
        MyAirtelapp myairtelapp = AndroidInit.app.myAirtelapp;

        myairtelapp.clearData();
        AndroidInit.adb.dataEnable();
        Thread.sleep(5000);
        myairtelapp.onboarding.denyAlways();
        myairtelapp.onboarding.tapDenyPermission();
        myairtelapp.onboarding.checkAccountCard();
        myairtelapp.onboarding.tapManageAccount();
        myairtelapp.onboarding.tapAccountBalance();
        myairtelapp.onboarding.tapRechargeNow();
        myairtelapp.onboarding.tapAmount();
        myairtelapp.onboarding.tapOk();
        myairtelapp.onboarding.scrollToAxis();
    }
}
