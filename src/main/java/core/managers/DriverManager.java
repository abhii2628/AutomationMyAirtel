package core.managers;

import ui.android.AndroidInit;
import core.ADB;
import core.MyLogger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by B0095770 on 17/01/17.
 */

public class DriverManager {

    //Fix Me : nodeJS env variable to be set later to set appium programatically.
    private static String nodeJS = System.getenv("NPM_HOME");
    private static String appiumJS = System.getenv("APPIUM_HOME" + "/node_modules");
    private static DriverService service;
    private static String deviceID;

    private static HashMap<String, URL> hosts;
    private static String unlockPackage = "io.appium.unlock";

    private static DesiredCapabilities getCapabilities(String deviceID) {
        AndroidInit.adb = new ADB(deviceID);

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "src/resources");
        File app = null;
        app = new File(appDir, "Test1.apk");

        MyLogger.log.info("Creating desired capabilities for " + deviceID);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", deviceID);
        caps.setCapability("platformName", "Android");
        caps.setCapability("noReset", false);
        caps.setCapability("platformVersion", AndroidInit.adb.getAndroidVersionAsString());
        caps.setCapability("autoLaunch", true);
        caps.setCapability("fullReset", true);

        caps.setCapability("app", app.getAbsolutePath());
        MyLogger.log.info("Created " + caps + " capabilities for the devices");
        return caps;
    }

    private static URL host(String deviceID) throws MalformedURLException {
        if (hosts == null) {
            hosts = new HashMap<String, URL>();
            hosts.put("5203e468fadc4341", new URL("http://0.0.0.0:4723/wd/hub"));
            //Multiple device support and multiple port too
            //hosts.put("5203e468fadc4341", new URL("http://0.0.0.0:4723/wd/hub"));
        }
        return hosts.get(deviceID);
    }

    private static ArrayList<String> getAvailableDevices() {
        MyLogger.log.info("Checking for available devices");
        ArrayList<String> availableDevices = new ArrayList<String>();
        ArrayList connectedDevices = ADB.getConnectedDevices();
        for (Object connectedDevice : connectedDevices) {
            String device = connectedDevice.toString();
            ArrayList apps = new ADB(device).getInstalledPackages();
            if (!apps.contains(unlockPackage)) availableDevices.add(device);
            else
                MyLogger.log.info("Device: " + device + " has " + unlockPackage + " installed, assuming it is under testing");
        }
        if (availableDevices.size() == 0)
            throw new RuntimeException("Not a single device is available for testing at this time");
        return availableDevices;
    }

    private static DriverService createService() throws MalformedURLException {
        service = new AppiumServiceBuilder()
                .usingDriverExecutable(new File(nodeJS))
                .withAppiumJS(new File(appiumJS))
                .withIPAddress(host(deviceID).toString().split(":")[1].replace("//", ""))
                .usingPort(Integer.parseInt(host(deviceID).toString().split(":")[3].replace("/wd/hub", "")))
                .build();
        return service;
    }

    public static void createDriver() throws MalformedURLException {
        ArrayList<String> devices = getAvailableDevices();
        for (String device : devices) {
            try {
                deviceID = device;
                MyLogger.log.info("Creating a driver for device " + device);

                //Fix this once the node JS service path is fixed.
                //createService().start();

                AndroidInit.driver = new AndroidDriver(host(device), getCapabilities(device));
                AndroidInit.adb = new ADB(device);
                break;
            } catch (Exception e) {
                e.printStackTrace();
                // Continuing for the next device
            }
        }
    }

    public static void killDriver() {
        if (AndroidInit.driver != null) {
            MyLogger.log.info("Killing the AndroidInit driver");
            AndroidInit.driver.quit();
            //  AndroidInit.adb.uninstallApp(unlockPackage);
//            service.stop(); Fix this once node JS path is set
        } else MyLogger.log.info("AndroidInit driver is not initialized!");
    }
}
