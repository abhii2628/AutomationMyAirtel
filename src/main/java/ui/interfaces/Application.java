package ui.interfaces;

/**
 * Created by B0095770 on 27/01/17.
 */
public interface Application {

    void forceStop();
    Object open();
    void clearData();
    String packageID();
    String activityID();
    Integer appVersion();
    void wifiEnable();
    void dataEnable();
    void dataDisable();
    void wifiDisable();


}
