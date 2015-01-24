(defn rule1
  "If you possess a string whose last letter is I, you can add on a U at the end."
  [string]
  (if (= (last string) \I)
    (str string \U)
    string))

(defn rule2
  "Suppose you have Mx. Then you may add Mxx to your collection."
  ([string] (if (= (first string) \M)
              (str string
                   (apply str (rest string)))
              string))
  ([string pos] (if (= (nth string pos) \M)
                  (str string
                       (apply str (drop (inc pos) string)))
                  string)))

(defn rule3
  "If III occurs in one of the strings in your collection, you may make a new string with U in place of III."
  [string pos]
  (if (= (take 3 (drop pos string))
         (quote (\I \I \I)))
    (str (apply str (take pos string))
         \U
         (apply str (drop (+ 3 pos) string)))
    string))

(defn rule4
  "If UU occurs inside one of your strings, you can drop it."
  [string pos]
  (if (= (take 2 (drop pos string))
         (quote (\U \U)))
    (str (apply str (take pos string))
         (apply str (drop (+ 2 pos) string)))
    string))
