---
title: "Week 1"
author: "Tan Li Yuan"
date: "10/13/2020"
output: html_document
---

### Intro to Algo Lecture 1-2

Input space --> set of possible input<br>
Output space --> set of possible output<br>
Input instance --> part input of a problem instance

Good algo --> $T$(n)  time complexity, should increase "slowly",

$T$(n) - steps to solve problem, n - num of inputs

$\Theta$ - grows asymptotically = (equals)<br>
O - grows asymptotically <= (at most)

n^3^ <= n^3000000^
f(n) = $O$(g(n))

$\Omega$ - grows asymptotically >= (at least)

n^999999^ >= n^2^
f(n) = $\Omega$(g(n))

$\Omega$ dominant<br>
$O$ less dominant<br>
$\Theta$ = $O$ & $\Omega$


n log~2~ n <= n~2~<br>
log~2~ n <= n

### Intro to Algo Lecture 1-3

Code
```
IF a%3 == 0 THEN
	print "OH YEAH"
ENDIF

IF a / 3 THEN
	print "OH YEAH"
ENDIF

PRINT "GREAT"
```

code complexity = $\Theta$(1)

```
FOR i from 0 to 5
	PRINT "GREAT"
ENDFOR
```
code complexity = $\Theta$(1) --> 5 is a constant, so we ignore in this case

```
FOR i from 0 to n
	PRINT "GREAT"
ENDFOR
```
code complexity = $\Theta$(n)

```
FOR i from 0 to n
  FOR j from 0 to n
  	PRINT "GREAT"
  ENDFOR
ENDFOR
```
code complexity = $\Theta$(n^2^)

Typically a double for loop will result in a $\Theta$(n^2^) time complexity, each
for loop will iterate from 0 to n, thus $\Theta$(n^2^). So iterating a double for loop,
will give $\Theta$(n^2^).

```
FOR i from 0 to n
  FOR j from 0 to n
  	PRINT "GREAT"
  ENDFOR
ENDFOR

FOR i from k to n
  PRINT "GREAT"
ENDFOR
```
$T$(n) = n^2^ + n (n^2^ is dominant)<br>
$\Theta$(n^2^)

```
FOR i from 0 to sqrt(n)
	PRINT "GREAT"
ENDFOR
```
$\Theta$($\sqrt{n}$)

```
FOR i from 0 to sqrt(n)
  FOR j from 0 to sqrt(n)
	  PRINT "GREAT"
	ENDFOR
ENDFOR
```
$\Theta$($\sqrt{n}$ * $\sqrt{n}$) = $\Theta$(n)

```
FOR i from 0 to n
  FOR j from 0 to i
	  PRINT "hi"
	ENDFOR
ENDFOR
```

i = 0: print $\times$ 1<br>
i = 1: print $\times$ 2<br>
...<br>
i = n - 1: print $\times$ n-1

T(n) = 1+2+3+...+(n-1) = $\frac{n(n-1)}{2}$

$\Theta$(n*(n+1)) = $\Theta$(n^2^)