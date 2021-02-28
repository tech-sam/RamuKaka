# THE DUTCH NATIONAL FLAG PROBLEM

Generalizing, suppose A = (0,l,2,0,2,l,l), and the pivotindex is 3. 
Then A[3] = 0,so (0,0,1,2,2,1,1) is a valid partitioning. 
For the same array, if the pivot index is 2, then A[2] = 2, so the arrays (0,1,0,1,1, 2,2) as well as langle0,0,1,1,1, 2,2) are valid partitionings.

```
Because for [0,1,0,1,1,2,2], 
all values less than the pivot come before all values equal to the pivot.
The order of 1's and 0's doesn't matter, as long as none come after any 2's. Same idea for [0,0,1,2,2,1,1] - 
the pivot is 0, and all the 0's come before all the 1's and 2's - after that, it doesn't matter what order the 1's and 2's are in.

```