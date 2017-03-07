package ui.apps.myairtelapp.utils;

import core.MyLogger;
import core.UiObject;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import ui.android.AndroidInit;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by B0095770 on 25/02/17.
 */
public class UtilDriver {

    public static void readMsgs() throws InterruptedException {

        Thread.sleep(3000);
        AndroidInit.driver.openNotifications();
        AndroidInit.app.myAirtelapp.onboarding.uiobject.notification().waitToAppear(20).tap();
        UiObject otpmsg = AndroidInit.app.myAirtelapp.onboarding.uiobject.messageRead();

        try {
            if (otpmsg.exists()) {
                MyLogger.log.info("Trying to read the messages");
                otpmsg.tap();
            } else MyLogger.log.info("The OTP was not received within the time specified");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<WebElement> msg = AndroidInit.driver.findElements(By.id("com.android.mms:id/list_item_container"));
        String pop = msg.get(msg.size() - 1).findElement(By.id("com.android.mms:id/list_item_text_view")).getText();
        String numberOnly = pop.replaceAll("[^0-9]", "");
        String otp = numberOnly.substring(0, 4);
        MyLogger.log.info("Your OTP is : " + otp);

        AndroidInit.driver.navigate().back();
        AndroidInit.driver.navigate().back();

        // Typing the OTP in the numpad.
        List<WebElement> abc = AndroidInit.driver.findElements(By.id("com.myairtelapp.debug:id/tv_numpad"));
        for (int i = 0; i < 10; i++) {
            MyLogger.log.info("The printed blah blah is " + abc.get(i).getText());
            for (int j = 0; j < 4; j++) {
                if (abc.get(i).getText().equals(otp.substring(j))) {
                    MyLogger.log.info("Typing on the " + otp.substring(j));
                    abc.get(i).click();
                }
            }
        }
    }

    public static String CaptureScreen(AndroidDriver driver, String ImagesPath)
    {
        TakesScreenshot oScn = (TakesScreenshot) driver;
        File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
        File oDest = new File(ImagesPath+".jpg");
        try {
            FileUtils.copyFile(oScnShot, oDest);
        } catch (IOException e) {MyLogger.log.info(e.getMessage());}
        return ImagesPath+".jpg";
    }
}
