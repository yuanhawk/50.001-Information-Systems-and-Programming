Questions that are interesting:

## Question 3
(i)
Explain why the statement, 'The running time of algorithm A is at least $O$(n^2^)', does
not make sense. Your explanation should include a detailed example.

The literal meaning of $O$(g(n)) means at most a positive constant multiple of g(n) for all sufficiently large values of n.
This does not make sense as you cannot have at most and at least at the same time, since it would result in a contradiction.

For example, if we consider g(n) = n^2^, g~1~(n) = 10 * n^2^, g~2~(n) = 100 * n^2^ ... g~k~(n) = 10^k^ * n^2^ are all functions of
$O$(n^2^). If we want at least condition to be fulfilled, which implies f(n) >= $\infty$.

(ii)
We are given that an algorithm has complexity O(log n) in the given input size n. Explain
why the complexity for this algorithm is also O(log~b~ n), regardless of the choice of any
base b > 1 for the logarithm appearing in the expression.

Suppose the running time of A is f(n). Then the statement 'f(n) = O(log n)' means there exist positive constant c~1~ and n~0~
such that 0 <= f(n) <= c~1~ log n for all n >= n~0~. Let c~2~ = c~1~ * log b. There exists positive constants c~1~ and n~0~ such
that 0 <= f(n) <= c~2~ log~b~(n) for all n >= n~0~. Therefore, f(n) = O(log n) implies f(n) = O(log~b~ n) for any b > 1