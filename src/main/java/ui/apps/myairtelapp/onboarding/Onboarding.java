package ui.apps.myairtelapp.onboarding;

import core.MyLogger;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by B0095770 on 27/01/17.
 */
public class Onboarding {

    public OnboardingUiObjects uiobject = new OnboardingUiObjects();

    public void tapDenyPermission() {
        try {
            MyLogger.log.info("Tapping deny on the Phone permission popup.");
            uiobject.denyPermission().tap();
            if (uiobject.denyPermission().exists()) {
                MyLogger.log.info("Element not focused, hence clicking on it again");
                uiobject.denyPermission().tap();
            } else
                MyLogger.log.info("Tapped on the element");
        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }

    public void tapAllowPermission() {
        try {
            MyLogger.log.info("Tapping allow on the Phone permission popup.");
            uiobject.allowPermission().tap();

            if (uiobject.allowPermission().exists()) {
                MyLogger.log.info("Element not focused, hence clicking on it again");
                uiobject.allowPermission().tap();
            } else
                MyLogger.log.info("Tapped on the element");
        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }

    public void setFocusEnterNumber() {
        try {
            MyLogger.log.info("Tapping on the text field for Enter Mobile number.");
            uiobject.enterNumber().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }

    public void tapRequestOtp() {
        try {
            MyLogger.log.info("Tapping on the Request OTP button");
            uiobject.requestOtp().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }

    public void tapSkipReferal() {

        if (uiobject.skipReferal().waitToAppear(10).exists()) {
            MyLogger.log.info("User is a new number, tap on the Skip button");
            uiobject.skipReferal().tap();
        } else if (uiobject.denyPermission().exists()) {
            MyLogger.log.info("Number not a new user / whitelisted number, continue with the flow");
        }
    }


    public void enterOtpManually() {
        try {
            MyLogger.log.info("Entering the whitelisted OTP");
            uiobject.numpad().tapString("1");
            uiobject.numpad().tapString("2");
            uiobject.numpad().tapString("3");
            uiobject.numpad().tapString("4");
        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }

    // To go to the Payments flow

    public void tapPayNow() {
        try {
            MyLogger.log.info("Tapping on the skip referal screen");
            uiobject.payNow().waitToAppear(60).tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }

    public void tapAmount() {
        try {
            MyLogger.log.info("Tapping on the skip referral screen");
            uiobject.enterAmount().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }

    public void tapOk() {
        try {
            MyLogger.log.info("Tapping on the skip referal screen");
            uiobject.ok().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }

    public void scrollToAxis() {
        try {
            MyLogger.log.info("Tapping on the skip referal screen");

            uiobject.payText().waitToAppear(60).scroll("Up");
            uiobject.payText().scroll("Up");
            uiobject.axisBank().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }

    public void payText() throws InterruptedException {
        Thread.sleep(4000);
        try {
            if (uiobject.payText().exists()) {
                MyLogger.log.info("App is redirected to the other PG gateway");
                Assert.assertEquals("Payment", uiobject.payText().getText());
            } else {
                MyLogger.log.info("The page is not redirected to the third party, Payment is failing!!");
            }

        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }

    public void tapdenyAlways() {
        try {
            if (uiobject.denyAlways().exists()) {
                MyLogger.log.info("Tapping on the always deny button");
                uiobject.denyAlways().tap();
            } else {
                MyLogger.log.info("Permission popup didn't come, continuing with the tests");
            }
        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }

    public void tapManageAccount() {
        try {
            MyLogger.log.info("Tapping on the manage Account link");
            uiobject.manageAccount().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }

    public void tapAccountBalance() {
        try {
            MyLogger.log.info("Tapping on the Account Balance CTA");
            uiobject.accountBalance().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }

    public void chooseRechargeAmount() {
        try {
            MyLogger.log.info("Tapping on the Account Balance CTA");
            //uiobject.talktimepack().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }

    public void tapRechargeNow() {
        try {
            MyLogger.log.info("Tapping on the Recharge Now CTA");
            uiobject.rechargeNow().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }

    public void otpRegistration() throws InterruptedException {
        try {
            MyLogger.log.info("OTP registration flow");
            tapDenyPermission();
            //enterMobileNumber();
            tapRequestOtp();
            tapDenyPermission();
            Thread.sleep(5000);
            enterOtpManually();
            tapSkipReferal();
            tapdenyAlways();
            tapDenyPermission();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to tap on the element, as element was not visible or blocked.");
        }
    }
}
