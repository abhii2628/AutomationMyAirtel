package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.onboarding.OtpRegistration;
import ui.apps.myairtelapp.postpaidPayment.PostPaidPayment;

/**
 * Created by B0095770 on 26/01/17.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
       OtpRegistration.class,
      // DataRegistration.class,
        PostPaidPayment.class
        //Sample.class
})
    public class TestPrimer {}
