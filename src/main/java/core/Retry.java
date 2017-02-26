package core;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by B0095770 on 25/01/17.
 */
public class Retry implements TestRule {

    private int retryCount;

    public Retry(int retryCount) {
        this.retryCount = retryCount;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return statement(base, description);
    }

    private Statement statement(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable throwable = null;
                for (int i = 0; i < retryCount; i++) {
                    try {
                        base.evaluate();
                        return;
                    } catch (Throwable e) {
                        throwable = e;
                        //Skipping the retry logic for skipped tests
                        if (throwable.getClass() != org.junit.internal.AssumptionViolatedException.class)
                            MyLogger.log.error("Tests failed after " + (i + 1) + " retries");
                        else throw throwable;
                    }
                }
                MyLogger.log.error("Giving up after maximum retry count of " + retryCount);
                throw throwable;
            }
        };

    }


}
