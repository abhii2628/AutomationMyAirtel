package tests.onboarding;

import core.MyLogger;
import core.managers.TestManager;
import org.junit.BeforeClass;
import ui.android.AndroidInit;
import ui.apps.myairtelapp.MyAirtelapp;

/**
 * Created by B0095770 on 25/02/17.
 */
public class RegistrationUtil extends TestManager {

   private static MyAirtelapp myairtelapp = AndroidInit.app.myAirtelapp;

        @BeforeClass
        public static void beforeClass() throws InterruptedException {
            String network = AndroidInit.driver.getConnection().name();
            if (network.equals("DATA")){
                MyLogger.log.info("User is running on the " +network+ "connection");
            }
            else if (network.equals("WIFI")){
                MyLogger.log.info("User is running on the " +network+ "connection");
            }
            MyLogger.log.info("Starting the onboarding flow");
            Thread.sleep(5000);
        }

   /* private void otpRegistration() throws InterruptedException {
        try{
            MyLogger.log.info("OTP registration flow");
            AndroidInit.app.myAirtelapp.onboarding.tapDenyPermission();
           // AndroidInit.app.myAirtelapp.onboarding.enterMobileNumber();
            AndroidInit.app.myAirtelapp.onboarding.tapRequestOtp();
            tapDenyPermission();
            Thread.sleep(5000);
            enterOtpManually();
            tapSkipReferal();
            tapdenyAlways();
            tapDenyPermission();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }*/
}
