package tests.onboarding;

import ui.android.AndroidInit;
import ui.apps.myairtelapp.MyAirtelapp;
import core.MyLogger;
import core.managers.TestManager;
import org.junit.Assert;

import core.constants.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by B0095770 on 25/01/17.
 */
public class OtpRegistration extends TestManager{

    private static MyAirtelapp myairtelapp = AndroidInit.app.myAirtelapp;

    @BeforeClass
    public static void beforeClass() throws InterruptedException {
        myairtelapp.open();
        Thread.sleep(5000);
    }

    @Test
    public void test001() {
        testInfo.id("test001").name("Tap deny on the permission popup for telephony");
        Assert.assertTrue(myairtelapp.onboarding.uiobject.denyPermission().isClickable());
        myairtelapp.onboarding.tapDenyPermission();
    }

    @Test
    public void test002(){
        testInfo.id("test002").name("Check if the Enter Mobile number screen appears and is clickable");
        Assert.assertTrue(myairtelapp.onboarding.uiobject.enterNumber().exists());
        Assert.assertTrue(myairtelapp.onboarding.uiobject.enterNumber().isClickable());
    }

    @Test
    public void test003(){
        testInfo.id("test003").name("Check all the text present on the Enter mobile number screen");
        Assert.assertEquals("Enter Mobile Number", myairtelapp.onboarding.uiobject.enterNumber().getText());
        Assert.assertEquals("Please enter your Mobile Number to receive an OTP", myairtelapp.onboarding.uiobject.heading().getText());
        Assert.assertEquals("By continuing, you agree to the Terms & Conditions",myairtelapp.onboarding.uiobject.terms().getText());
        Assert.assertEquals("Request OTP",myairtelapp.onboarding.uiobject.requestOtp().getText());

    }

    @Test
    public void test005(){
        testInfo.id("test005").name("Check if the user is able to enter Mobile number");
        myairtelapp.onboarding.uiobject.enterNumber().typeText(Credentials.postpaidNumber);
        MyLogger.log.info("Entering the mobile number for registration");
    }

    @Test
    public void test006(){
        testInfo.id("test006").name("Check if the user is able to tap on the Request OTP button");
        Assert.assertEquals("Request OTP",myairtelapp.onboarding.uiobject.requestOtp().getText());
        myairtelapp.onboarding.uiobject.requestOtp().tap();
    }

    @Test
    public void test007(){
        testInfo.id("test007").name("Check if the permission popup for SMS comes");
        Assert.assertTrue(myairtelapp.onboarding.uiobject.denyPermission().exists());
        myairtelapp.onboarding.uiobject.denyPermission().tap();
    }

    @Test
    public void test008(){
        testInfo.id("test008").name("Check all the text present on the OTP verification screen");
        Assert.assertEquals("Please enter the OTP sent to",myairtelapp.onboarding.uiobject.heading().getText());
        Assert.assertTrue(myairtelapp.onboarding.uiobject.editNumber().exists());
    }

    @Test
    public void test009(){
        testInfo.id("test009").name("Enter the OTP for whitelisted number");
        myairtelapp.onboarding.uiobject.inputOtp().typeText("1111");
    }

    @Test
    public void test010(){
        testInfo.id("test001").name("Check if the referral screen comes and tap on Skip");
        Assert.assertTrue(myairtelapp.onboarding.uiobject.skipReferal().exists());
        Assert.assertEquals("SKIP",myairtelapp.onboarding.uiobject.skipReferal().getText());
        myairtelapp.onboarding.uiobject.skipReferal().tap();
    }

    @Test
    public void test011(){
        testInfo.id("test001").name("Check if the permission popup for contacts comes");
        Assert.assertTrue(myairtelapp.onboarding.uiobject.denyPermission().exists());
        myairtelapp.onboarding.tapDenyPermission();
    }

    @Test
    public void test012(){
        testInfo.id("test001").name("Check if the permission popup for SMS comes");
        Assert.assertTrue(myairtelapp.onboarding.uiobject.denyPermission().exists());
        myairtelapp.onboarding.tapDenyPermission();
    }

    @Test
    public void test013(){
        testInfo.id("test001").name("Check if the pager has My airtel tab present");
        Assert.assertTrue(myairtelapp.onboarding.uiobject.myAirtelTab().exists());
        MyLogger.log.info("My Airtel tab is present, user landed on the home screen, Payments successful");
    }
}
