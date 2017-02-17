package core.managers;

import ui.android.AndroidInit;
import core.MyLogger;
import core.Retry;
import core.TestInfo;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


/**
 * Created by B0095770 on 17/01/17.
 */

public class TestManager {

    public static TestInfo testInfo = new TestInfo();

    @Rule
    public Retry retry = new Retry(2);

    @Before
    public void before() {
        testInfo.reset();
    }

    @Rule
    public TestRule listen = new TestWatcher() {
        @Override
        public void failed(Throwable t, Description description) {
            MyLogger.log.info("Test Failed:");
            AndroidInit.adb.takeScreenshot("path");
            TestInfo.printResults();
        }

        @Override
        public void succeeded(Description description) {
            MyLogger.log.info("Test Passed:");
            TestInfo.printResults();
        }
    };
}
