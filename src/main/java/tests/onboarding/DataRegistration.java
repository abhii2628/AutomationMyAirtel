package tests.onboarding;

import io.appium.java_client.android.Connection;
import ui.android.AndroidInit;
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

        String network = AndroidInit.driver.getConnection().name();
        MyLogger.log.info("Running on " + network);
        if (network.equals("WIFI")) {
            MyLogger.log.info("User is running on the " + network + " connection");
            AndroidInit.driver.setConnection(Connection.NONE);
            AndroidInit.driver.setConnection(Connection.DATA);
            Thread.sleep(5000);
            myAirtelapp.clearData();
            // myAirtelapp.open();
        }
    }

    @Test
    public void test004() {
        testInfo.suite("DataRegistration").id("004").name("Not giving the access for the Telephony permissions");
        myAirtelapp.onboarding.tapDenyPermission();
    }

 /*       @Test
        public void test005 () {
            if (myAirtelapp.onboarding.uiobject.allowPermission().waitToAppear(15).exists()) {
                testInfo.suite("DataRegistration").id("005").name("Check if the user gets auto logged in");
                myAirtelapp.onboarding.tapDenyPermission();
                MyLogger.log.info("Giving the permission to send messages");
            } else if (myAirtelapp.onboarding.uiobject.enterNumber().exists()) {
                MyLogger.log.info("User is not able to auto register, proceeding with OTP flow");
                //start with OTP registration.
            }
        }*/

    @Test
    public void test006() {
        testInfo.suite("DataRegistration").id("006").name("Check the account card");
        myAirtelapp.onboarding.uiobject.accountCard().waitToAppear(20).exists();
        MyLogger.log.info("User is successfully onboarded to the application");
    }

    @Test
    public void test007() {
        testInfo.suite("DataRegistration").id("007").name("Check the main account card elements.");
        Assert.assertTrue(myAirtelapp.onboarding.uiobject.mainAccountHeader().exists());
        Assert.assertEquals("Me", myAirtelapp.onboarding.uiobject.mainAccountHeader().getText());
        Assert.assertNotNull(myAirtelapp.onboarding.uiobject.mainAccountNumber().getText());
        Assert.assertEquals("A/C BAL.", myAirtelapp.onboarding.uiobject.mainAccountUnit().getText());
        Assert.assertTrue(myAirtelapp.onboarding.uiobject.mainAccountProfileImage().exists());
        MyLogger.log.info("Check the UI elements of the main account card");
    }
}
