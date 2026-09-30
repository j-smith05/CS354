# Project #: IA2

* Author: Jacob Smith
* Class: CS354 002
* Semester: Fall 2026

## Overview

This program parses input expressions by using a parser and builds  
a parse tree based on the provided grammar. It works with the lexer  
from Part 1 to recognize identifiers, numbers, operators, parentheses,  
and syntax errors.

## Reflection

Write a two paragraph reflection describing your experience with this
project.  Talk about what worked well and what was challenging.  
Did you run into an issue that took some time to figure out?  
Tell us about it. What did you enjoy, what was less desirable? Feel
free to add other items (within the two paragraph limit).

This project went pretty well, as I had a good understand due to lectures
heading in and how each of the rules connected to a parser method and  
Node class. It was helpful to see how the lexer from Part 1 connected  
directly into the parser, especially when handling identifiers, numbers,  
operators, and parentheses. I also liked being able to print the parse  
trees on the command line, instead of writing them, as they can sometimes  
be very painful to write as we know.  

The most challenging part was getting the project setup and testing environment  
working correctly. As JUnit just hasn't liked me, it's been very painful this  
semester. Additionally I forgot to update Term.java, so I was confused on when  
my parse trees were looking very incomplete. Although I feel like that troubleshooting  
helped me understand everything a bit more then if I didn't have it. 

## Compiling and Using

From the IA1 folder, go into the lib directory and compile the program with:

    cd lib
    javac node/*.java syntax/*.java

Then pass an expression such as "x + 3" to Parser.parse() to generate its parse tree.  

## Results

No timing or performance experiments were required for this project, so  
there are no experimental results to report. We used a provided testing  
class to output and then verify ourselves that it is as expected.  

## Sources used

No outside sources were used.  

----------
