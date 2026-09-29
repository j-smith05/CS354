; super-duper.scm
; Duplicates every element by the requested amount
; If source is not a list, it is returned unchanged.

(define (super-duper source count)
  (cond
    ((not (list? source)) source)
    ((null? source) '())
    (else
      (duplicate (super-duper (car source) count)
                 count
                 (super-duper (cdr source) count)))))

; Adds item to the front of result count times.
(define (duplicate item count result)
  (if (= count 0)
      result
      (cons item (duplicate item (- count 1) result))))