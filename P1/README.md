# Project 1: Java to Go Porting

* Author: Jacob Smith
* Class: CS354-002
* Semester: Fall 2026

## Overview

This program was simple at heart, as we were tasked with porting a program
that is in Java, and converting it to the Go Programming Language. It uses
Go packages, interfaces, goroutines, and channels to manage different
account types and calculate the total interest accrued.

## Reflection

I thought this project was a good introduction to Go and helped
me understand how concepts I knew from Java can be implemented
differently in another language. Porting of a basic banking program was
fairly easy once I understood how Go uses structs, interfaces,
and packages instead of traditional Java classes and inheritance.

The hardest part for me was getting everything to work correctly
with the provided tests. I ran into smaller issues with package
imports and output formatting, such as printing too many decimal places  
and getting the newlines in the expected locations. Some of these problems  
took longer to figure out than I expected, but working through them helped  
me become more comfortable reading Go errors and debugging my code.  
Overall, I enjoyed learning a new language and seeing how Go handles  
object-oriented concepts, although dealing with some of the small syntax  
and formatting differences was probably the least enjoyable part.

## Compiling and Using

To run the program you must be in the root directory of the project,
compile the program using: go build ./...

To run the program, use: go run .

## Results

The provided run-tests.sh script was used to test the project and  
verify that the program produced the expected results. I continued  
to run the script and verify that it was matching the expected results

## Sources used

No additional Sources were you used apart from the provided resources

----------
