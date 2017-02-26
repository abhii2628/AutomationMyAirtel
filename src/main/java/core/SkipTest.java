package core;

import org.junit.Assume;

/**
 * Created by B0095770 on 26/02/17.
 */
public class SkipTest {

    public static void IF(Boolean condition){
        Assume.assumeFalse(condition);
    }

    public static void UNLESS(Boolean condition){
        Assume.assumeTrue(condition);
    }

}
