package core.managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by B0095770 on 17/01/17.
 */
public class ServerManager {

    private static String OS;
    private static String ANDROID_HOME;

    public static String getOS(){
        if (OS == null) OS = System.getenv("os.name");
        return OS;
    }

    public static boolean isMac(){
        return getOS().startsWith("Mac");

    }

    public static boolean isWindows(){
        return getOS().startsWith("Windows");

    }

    public static String getAndroidHome(){
        if(ANDROID_HOME == null){
            ANDROID_HOME = System.getenv("ANDROID_HOME");
            if(ANDROID_HOME == null) throw new RuntimeException("ANDROID_HOME is not set, make sure the environment variable is set");
        }
        return ANDROID_HOME;
    }

    public static String runCommand(String command) {
        String output = null;
        try {
           Scanner scanner = new Scanner(Runtime.getRuntime().exec(command).getInputStream()).useDelimiter("\\A");
           if(scanner.hasNext()) output = scanner.next();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return output;
    }
}