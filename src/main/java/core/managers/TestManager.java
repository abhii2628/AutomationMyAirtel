package core.managers;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import core.MyLogger;
import core.Retry;
import core.TestInfo;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ui.android.AndroidInit;
import ui.apps.myairtelapp.utils.UtilDriver;

import java.io.File;
import java.io.IOException;


/**
 * Created by B0095770 on 17/01/17.
 */

public class TestManager {

    public static TestInfo testInfo = new TestInfo();
    private static String bn = "152";
    private String filenameOfReport = "/Users/abhishek/Desktop/reports/testRun" + ".html";

    @Rule
    public Retry retry = new Retry(1);

    @Rule
    public TestRule listen = new TestWatcher() {

        @Override
        public void failed(Throwable t, Description description) {
            MyLogger.log.info("Test Failed:");
            AndroidInit.adb.takeScreenshot("/Users/abhishek/Desktop/screenshots" + System.currentTimeMillis() + ".png");
            TestInfo.printResults();
            ExtentReports extent = createReport();
            ExtentTest test = extent.startTest(description.getDisplayName(), testInfo.name());
            // step log
            test.log(LogStatus.FAIL, t.toString(), description.getClassName());
            //test.log(LogStatus.FAIL, t.getStackTrace().toString(),description.getClassName());
            test.addScreenCapture(UtilDriver.CaptureScreen(AndroidInit.driver,"/Users/abhishek/Desktop/screenshots/") +System.currentTimeMillis());
            flushReports(extent, test);
        }

        @Override
        public void succeeded(Description description) {
            MyLogger.log.info("Test Passed:");
            TestInfo.printResults();
            AndroidInit.adb.takeScreenshot("/Users/abhishek/Desktop/screenshots" + System.currentTimeMillis() + ".png");
            ExtentReports extent = createReport();
            ExtentTest test = extent.startTest(description.getDisplayName(), testInfo.name());
            // step log
            test.log(LogStatus.PASS, "Test passed");
            test.addScreenCapture(UtilDriver.CaptureScreen(AndroidInit.driver,"/Users/abhishek/Desktop/screenshots/") +System.currentTimeMillis());
            flushReports(extent, test);
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            MyLogger.log.info("Test Failed:");
            AndroidInit.adb.takeScreenshot("/Users/abhishek/Desktop/screenshots" + System.currentTimeMillis() + ".png");
            TestInfo.printResults();
            ExtentReports extent = createReport();
            ExtentTest test = extent.startTest(description.getDisplayName(), "Test skipped due to the logic written");
            // step log
            test.log(LogStatus.SKIP, "Failure trace Appium: " + e.toString());
            test.log(LogStatus.SKIP, e.toString(), description.getClassName());
            test.addScreenCapture("/Users/abhishek/Desktop/screenshots");
            flushReports(extent, test);
        }

        private ExtentReports createReport() {
            //ExtentReports extent= new ExtentReports(System.getProperty("user.dir") + "/test-output/FirstReport.html", false);
            ExtentReports extent = new ExtentReports(filenameOfReport, false);
            extent.addSystemInfo("Environment", "ApiTest2cloud")
                    .addSystemInfo("User Name", "Abhishek Gupta")
                    .addSystemInfo("Device Model", AndroidInit.adb.getDeviceModel())
                    .addSystemInfo("OS version", AndroidInit.adb.getAndroidVersionAsString())
                    .addSystemInfo("Device Manufacturer", AndroidInit.adb.getDeviceManufacturer())
                    .addSystemInfo("Build number", bn);
            extent.loadConfig(new File(System.getProperty("user.dir") + "/src/resources/LoadConfig.xml"));
            return extent;
        }

        private void flushReports(ExtentReports extent, ExtentTest test) {
            // ending test
            extent.endTest(test);
            // writing everything to document and closing the instance of Extent test
            extent.flush();
            extent.close();
        }


    /*    private String getDateTime() {
            Date date = Calendar.getInstance().getTime();
            // Display a date in day, month, year format
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
            String today = formatter.format(date);
            MyLogger.log.info("Date is " + today);
            return today;
        }

*/
    };



}

