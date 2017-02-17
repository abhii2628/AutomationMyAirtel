package tests.onboarding;

import ui.apps.myairtelapp.MyAirtelapp;
import core.MyLogger;
import core.managers.TestManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by B0095770 on 25/01/17.
 */
public class DataRegistration extends TestManager {

    private static MyAirtelapp myAirtelapp = new MyAirtelapp();

    @BeforeClass
    public static void beforeClass() throws InterruptedException {
        myAirtelapp.open();
        Thread.sleep(5000);
    }

    @Test
    public void test001() {
        testInfo.suite("DataRegistration").id("001").name("Clear the app data");
        myAirtelapp.clearData();
        MyLogger.log.info("Clearing the app data");
    }

    @Test
    public void test002() {
        testInfo.suite("DataRegistration").id("002").name("Enable the wifi connection");
        myAirtelapp.dataEnable();
        MyLogger.log.info("Enabling the data connection of the device");
    }

    @Test
    public void test003() {
        testInfo.suite("DataRegistration").id("003").name("Disable the wifi connection");
        myAirtelapp.wifiDisable();
        MyLogger.log.info("Disable the wifi connection of the device");
    }

    @Test
    public void test004() throws InterruptedException {
        testInfo.suite("DataRegistration").id("004").name("Tap on Allow permission popup");
        myAirtelapp.onboarding.tapAllowPermission();
        MyLogger.log.info("Giving the access for the Telephony permissions");
        Thread.sleep(10000);
    }

    @Test
    public void test005() {
        if (myAirtelapp.onboarding.uiobject.allowPermission().waitToAppear(15000).exists()) {
            testInfo.suite("DataRegistration").id("005").name("Check if the user gets auto logged in");
            myAirtelapp.onboarding.tapAllowPermission();
            MyLogger.log.info("Giving the permission to send messages");
        } else if (myAirtelapp.onboarding.uiobject.enterNumber().exists()) {
            MyLogger.log.info("User is not able to auto register, proceeding with OTP flow");
            //start with OTP registration.
        }
    }

    @Test
    public void test006() {
        testInfo.suite("DataRegistration").id("006").name("Check the account card");
        myAirtelapp.onboarding.checkAccountCard();
        MyLogger.log.info("User is successfully onboarded to the application");
    }

    @Test
    public void test007() {
        testInfo.suite("DataRegistration").id("007").name("Check the main account card elements.");
        Assert.assertTrue(myAirtelapp.onboarding.uiobject.mainAccountHeader().exists());
        Assert.assertEquals("Me",myAirtelapp.onboarding.uiobject.mainAccountHeader().getText());
        Assert.assertNotNull(myAirtelapp.onboarding.uiobject.mainAccountNumber().getText());
        Assert.assertEquals("A/C BAL.",myAirtelapp.onboarding.uiobject.mainAccountUnit().getText());
        Assert.assertTrue(myAirtelapp.onboarding.uiobject.mainAccountProfileImage().exists());
        MyLogger.log.info("Check the UI elements of the main account card");
    }


}
