package com.robo.clojo;
import clojure.java.api.Clojure;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Robolectric;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.robo.clojo.ClojoActivity;
import android.app.Activity;

@RunWith(RobolectricTestRunner.class)
public class ClojoTest {
    public static Activity activity = null;
    @Test
    public void runAllTests() throws Exception {
        activity = Robolectric.buildActivity(ClojoActivity.class)
            .create()
            .get();

        Clojure.var("clojure.core", "require")
            .invoke(Clojure.read("clojure.test"));
        Clojure.var("clojure.core", "require")
            .invoke(Clojure.read("com.robo.clojo.main-test"));
        Clojure.var("clojure.test", "run-all-tests")
            .invoke();
    }
}
