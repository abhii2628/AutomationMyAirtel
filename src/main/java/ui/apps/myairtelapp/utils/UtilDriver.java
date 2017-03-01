package ui.apps.myairtelapp.utils;

import core.MyLogger;
import core.UiObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.android.AndroidInit;
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
            }catch (Exception e) {
            e.printStackTrace();
        }
        List<WebElement> msg = AndroidInit.driver.findElements(By.id("com.android.mms:id/list_item_container"));
        String pop = msg.get(msg.size() - 1).findElement(By.id("com.android.mms:id/list_item_text_view")).getText();
        String numberOnly = pop.replaceAll("[^0-9]", "");
        String otp = numberOnly.substring(0, 4);
        MyLogger.log.info("Your OTP is : " + otp);
        AndroidInit.driver.navigate().back();
        AndroidInit.driver.navigate().back();
        AndroidInit.app.myAirtelapp.onboarding.uiobject.inputOtp().typeText(otp);
    }
}
