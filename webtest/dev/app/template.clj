(ns app.template
  (:require [app.function :as foo]
            [hiccup.core :as hc]))

(def aboutstring {:satu "Ut in neque ante. Nam congue, leo non accumsan viverra, nisi urna fringilla mauris, vel euismod eros enim sit amet risus. In vehicula urna nec lacus varius mollis. Fusce nec nibh sed neque facilisis posuere posuere eget orci. Morbi commodo consequat lacinia. Quisque et libero enim. Vivamus accumsan interdum augue, in aliquam augue aliquam porta." :dua "Nulla lacinia augue ac orci pharetra, vitae interdum lectus laoreet. Sed nisl lectus, pharetra ac posuere pharetra, tincidunt eu purus. Maecenas eleifend, massa sed semper tincidunt, metus diam facilisis leo, nec maximus dolor nulla sit amet felis. Praesent libero turpis, pharetra eget ultrices a, maximus in turpis. Duis ullamcorper mollis nisl, eget eleifend nunc gravida vitae. Cras turpis neque, suscipit et ante non, vestibulum porta nulla. Proin eu rhoncus tortor. Morbi dignissim iaculis nunc, in aliquam dolor aliquet ut. Fusce ultricies sollicitudin aliquet. Etiam vel sem dictum, pulvinar lacus venenatis, consequat felis. Duis non accumsan libero, sed luctus orci. Aliquam vel aliquam purus." :tiga "Ut varius, ligula vel sodales laoreet, orci ipsum luctus libero, id rutrum sem lacus sed augue. Duis finibus cursus eros, quis pulvinar risus vehicula ac. Donec non tortor eget magna sodales molestie. Integer aliquet justo ac risus fermentum, lobortis interdum mi egestas. Maecenas ultrices fermentum metus eget vestibulum. Ut nec nisl vel urna rutrum scelerisque ut ac nisi. Maecenas viverra erat id dui commodo, in fermentum eros varius. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aenean id mi libero. Nam semper sit amet enim quis porta. Nullam luctus suscipit felis eget finibus. Quisque lacinia ac sem et porttitor."})

(defn home-html [post]
  (hc/html [:html
            [:head
             [:title "Home"]
             (foo/bootstrap)]
            [:body
             [:nav {:class "navbar navbar-inverse"}
              [:div {:class "container-fluid"}
               [:div {:class "navbar-header"}
                [:a {:class "navbar-brand" :href "/"} "LOGO"]]
               [:ul {:class "nav navbar-nav"}
                [:li {:class "active"} [:a {:href "/home"} "Home"]]
                [:li [:a {:href "/about"} "About"]]]
               [:ul {:class "nav navbar-nav navbar-right"}
                [:li [:a {:href "#"} [:span {:class "glyphicon glyphicon-user"}] " Sign Up"]]
                [:li [:a {:href "#"} [:span {:class "glyphicon glyphicon-log-in"}] " Login"]]]]]
             #_[:div {:class "jumbotron text-center"}
              [:h1 "Home Page"]
              [:p "BLOG"]]
             [:div {:class "container"}
              (if (empty? post)
                [:div {:class "text-center"} "No Post Yet!" [:br][:br]]
                [:div {:class "row"}
                 (foo/post-list (into (sorted-map) post))])
              [:div {:class "text-center"}
               [:a {:href "/new"}
               [:button {:class "btn btn-primary" :type "button"} "Create New Post"]]]]]]))

(def about-html
  (hc/html [:html
            [:head
             [:title "About"]
             (foo/bootstrap)]
            [:body
             [:nav {:class "navbar navbar-inverse"}
              [:div {:class "container-fluid"}
               [:div {:class "navbar-header"}
                [:a {:class "navbar-brand" :href "/"} "LOGO"]]
               [:ul {:class "nav navbar-nav"}
                [:li [:a {:href "/home"} "Home"]]
                [:li {:class "active"} [:a {:href "/about"} "About"]]]
               [:ul {:class "nav navbar-nav navbar-right"}
                [:li [:a {:href "#"} [:span {:class "glyphicon glyphicon-user"}] " Sign Up"]]
                [:li [:a {:href "#"} [:span {:class "glyphicon glyphicon-log-in"}] " Login"]]]]]
             [:div {:class "jumbotron text-center"}
              [:h1 "Lorem Ipsum"]
              [:p "Lorem ipsum dolor sit amet, consectetur adipiscing elit!"]]
             [:div {:class "container"}
              [:p (:satu aboutstring)]
              [:p (:dua aboutstring)]
              [:p (:tiga aboutstring)]]]]))

(def landing-html
  (hc/html [:html
            [:head
             [:title "Welcome!"]
             (foo/bootstrap)]
            [:body
             [:nav {:class "navbar navbar-inverse"}
              [:div {:class "container-fluid"}
               [:div {:class "navbar-header"}
                [:a {:class "navbar-brand" :href "/"} "LOGO"]]
               [:ul {:class "nav navbar-nav"}
                [:li [:a {:href "/home"} "Home"]]
                [:li [:a {:href "/about"} "About"]]]
               [:ul {:class "nav navbar-nav navbar-right"}
                [:li [:a {:href "#"} [:span {:class "glyphicon glyphicon-user"}] " Sign Up"]]
                [:li [:a {:href "#"} [:span {:class "glyphicon glyphicon-log-in"}] " Login"]]]]]
             [:div {:class "jumbotron text-center"}
              [:h1 "BANNER"]
              [:p "SUB-BANNER"]]]]))
