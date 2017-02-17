import core.MyLogger;
import core.managers.DriverManager;
import org.apache.log4j.Level;
import org.junit.runner.JUnitCore;
import tests.TestPrimer;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by B0095770 on 17/01/17.
 */
public class Runner {

    public static void main(String[] args) throws MalformedURLException {

        MyLogger.log.setLevel(Level.INFO);
        try {
            ClassLoader classLoader = Runner.class.getClassLoader();
            URL resource = classLoader.getResource("ui/android/AndroidInit.class");
            System.out.println("HTTP CORE ------------- "+resource);

            DriverManager.createDriver();
            JUnitCore.runClasses(TestPrimer.class);
            // WifiOnboardingTest.otpRegistration();

        } finally {
         DriverManager.killDriver();
        }
    }
}



//Test case for login
//            AndroidInit.app.myairtel.open();
            /*AndroidInit.app.myairtel.onboarding.tapDenyPermission();
            AndroidInit.app.myairtel.onboarding.enterMobileNumber();
            AndroidInit.app.myairtel.onboarding.tapRequestOtp();
            AndroidInit.app.myairtel.onboarding.tapDenyPermission();
            AndroidInit.app.myairtel.onboarding.enterOtp();
            AndroidInit.app.myairtel.onboarding.tapSkipReferal();
            AndroidInit.app.myairtel.onboarding.tapDenyPermission();
            AndroidInit.app.myairtel.onboarding.checkAccountCard();
*/