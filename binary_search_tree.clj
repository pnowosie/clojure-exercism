(ns binary-search-tree)

;; Represents BST as a list: (node-value left-subtree right-subtree)
(defn value [[vnode]]     vnode)
(defn left  [[_ lnode]]   lnode)
(defn right [[_ _ rnode]] rnode)

(defn singleton [val]
    (list val nil nil))

(defn insert [val [vnode lnode rnode :as tree]]
    (cond 
        (empty? tree) (singleton val)
        (> val vnode)
            (list vnode lnode (insert val rnode))
        :else
            (list vnode (insert val lnode) rnode)))

(defn from-list [list] 
    (reduce #(insert %2 %1) nil list))

(defn to-list [[vnode lnode rnode]] 
    (and vnode 
        (concat (to-list lnode) [vnode] (to-list rnode))))