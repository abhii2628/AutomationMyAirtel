package core;

import java.util.Date;

/**
 * Created by B0095770 on 17/01/17.
 */
public class Timer {

    public long startStamp;

    public void start(){
        startStamp = getTimeStamp();
    }

    public static long getTimeStamp(){
       return new Date().getTime();
    }

    public boolean expired(int seconds){
        int difference = (int) (getTimeStamp()-startStamp)/1000;
        return difference > seconds;
    }

    public boolean waitForApi(int seconds){
        int difference= (int) ((getTimeStamp()-startStamp) /1000);
        return difference >seconds;
    }
}
