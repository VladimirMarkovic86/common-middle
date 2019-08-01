(ns common-middle.functionalities-by-url
  (:require [common-middle.request-urls :as rurls]
            [common-middle.functionalities :as fns]))

(defmulti get-functionalities-by-url
  (fn [url]
    url))

(def read-functionalities
     (atom
       #{fns/user-read
         fns/language-read
         fns/role-read}))

(defmethod get-functionalities-by-url
  rurls/get-entities-url
  [url]
  @read-functionalities)

(defmethod get-functionalities-by-url
  rurls/get-entity-url
  [url]
  @read-functionalities)

(def update-functionalities
     (atom
       #{fns/user-update
         fns/language-update
         fns/role-update}))

(defmethod get-functionalities-by-url
  rurls/update-entity-url
  [url]
  @update-functionalities)

(def create-functionalities
     (atom
       #{fns/user-create
         fns/language-create
         fns/role-create}))

(defmethod get-functionalities-by-url
  rurls/insert-entity-url
  [url]
  @create-functionalities)

(defmethod get-functionalities-by-url
  rurls/get-chat-users-url
  [url]
  fns/chat)

(defmethod get-functionalities-by-url
  rurls/chat-url
  [url]
  fns/chat)

(def delete-functionalities
     (atom
       #{fns/user-delete
         fns/language-delete
         fns/role-delete}))

(defmethod get-functionalities-by-url
  rurls/delete-entity-url
  [url]
  @delete-functionalities)

(defmethod get-functionalities-by-url
  rurls/reports-url
  [url]
  fns/reports)

(defmethod get-functionalities-by-url
  :default
  [url]
  #{})

