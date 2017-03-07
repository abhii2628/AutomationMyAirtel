package tests.onboarding;

import core.MyLogger;
import org.junit.Test;
import ui.android.AndroidInit;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by B0095770 on 25/02/17.
 */
public class Sample {

    @Test
    public void test011(){
       String network = AndroidInit.driver.getConnection().name();
       MyLogger.log.info(network);
        if (network.equals("DATA")){
            AndroidInit.adb.dataDisable();
        }
    }

    @Test
    public static int getResponseCode(String urlString) throws MalformedURLException, IOException{
        URL url = new URL(urlString);
        HttpURLConnection huc = (HttpURLConnection)url.openConnection();
        huc.setRequestMethod("GET");
        huc.connect();
        huc.getRequestMethod();
        huc.getResponseMessage();
        return huc.getResponseCode();
    }
}
