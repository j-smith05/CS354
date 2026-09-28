# Project #: Scheme (Super-Duper)

* Author: Jacob Smith
* Class: CS354-002
* Semester: Fall 2026

## Overview

This program implements a Scheme function called super-duper that  
duplicates each element in a list a specified number of times. If  
the input is not a list, it is returned unchanged.

## Reflection

Overall, I thought this was a great way to begin my journey with Functional  
Programming, as I hadn't learned or really heard about it. Scheme was  
pretty straight forward once I was able to understand all the syntax as it  
was a very different language then I've been used to using. The project was  
straightforward in my opinion, as it's a concept I've done before, but it  
was quite challenging in Scheme. Testing the program also worked well because  
I was able to use already made ones as examples.

The most challengining part to me, was what I briefly went over in the first
paragraph. Scheme, and functional programming as a whole was something I've
never messed around with in any form until now. The idea of calling functions
multiple times instead of doing loops or just changing variables was harder to  
wrap my head around. Once I was able to understand how to create recursion in  
functional programs, this flew by, but it took me a little bit to conceptually
understand, but it was nice giving myself more of a challenge!

## Compiling and Using

This program uses Guile 3 to run Scheme code and does not require compilation.  

To run uper-duper.scm, open a terminal in the project directory and enter:

  guile super-duper.scm.  

The super-duper function can then be called by providing a source and a count.  
An example is:

  (super-duper '(x y) 2).

## Results

My results came from test.scm, a self made testing class. I would test my output
multiple times throughout, to ensure my program was running as expected.  

## Sources used

I usered all the provided resources, and I additionally used this website called  
"Yet Another Scheme Tutorial." which can be found here: [Yet Another Scheme Tutorial Website](https://www.shido.info/lisp/idx_scm_e.html)

----------
