(defn replace-pattern-at
  [string pattern pos replaceable]
  (if 
    (= (take 3 (drop pos string)) pattern)
    (apply str (concat (take pos string) replaceable (drop (+ (count pattern) pos) string)))
    string))

(defn rule1
  "If you possess a string whose last letter is I, you can add on a U at the end."
  [string]
  (str string (when (= (last string) \I) \U)))

(defn rule2
  "Suppose you have Mx. Then you may add Mxx to your collection."
  [string] 
  (str string (when (= (first string) \M) (apply str (rest string)))))

(defn rule3
  "If III occurs in one of the strings in your collection, you may make a new string with U in place of III."
  [string pos]
  (replace-pattern-at string '(\I \I \I) pos '(\U)))

(defn rule4
  "If UU occurs inside one of your strings, you can drop it."
  [string pos]
  (replace-pattern-at string '(\U \U) pos '()))
