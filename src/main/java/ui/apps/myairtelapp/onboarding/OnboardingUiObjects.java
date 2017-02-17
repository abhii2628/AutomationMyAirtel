package ui.apps.myairtelapp.onboarding;

import ui.android.AndroidInit;
import core.UiObject;
import core.UiSelector;

/**
 * Created by B0095770 on 27/01/17.
 */
public class OnboardingUiObjects {

    private static UiObject
            telephonyPermission,
            heading,
            enterNumber,
            terms,
            numpad,
            requestOtp,
            smsPermission,
            allowPermission,
            denyPermission,
            editNumber,
            inputOtp,
            resendOtp,
            contactPermission,
            permissionPopup,
            accountCard,
            skipReferal,
            backspace,
            mainAccountHeader,
            mainAccountNumber,
            mainAccountBalance,
            mainAccountProfileImage,
            mainAccountUnit,
            morePlans,
            myAirtelTab,
            payNow,
            enterAmount,
            pack,
            ok,
            axisBank,headerText,paytext,denyAlways,manageAccount,accountBalance,
            rechargeNow;

    public UiObject telephonyPermission (){
        if (telephonyPermission == null) telephonyPermission = new UiSelector().resourceId("com.ui.android.packageinstaller:id/permission_message").makeUiObject();
        return telephonyPermission;
    }

    public UiObject heading (){
        if (heading == null) heading = new UiSelector().resourceId("com.myairtelapp.debug:id/tv_heading").makeUiObject();
        return heading;
    }

    public UiObject enterNumber (){
        if (enterNumber == null) enterNumber = new UiSelector().resourceId("com.myairtelapp.debug:id/et_input_box").makeUiObject();
        return enterNumber;
    }

    public UiObject terms (){
        if (terms == null) terms = new UiSelector().resourceId("com.myairtelapp.debug:id/tv_terms").makeUiObject();
        return terms;
    }

    public UiObject numpad (){
        if (numpad == null) numpad = new UiSelector().resourceId("com.myairtelapp.debug:id/tv_numpad").makeUiObject();
        return numpad;
    }

    public UiObject requestOtp (){
        if (requestOtp == null) requestOtp = new UiSelector().resourceId("com.myairtelapp.debug:id/btn_request_otp").makeUiObject();
        return requestOtp;
    }

    public UiObject smsPermission (){
        if (smsPermission == null) smsPermission = new UiSelector().resourceId("com.ui.android.packageinstaller:id/permission_message").makeUiObject();
        return smsPermission;
    }

    public UiObject focusPermission (){
        if (allowPermission == null) allowPermission = new UiSelector().resourceId("com.ui.android.packageinstaller:id/permission_message").makeUiObject();
        return allowPermission;
    }

    public UiObject denyPermission (){
        if (denyPermission == null) denyPermission = new UiSelector().textContains("Deny").makeUiObject();
        return denyPermission;
    }

    public UiObject allowPermission (){
        if (allowPermission == null) allowPermission = new UiSelector().textContains("Allow").makeUiObject();
        return allowPermission;
    }

    public UiObject editNumber (){
        if (editNumber == null) editNumber = new UiSelector().resourceId("com.myairtelapp.debug:id/iv_edit").makeUiObject();
        return editNumber;
    }

    public UiObject inputOtp (){
        if (inputOtp == null) inputOtp = new UiSelector().resourceId("com.myairtelapp.debug:id/rl_input_otp").makeUiObject();
        return inputOtp;
    }

    public UiObject resendOtp (){
        if (resendOtp == null) resendOtp = new UiSelector().resourceId("com.myairtelapp.debug:id/btn_resend_otp").makeUiObject();
        return resendOtp;
    }

    public UiObject contactPermission (){
        if (contactPermission == null) contactPermission = new UiSelector().resourceId("com.ui.android.packageinstaller:id/perm_desc_root").makeUiObject();
        return contactPermission;
    }

    public UiObject accountCard() {
        if (accountCard == null) accountCard = new UiSelector().resourceId(AndroidInit.app.myAirtelapp.packageID() + ":id/cta_account_card").makeUiObject();
        return accountCard;
    }

    public UiObject skipReferal (){
        if (skipReferal == null) skipReferal = new UiSelector().text("SKIP").makeUiObject();
        return skipReferal;
    }

    public UiObject backspace (){
        if (backspace == null) backspace = new UiSelector().resourceId("backspace").makeUiObject();
        return backspace;
    }

    public UiObject myAirtelTab(){
        if (myAirtelTab == null) myAirtelTab = new UiSelector().resourceId("myAirtelTab").makeUiObject();
        return myAirtelTab;
    }

    public UiObject mainAccountHeader (){
        if (mainAccountHeader == null) mainAccountHeader = new UiSelector().resourceId("com.myairtelapp.debug:id/header_title").makeUiObject();
        return mainAccountHeader;
    }

    public UiObject mainAccountNumber (){
        if (mainAccountNumber == null) mainAccountNumber = new UiSelector().resourceId("com.myairtelapp.debug:id/header_number").makeUiObject();
        return mainAccountNumber;
    }

    public UiObject mainAccountProfileImage (){
        if (mainAccountProfileImage == null) mainAccountProfileImage = new UiSelector().resourceId("com.myairtelapp.debug:id/profile_image").makeUiObject();
        return mainAccountProfileImage;
    }

    public UiObject mainAccountBalance (){
        if (mainAccountBalance == null) mainAccountBalance = new UiSelector().resourceId("com.myairtelapp.debug:id/tv_status").makeUiObject();
        return mainAccountBalance;
    }

    public UiObject mainAccountUnit (){
        if (mainAccountUnit == null) mainAccountUnit = new UiSelector().resourceId("com.myairtelapp.debug:id/unit").makeUiObject();
        return mainAccountUnit;
    }

    public UiObject morePlans (){
        if (morePlans == null) morePlans = new UiSelector().resourceId("com.myairtelapp.debug:id/more_plans").makeUiObject();
        return morePlans;
    }


    //ui objects to go to Payments Flow Banking.

    public UiObject payNow(){
        if (payNow == null) payNow = new UiSelector().resourceId("com.myairtelapp.debug:id/btn_card_footer").makeUiObject();
        return payNow;
    }

    public UiObject enterAmount(){
        if (enterAmount == null) enterAmount = new UiSelector().text("9").makeUiObject();
        return enterAmount;
    }

    public UiObject ok(){
        if (ok == null) ok = new UiSelector().xpath("//ui.android.widget.ImageView[contains(@resource-id,'cb_ok')]").makeUiObject();
        return ok;
    }

    public UiObject axisBank(){
        if (axisBank == null) axisBank = new UiSelector().text("Axis").makeUiObject();
        return axisBank;
    }

    public UiObject headerText(){
        if (headerText == null) headerText = new UiSelector().resourceId("").makeUiObject();
        return headerText;
    }

    public UiObject payText(){
        if (paytext == null) paytext = new UiSelector().xpath("ui.android.view.ViewGroup[contains(@resource-id,'top_toolbar')and @text='Payment']").makeUiObject();
        return paytext;
    }

    public UiObject denyAlways(){
        if (denyAlways == null) denyAlways = new UiSelector().resourceId("ui.android:id/button1").makeUiObject();
        return denyAlways;
    }

    public UiObject manageAccount(){
        if (manageAccount == null) manageAccount = new UiSelector().resourceId("com.myairtelapp.debug:id/cta_account_card").makeUiObject();
        return manageAccount;
    }

    public UiObject pack(){
        if (pack == null) pack = new UiSelector().resourceId("").makeUiObject();
        return pack;
    }
//Account Card

    public UiObject accountBalance(){
        if (accountBalance == null) accountBalance = new UiSelector().text("Account Balance").makeUiObject();
        return accountBalance;
    }

    public UiObject rechargeNow(){
        if (rechargeNow == null) rechargeNow = new UiSelector().resourceId("com.myairtelapp.debug:id/btn_recharge_now").makeUiObject();
        return rechargeNow;
    }


}
