# Interpreter Assignment

* Author: Jacob Smith
* Class: CS354 Section 002
* Semester: FALL 2026

## Overview

This program implements a lexical analyzer that scans a program and
separates it into tokens. It recognizes identifiers, numbers, operators,
comments, and the end of input while ignoring whitespace and illegal characters.

## Reflection

### Part 1: Lexical Analysis

This part of the assignment went well once I understood how the lexer
as I had a pretty good understand of it during the lectures. I added
functionality for numbers, operators, and identifiers with digits which
was fairly straightforward, and I liked being able to use the JUnit tests
to see whether each part was working correctly. Although it makes me wonder
if I have it set up correctly, giving me memories from DLL Tests in CS221.
I also added comments, which helped me understand how the lexer can recognize
something in the source code without returning it as a token.

I initially did face a lot of challenges with my JUnit tests not running,
which I think is where most of my struggles with the program came from.
My tests were not recognized initially, so it led me down a rabbit hole
where I discovered that I had an older version of JUnit downloaded instead
of JUnit 5. Surprisingly, it took me a while to figure out where the download
file for that was, but once I had it downloaded, it fixed the problem. I then
discovered another problem where, since I made two projects in the same folder,
they were conflicting, so I removed one, which fixed the problem. Other than
those problems with JUnit, I found this assignment very enjoyable.

## Results

No timing or other experiments were required for this part of the project.
Lexer.java was tested using JUnit tests to verify that it correctly recognized
the required tokens and handled comments, whitespace, and illegal characters.

### Part 1: Lexical Analysis

## Sources used

JUnit Team  
Link: [JUnit 5 User Guide](https://docs.junit.org/5.10.5/user-guide/)
Used for information about setting up and using JUnit 5 for unit testing,
and trouble shooting my issues listed in the reflection.

----------