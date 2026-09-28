; very simple suite to demonstrate super-duper

; adding tests to this is REQUIRED!

; It is highly recommended to test each function

(load "super-duper.scm")


(display (super-duper 123 1))
(newline)

(display (super-duper 123 2))
(newline)

(display (super-duper 'hello 3))
(newline)

; Test empty lists
(display (super-duper '() 1))
(newline)

(display (super-duper '() 2))
(newline)


; Test single element lists
(display (super-duper '(x) 1))
(newline)

(display (super-duper '(x) 2))
(newline)

(display (super-duper '(a) 4))
(newline)


; Test multiple element lists
(display (super-duper '(x y) 1))
(newline)

(display (super-duper '(x y) 2))
(newline)

(display (super-duper '(a b c) 3))
(newline)


; Test lists containing numbers
(display (super-duper '(1 2 3) 2))
(newline)

(display (super-duper '(10 20) 3))
(newline)


; Test nested lists
(display (super-duper '((a b) y) 3))
(newline)

(display (super-duper '((x y) z) 2))
(newline)

(display (super-duper '((1 2) (3 4)) 2))
(newline)


; Test deeper nested lists
(display (super-duper '(((a b) c) d) 2))
(newline)