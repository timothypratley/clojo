(ns com.robo.clojo.main
  (:use [neko.activity :only [defactivity set-content-view!]]
        [neko.threading :only [on-ui]]
        [neko.ui :only [make-ui]]))

(defactivity com.robo.clojo.ClojoActivity
  :def a
  :on-create
  (fn [this bundle]
    (on-ui
     (set-content-view! a
      (make-ui [:linear-layout {:id-holder true}
                [:text-view {:id :hello
                             :text "Hello from Clojure!"}]])))))
