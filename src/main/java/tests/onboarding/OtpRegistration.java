package tests.onboarding;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import core.MyLogger;
import core.SkipTest;
import core.constants.Credentials;
import core.managers.TestManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ui.android.AndroidInit;
import ui.apps.myairtelapp.MyAirtelapp;
import ui.apps.myairtelapp.utils.UtilDriver;

/**
 * Created by B0095770 on 25/01/17.
 */
public class OtpRegistration extends TestManager {

    private static MyAirtelapp myairtelapp = AndroidInit.app.myAirtelapp;

    @BeforeClass
    public static void beforeClass() throws InterruptedException {
        String network = AndroidInit.driver.getConnection().name();
        MyLogger.log.info("Running on " + network);
        if (network.equals("DATA")) {
            MyLogger.log.info("User is running on the " + network + " connection");
            AndroidInit.adb.wifiDisable();
        } else if (network.equals("WIFI")) {
            MyLogger.log.info("User is running on the " + network + " connection");
            AndroidInit.adb.dataDisable();
        }
        MyLogger.log.info("Starting the onboarding flow");
        myairtelapp.clearData();
        Thread.sleep(5000);
    }

//    @Before
//    public void before(){
//        if (myairtelapp.onboarding.uiobject.permissopnPopup().exists()){
//            MyLogger.log.info("The telephony permission when always deny coming, tapping on it");
//            myairtelapp.onboarding.tapdenyAlways();
//        }
//        else MyLogger.log.info("Permission popup for always not available, continue with app reg");
//    }


    @Test
    public void test001() {
        testInfo.id("test001").name("Tap deny on the permission popup for telephony");
        Assert.assertTrue(myairtelapp.onboarding.uiobject.denyPermission().waitToAppear(15).isClickable());
        myairtelapp.onboarding.tapDenyPermission();
    }

    @Test
    public void test002() {
        SkipTest.UNLESS(myairtelapp.onboarding.uiobject.enterNumber().exists());
        testInfo.id("test002").name("Check all the text present on the Enter mobile number screen");
        Assert.assertEquals("Enter Mobile Number", myairtelapp.onboarding.uiobject.enterNumber().getText());
        Assert.assertEquals("Please enter your Mobile Number to receive an OTP", myairtelapp.onboarding.uiobject.heading().getText());
        Assert.assertEquals("By continuing, you agree to the Terms & Conditions", myairtelapp.onboarding.uiobject.terms().getText());
        Assert.assertEquals("Request OTP", myairtelapp.onboarding.uiobject.requestOtp().getText());
    }

    @Test
    public void test003() {
        Assert.assertTrue(myairtelapp.onboarding.uiobject.enterNumber().exists());
        Assert.assertTrue(myairtelapp.onboarding.uiobject.enterNumber().isClickable());
        myairtelapp.onboarding.uiobject.enterNumber().waitToAppear(15).tap();
        myairtelapp.onboarding.uiobject.enterNumber().typeText(Credentials.prepaidNumber);
    }

    @Test
    public void test004() {
        testInfo.id("test004").name("Check if the user is able to tap on the Request OTP button");
        Assert.assertEquals("Request OTP", myairtelapp.onboarding.uiobject.requestOtp().getText());
        myairtelapp.onboarding.tapRequestOtp();
    }

    @Test
    public void test005() {
        testInfo.id("test005").name("Tap Deny on the permission popup for SMS");
        myairtelapp.onboarding.tapDenyPermission();
    }

    @Test
    public void test006() {
        testInfo.id("test006").name("Check all the text present on the OTP verification screen");
        Assert.assertEquals("Please enter the OTP sent to", myairtelapp.onboarding.uiobject.heading().waitToAppear(30).getText());
        Assert.assertTrue(myairtelapp.onboarding.uiobject.editNumber().exists());
    }

    @Test
    public void test007() throws InterruptedException {
       // SkipTest.UNLESS(AndroidInit.adb.getAndroidVersionAsString().equals("6.0"));
        UtilDriver.readMsgs();
    }

  /*  @Test
    public void test008() {
        testInfo.id("test008").name("Enter the OTP for white listed number");
        myairtelapp.onboarding.uiobject.numpad().waitToAppear(15).tap();
        myairtelapp.onboarding.uiobject.numpad().tap();
        myairtelapp.onboarding.uiobject.numpad().tap();
        myairtelapp.onboarding.uiobject.numpad().tap();
    }*/

    @Test
    public void test009() {
        SkipTest.UNLESS(myairtelapp.onboarding.uiobject.skipReferal().waitToAppear(10).exists());
        testInfo.id("test009").name("Check if the referral screen comes and tap on Skip");
        myairtelapp.onboarding.tapSkipReferal();
    }

    @Test
    public void test010() {
        testInfo.id("test010").name("Check if the permission popup for contacts comes");
        Assert.assertTrue(myairtelapp.onboarding.uiobject.denyPermission().waitToAppear(60).exists());
        myairtelapp.onboarding.tapDenyPermission();
    }

    @Test
    public void test011() {
        testInfo.id("test011").name("Check if the pager has My airtel tab present");
        Assert.assertTrue(myairtelapp.onboarding.uiobject.myAirtelTab().exists());
        Assert.assertEquals("MY AIRTEL", myairtelapp.onboarding.uiobject.myAirtelTab().getText());
        MyLogger.log.info("My Airtel tab is present, user landed on the home screen, Onboarding successful");
    }

    @Test
    public void test012() {
        SkipTest.UNLESS(myairtelapp.onboarding.uiobject.payNow().exists());
        testInfo.id("test012").name("Check if the logged number is prepaid or postpaid");
        Assert.assertEquals("PAY NOW", myairtelapp.onboarding.uiobject.payNow().waitToAppear(60).getText());
        MyLogger.log.info("The logged in number is postpaid.");
    }

    @Test
    public void test013() {
        SkipTest.UNLESS(myairtelapp.onboarding.uiobject.morePlans().exists());
        testInfo.id("test013").name("Check if the logged number is prepaid or postpaid");
        Assert.assertEquals("PAY NOW", myairtelapp.onboarding.uiobject.morePlans().waitToAppear(60).getText());
        MyLogger.log.info("The logged in number is postpaid.");
    }

    @Test
    public void test014() {
        testInfo.id("014").name("Check the main account card elements for postpaid");
        Assert.assertEquals("Me", myairtelapp.onboarding.uiobject.mainAccountHeader().getText());
        Assert.assertNotNull(myairtelapp.onboarding.uiobject.mainAccountNumber().getText());
        Assert.assertTrue(myairtelapp.onboarding.uiobject.mainAccountProfileImage().exists());
        MyLogger.log.info("Check the UI elements of the main account card");
    }

}
