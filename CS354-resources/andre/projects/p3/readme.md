# Project 3: Pig Latin

* Author: Jacob Smith
* Class: CS354 Section #
* Semester:

## Overview

This project is a Pig Latin translator written in JavaScript using Node.js. The program reads English text from standard input, translates words into Pig Latin, and prints the translated text while preserving punctuation, spacing, and capitalization.

## Reflection

Overall, I enjoyed working on this project, while it wasn't the first time I've been asked to do a Pig Latin Coverting, working with java script has always been hard. I haven't touched Javascript since my month with it back in CS 208, 1.5 years ago, so it was difficult remembering everything. I think the  most challenging part was handling capitalization, especially words with uppercase letters in the middle, as there are always so many different edge cases with Pig Latin. I also ran into a few issues with ESLint and terminal commands, but working through those helped me understand the tools better.

**Performance Reflection**

I always love performance, it's cool seeing how well programs run. I hadn't had to do any preformance checks on my new macbook yet. I was shocked on two cases, how fast my program ran, and how fast my macbook ran it. I wasn't sure where most of the time of my program was going to take, I figured it would take most of it's time to deal with the translating of all the cases. Overall, the most important things are the little things, which I found out later when working on the extra credit

## Compiling and Using

Firs you install the development dependencies with:

```bash
npm install
```

Then you should always check for errors with:

```bash
npm run lint
```

To run the program type the following command:

```bash
node igpay.js
```

An example of what to do is as follows on mac:

```bash
echo 'Hello, world!' | node igpay.js
```

It's output would be:

```text
Ellohay, orldway!
```

## Results

My results came in two parts for this program, I first tested and gathered the expected results from the project document. Additionally I was asked to run:

```bash
time cat /usr/share/dict/words | node igpay.js > /dev/null
```

After that it resulted in an average of 0.349s across the three times I ran it, before the extra credit. 

## Extra Credit

For the extra credit, I was tasked with using Node.js profiler for the first time,  to see where my program was spending time. I ran the profiling log using these commands:

```bash
cat /usr/share/dict/words | node --prof igpay.js > /dev/null
node --prof-process isolate-*.log > prof.log
```

After that I dove into prof.log for a solid 10 minutes, before I knew what I was looking at. I then saw unlike I thought in my preformance reflection, that it was actually the console.log() producing the most amount of time. I then found an alternative and faster solution saving me some time by using process.stdout.write(), which saved me a bit of time as shown in my 3 new trials.

| Run | Before EC | After EC |
|---|---|---|
| 1 | 0.353s | 0.308s |
| 2 | 0.345s | 0.307s |
| 3 | 0.349s | 0.307s |
| Average | 0.349s| 0.307s |

As you see on average my program ran 0.42s faster, and while that might not seem like a lot I'll take that improvement, as it's the little stuff that counts!

## Sources

- [Stack Overflow - Difference between process.stdout.write and console.log in Node.js](https://stackoverflow.com/questions/4976466/difference-between-process-stdout-write-and-console-log-in-node-js)  
  I used this discussion when figuring out how to replace to `console.log()` and then understand how `process.stdout.write()` works.