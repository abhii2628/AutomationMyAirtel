package ui.apps.myairtelapp.postpaidPayment;

import core.UiObject;
import core.UiSelector;

/**
 * Created by B0095770 on 25/02/17.
 */
public class PostpaidPaymentUiObjects {

    private static UiObject
            enterAmount,
            ok,
            axisBank,
            headerText,
            paytext
    ;

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
        if (paytext == null) paytext = new UiSelector().xpath("//ui.android.view.ViewGroup[contains(@resource-id,'top_toolbar')and @text='Payment']").makeUiObject();
        return paytext;
    }
}
