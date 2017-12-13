# SlowLambdaPOC

This little project demonstrates that Java 8 lambda expression in some cases can result in significant performance degradation.

The class *EuclideanComparison* computes the Euclidean distance between 2 large vectors using a for loop and a lambda expression.
The lambda expression can be 100 times slower than the for loop.

On the other hand, a simple sum of big decimals has similar performance in both cases.
