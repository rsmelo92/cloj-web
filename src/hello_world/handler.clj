(ns hello-world.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :as response]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] 
    (response/content-type
      (response/resource-response "index/index.html" {:root "public"}) "text/html"))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
