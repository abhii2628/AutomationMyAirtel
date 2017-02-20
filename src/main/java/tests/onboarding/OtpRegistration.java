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
        testInfo.id("test002").name("Check all the text present on the Enter mobile number screen");
        Assert.assertEquals("Enter Mobile Number", myairtelapp.onboarding.uiobject.enterNumber().getText());
        Assert.assertEquals("Please enter your Mobile Number to receive an OTP", myairtelapp.onboarding.uiobject.heading().getText());
        Assert.assertEquals("By continuing, you agree to the Terms & Conditions",myairtelapp.onboarding.uiobject.terms().getText());
        Assert.assertEquals("Request OTP",myairtelapp.onboarding.uiobject.requestOtp().getText());
    }

    @Test
    public void test003(){
        testInfo.id("test003").name("Enter mobile number for onboarding");
        Assert.assertTrue(myairtelapp.onboarding.uiobject.enterNumber().exists());
        Assert.assertTrue(myairtelapp.onboarding.uiobject.enterNumber().isClickable());
        myairtelapp.onboarding.uiobject.enterNumber().tap();
        myairtelapp.onboarding.uiobject.enterNumber().waitToAppear(15).typeText(Credentials.postpaidNumber);
    }

    @Test
    public void test004(){
        testInfo.id("test004").name("Check if the user is able to tap on the Request OTP button");
        //Assert.assertEquals("Request OTP",myairtelapp.onboarding.uiobject.requestOtp().getText());
        myairtelapp.onboarding.tapRequestOtp();
    }

    @Test
    public void test005() {
        testInfo.id("test001").name("Tap Allow on the permission popup for SMS");
       // Assert.assertTrue(myairtelapp.onboarding.uiobject.allowPermission().isClickable());
        myairtelapp.onboarding.tapAllowPermission();
    }

    @Test
    public void test008(){
        testInfo.id("test008").name("Check all the text present on the OTP verification screen");
        myairtelapp.onboarding.uiobject.heading().waitToAppear(30);
        Assert.assertEquals("Please enter the OTP sent to",myairtelapp.onboarding.uiobject.heading().getText());
        Assert.assertTrue(myairtelapp.onboarding.uiobject.editNumber().exists());
    }

    @Test
    public void test009(){
        testInfo.id("test009").name("Enter the OTP for white listed number");
        myairtelapp.onboarding.uiobject.inputOtp().typeText("1111");
    }

    @Test
    public void test010(){
        testInfo.id("test001").name("Check if the referral screen comes and tap on Skip");
        Assert.assertTrue(myairtelapp.onboarding.uiobject.skipReferal().exists());
        Assert.assertEquals("SKIP",myairtelapp.onboarding.uiobject.skipReferal().getText());
        myairtelapp.onboarding.tapSkipReferal();
    }

    @Test
    public void test011(){
        testInfo.id("test001").name("Check if the permission popup for contacts comes");
        Assert.assertTrue(myairtelapp.onboarding.uiobject.allowPermission().exists());
        myairtelapp.onboarding.tapAllowPermission();
    }

    @Test
    public void test012(){
        testInfo.id("test001").name("Check if the permission popup for SMS comes");
        Assert.assertTrue(myairtelapp.onboarding.uiobject.allowPermission().exists());
        myairtelapp.onboarding.tapAllowPermission();
    }

    @Test
    public void test013(){
        testInfo.id("test001").name("Check if the pager has My airtel tab present");
        Assert.assertTrue(myairtelapp.onboarding.uiobject.myAirtelTab().exists());
        MyLogger.log.info("My Airtel tab is present, user landed on the home screen, Onboarding successful");
    }
}
