# Clojo

## SDK requirements for Robolectric
* project.clj :android :target-version "16"
* AndroidManifest.xml <uses-sdk android:minSdkVersion="16" />
* `android` install Android 4.1.2 (API 16) everything (including Google APIs) and Extras Android Support Library and Android Support Repository
* `export ANDROID_HOME=/usr/local/opt/android-sdk`
* `brew install maven` and [install](https://github.com/robolectric/robolectric)

```
mvn install:install-file -DgroupId=com.google.android.maps \
  -DartifactId=maps \
  -Dversion=18_r3 \
  -Dpackaging=jar \
  -Dfile="$ANDROID_HOME/add-ons/addon-google_apis-google-18/libs/maps.jar"

mvn install:install-file -DgroupId=com.android.support \
  -DartifactId=support-v4 \
  -Dversion=19.0.1 \
  -Dpackaging=jar \
  -Dfile="$ANDROID_HOME/extras/android/support/v4/android-support-v4.jar"
```

## Add dependencies to project.clj
Include these in your project :profiles :dev :dependencies so they are available when building and running tests:

* To run Clojure tests [org.clojure/clojure "1.6.0"]
* To run Android tests [org.robolectric/robolectric "2.3"]
* Stubs for compilation [com.google.android/android "4.1.1.4"]
* Launch Robolectric via junit [junit/junit "4.11"]
* Add :junit ["junit"] 

## Create Android specific test harness
* A single JUnit test that calls run-all-tests
(see junit/com/robo/clojo/ClojoTest.java)
* A stub Activity class, because java code is compiled before Clojure defactivty (see junit/com/robo/clojo/ClojoActivity.java)
* Add to project.clj :profiles :dev
    * :source-paths ["junit"]
    * :java-source-paths ["junit"]
    
## Write tests
```
(deftest clojo-test
  (is (= "Hello from Clojure"
         (-> ClojoTest/activity
             (.findViewById R$id/content)
             (.getChildAt 0)
             (.getChildAt 0)
             (.getText)))))
```
    
## Run Tests!
* Must run `lein droid compile` first
* To run Android specific tests: `lein junit`
* To run only the Clojure tests: `lein test` (or `lein test-refresh`)
