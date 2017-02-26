package tests.onboarding;

import core.MyLogger;
import org.junit.Test;
import ui.android.AndroidInit;

/**
 * Created by B0095770 on 25/02/17.
 */
public class Sample {

    @Test
    public void test011(){
       String network = AndroidInit.driver.getConnection().name();
       MyLogger.log.info(network);
        if (network.equals("DATA")){
            AndroidInit.adb.dataDisable();
        }
    }
}
