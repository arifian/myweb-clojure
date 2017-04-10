(ns dev
  (:require [io.pedestal.http :as http]
            [io.pedestal.test :as test]
            [clojure.tools.namespace.repl :refer [refresh]]
            [app.routing :as routing]
            [app.api :as api]
            [app.function :as foo]
            [app.template :as mold]))

#_(refresh) ;refresh ns

(def service-map "declaring initial service map"
  {::http/routes routing/routes
   ::http/type   :jetty
   ::http/port   8890})

;; For interactive development
(defonce server (atom nil))

(defn initdb
  "init which type of database to use. :dt for datomic. :da for atom"
  ([]
   (println "current db " (str @api/dbtype)))
  ([dbkey]
   (api/initdb dbkey)
   (println "current db " (str @api/dbtype))))

(defn start-dev
  "start the server, dev mode. Change the server value to a server start&create with assoc'd service map"
  []
  (println "\n -------------------------------------------------- \n")
  (if (nil? @api/dbtype)
    "init the database first /n"
    (reset! server
            (-> (assoc service-map ::http/join? false)
                http/create-server
                http/start)))
  (println "\n -------------------------------------------------- \n"))

(defn stop-dev
  "stopping server"
  []
  (println "\n -------------------------------------------------- \n")
  (http/stop @server)
  (api/stopdb)
  (println "\n -------------------------------------------------- \n"))

#_(defn restart []
  (stop-dev)
  (start-dev))

;utils

(defn test-request "route testing repl function" [verb url]
  (io.pedestal.test/response-for (::http/service-fn @server) verb url))

(defn check-routes
  "Print our application's routes"
  []
  (routing/print-routes))

(defn named-route
  "Finds a route by name"
  [route-name]
  (routing/named-route route-name))