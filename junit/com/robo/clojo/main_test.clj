(ns com.robo.clojo.main-test
  (:require
   [clojure.test :refer :all]
   [com.robo.clojo.main])
  (:import
   [android R$id]
   [org.robolectric Robolectric]
   [com.robo.clojo ClojoTest]))

(deftest clojo-test
  (is (= "Hello from Clojure"
         (-> ClojoTest/activity
             (.findViewById R$id/content)
             (.getChildAt 0)
             (.getChildAt 0)
             (.getText)))))
