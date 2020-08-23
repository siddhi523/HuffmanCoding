Huffman Coding
========================

## About
Huffman Coding is an algorithm for data compression
* Huffman code is an optimal prefix code and it is highly used for loseless data compression.
* It is independent of data

## Introduction
In this project I am going to use huffman coding to compress a .txt file and observe the difference between length of original file and compressed one

What I did in the project are:

* Implemented Huffman Coding in Java
* Tested the code with dictionary words file
* Get the result of data compression rate


## Key techniques used
* Greedy Algorithms
* HashMap
* PriorityQueue (Min Heap)
* Nested Class
* Recursion


## How to test

#### 1. Prepare text file

Create a text file named "file.txt" under /files with any contents.
In this demo, I used words file which contains 61,000 dictionary words(61,000 characters in total).


#### 2. Run the test code
"Main.java" automatically loads the file.txt, then test encoding/decoding the given text, and will show the result of text compression.  
The actual result will be something like below.

```
----- START -----
Loading File...
Reading file...
Done
Building Huffman Tree and Code tables...
DONE
============= Occurence of each character =============
? occurs 2 times
\n occurs 77722 times
ƒ occurs 52 times
? occurs 2 times
a occurs 51038 times
b occurs 12541 times
c occurs 26974 times
d occurs 24839 times
e occurs 74646 times
f occurs 8864 times
g occurs 19002 times
' occurs 2 times
h occurs 14122 times
i occurs 57766 times
j occurs 1260 times
k occurs 5430 times
l occurs 34392 times
m occurs 18162 times
n occurs 46049 times
o occurs 39807 times
p occurs 18677 times
q occurs 1245 times
r occurs 47210 times
s occurs 56674 times
t occurs 45012 times
u occurs 22302 times
v occurs 6936 times
w occurs 5082 times
x occurs 1932 times
y occurs 10815 times
z occurs 2832 times
============= Huffman Code for each word =============
? = 11110111110010
\n = 010
ƒ = 111101111101
? = 11110111110011
a = 1011
b = 100011
c = 11001
d = 11000
e = 000
f = 001110
g = 00110
' = 1111011111000
h = 111100
i = 1110
j = 1111011110
k = 0011111
l = 11111
m = 00100
n = 1001
o = 0110
p = 00101
q = 11110111111
r = 1010
s = 1101
t = 0111
u = 10000
v = 1111010
w = 0011110
x = 111101110
y = 100010
z = 11110110
============= Encoding the file =============
DONE
============= Decoding the file =============
Decode Successful
****************** Decoded file = original file ******************
DONE
============= RESULT =============
Original string cost = 5119723 bits
Encoded  string cost = 3120301 bits
****************** % REDUCTION = 39.0533237833375 ******************

----- DONE -----
```
