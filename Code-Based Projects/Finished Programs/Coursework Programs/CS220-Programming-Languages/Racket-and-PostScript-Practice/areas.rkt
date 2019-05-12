#lang racket
(define r 10) ;Define r as 10
(* (* 4 3.14159) (* r r)) ;Display surface area of sphere with radius 10
(* (* (/ 4 3) 3.14159) (* (* r r) r)) ;Display volume of a sphere with radius 10
(define a 1.2)
(define b 2.3)
(define c 3.4)
(define x -2)
(+ (+ (* a (* x x)) (* b x)) c) ;Define some variable a, b, c, and x, and then compute a polynomial with them
(define s "Hello, Racket") ;String declaration
(define mid (floor (/ (string-length s) 2))) ;find the midpoint of String Dr. Racket
(string-append (string-append (substring s 0 mid) "Dr.") (substring s mid (string-length s))) ;Insert Dr. into the string
(define (area r)
  (* (* 4 3.14159) (* r r))) ;Function for finding surface area of a sphere
(printf "Surface area of a sphere radius 10: ")
(area 10)
(printf "Surface area of a sphere radius 20: ")
(area 20)
(printf "Surface area of a sphere radius 30: ")
(area 30)
(define (vol r)
  (* (* (/ 4 3) 3.14159) (* (* r r) r))) ;Function for finding the volume of a sphere
(printf "Volume of a sphere radius 10: ")
(vol 10)
(printf "Volume of a sphere radius 20: ")
(vol 20)
(printf "Volume of a sphere radius 30: ")
(vol 30)
(define (midpt s)
  (floor (/ (string-length s) 2))) ;Function for finding the midpoint of a string, rounded down
(printf "Midpoint of string 'a string': ")
(midpt "a string")
(printf "Midpoint of string 'dr. racket': ")
(midpt "dr. racket")
(printf "Midpoint of string 'abcde': ")
(midpt "abcde")