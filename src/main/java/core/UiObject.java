package core;

import ui.android.AndroidInit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

/**
 * Created by B0095770 on 17/01/17.
 */
public class UiObject {

    private String locator;

    UiObject(String locator) {
        this.locator = locator;
        MyLogger.log.info("Created new UI Object with: " + this.locator);
    }

    private boolean isxPath() {
        return !locator.contains("UiSelector");
    }

    public boolean exists() {
        try {
            WebElement element;
            if (isxPath()) element = AndroidInit.driver.findElementByXPath(locator);
            else element = AndroidInit.driver.findElementByAndroidUIAutomator(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isChecked() {
        WebElement element;
        if (isxPath()) element = AndroidInit.driver.findElementByXPath(locator);
        else element = AndroidInit.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("checked").equals("true");
    }

    public boolean isCheckable() {
        WebElement element;
        if (isxPath()) element = AndroidInit.driver.findElementByXPath(locator);
        else element = AndroidInit.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("checkable").equals("true");

    }

    public boolean isClickable() {
        try {
            WebElement element;
            if (isxPath()) element = AndroidInit.driver.findElementByXPath(locator);
            else element = AndroidInit.driver.findElementByAndroidUIAutomator(locator);
            return element.getAttribute("clickable").equals("true");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isEnabled() {
        try {
            WebElement element;
            if (isxPath()) element = AndroidInit.driver.findElementByXPath(locator);
            else element = AndroidInit.driver.findElementByAndroidUIAutomator(locator);
            return element.getAttribute("enabled").equals("true");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isFocusable() {
        try {
            WebElement element;
            if (isxPath()) element = AndroidInit.driver.findElementByXPath(locator);
            else element = AndroidInit.driver.findElementByAndroidUIAutomator(locator);
            return element.getAttribute("focusable").equals("true");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isFocused() {
        try {
            WebElement element;
            if (isxPath()) element = AndroidInit.driver.findElementByXPath(locator);
            else element = AndroidInit.driver.findElementByAndroidUIAutomator(locator);
            return element.getAttribute("focused").equals("true");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isScrollable() {
        try {
            WebElement element;
            if (isxPath()) element = AndroidInit.driver.findElementByXPath(locator);
            else element = AndroidInit.driver.findElementByAndroidUIAutomator(locator);
            return element.getAttribute("scrollable").equals("true");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isLongClickable() {
        try {
            WebElement element;
            if (isxPath()) element = AndroidInit.driver.findElementByXPath(locator);
            else element = AndroidInit.driver.findElementByAndroidUIAutomator(locator);
            return element.getAttribute("longClickable").equals("true");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isSelected() {
        try {
            WebElement element;
            if (isxPath()) element = AndroidInit.driver.findElementByXPath(locator);
            else element = AndroidInit.driver.findElementByAndroidUIAutomator(locator);
            return element.getAttribute("selected").equals("true");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Point getLocation() {
        WebElement element;
        if (isxPath()) element = AndroidInit.driver.findElementByXPath(locator);
        else element = AndroidInit.driver.findElementByAndroidUIAutomator(locator);
        return element.getLocation();
    }

    public String getText() {
        WebElement element;
        if (isxPath()) element = AndroidInit.driver.findElementByXPath(locator);
        else element = AndroidInit.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("name");
    }

    public String getResourceId() {
        WebElement element;
        if (isxPath()) element = AndroidInit.driver.findElementByXPath(locator);
        else element = AndroidInit.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("resourceId");
    }

    public String getClassName() {
        WebElement element;
        if (isxPath()) element = AndroidInit.driver.findElementByXPath(locator);
        else element = AndroidInit.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("className");
    }

    public String getContentDesc() {
        WebElement element;
        if (isxPath()) element = AndroidInit.driver.findElementByXPath(locator);
        else element = AndroidInit.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("contentDesc");
    }

    public UiObject clearText() {
        if (isxPath()) AndroidInit.driver.findElementByXPath(locator).clear();
        else AndroidInit.driver.findElementByAndroidUIAutomator(locator).clear();
        return this;
    }

    public UiObject typeText(String value) {
        if (isxPath()) AndroidInit.driver.findElementByXPath(locator).sendKeys(value);
        else AndroidInit.driver.findElementByAndroidUIAutomator(locator).sendKeys(value);
        return this;
    }

    public UiObject tap() {
        waitToAppear(3);
        if (isxPath()) AndroidInit.driver.findElementByXPath(locator).click();
        else AndroidInit.driver.findElementByAndroidUIAutomator(locator).click();
        return this;
    }

    public UiObject tapString(String value) {
        if (isxPath()) AndroidInit.driver.findElementByXPath(locator).click();
        else AndroidInit.driver.findElementByAndroidUIAutomator(locator).click();
        return this;
    }

    public UiObject scroll(String SwipeDirection) {
        Dimension size = AndroidInit.driver.manage().window().getSize();
        MyLogger.log.info("The device size is " + size);

        if (SwipeDirection.equalsIgnoreCase("Up")) {

            AndroidInit.driver.swipe((int) (size.width * 0.8), (int) (size.height * 0.8), (int) (size.width * 0.8), (int) (size.height * 0.225), 4000);
        } else if (SwipeDirection.equalsIgnoreCase("Down")) {
            AndroidInit.driver.swipe((int) (size.width * 0.8), (int) (size.height * 0.225), (int) (size.width * 0.8), (int) (size.height * 0.8), 4000);
            MyLogger.log.info("Swiping in the Downward direction");
        } else if (SwipeDirection.equalsIgnoreCase("Right")) {
            AndroidInit.driver.swipe((int) (size.width * 0.8), (int) (size.height * 0.8), (int) (size.width * 0.1), (int) (size.height * 0.8), 4000);
        } else if (SwipeDirection.equalsIgnoreCase("Left")) {
            AndroidInit.driver.swipe((int) (size.width * 0.1), (int) (size.height * 0.8), (int) (size.width * 0.8), (int) (size.height * 0.8), 4000);
        } else {
            MyLogger.log.info("Not a valid direction passed");
        }
        return this;
    }

    public UiObject waitToAppear(int seconds) {
        Timer timer = new Timer();
        timer.start();
        while (!timer.expired(seconds)) if (exists()) break;
        if (timer.expired(seconds) && !exists())
            throw new AssertionError("Element " + locator + " did not appear in " + seconds + " seconds");
        return this;
    }

    public UiObject waitToDisappear(int seconds) {
        Timer timer = new Timer();
        timer.start();
        while (!timer.expired(seconds)) if (!exists()) break;
        if (timer.expired(seconds) && exists())
            throw new AssertionError("Element " + locator + " did not disappear in " + seconds + "seconds");
        return this;
    }
}



