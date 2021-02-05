# DynamicArray
Problem statement
- Create a 2-dimensional array, , of  empty arrays. All arrays are zero indexed.
- Create an integer, , and initialize it to .
- There are  types of queries:
Query: 1 x y
  Find the list within  at index .
  Append the integer  to the .
Query: 2 x y
  Find the list within  at index .
  Find the value of element  where  is the number of elements in lastAnswer$.
  Print the new value of  on a new line
  
Note:  is the bitwise XOR operation, which corresponds to the ^ operator in most languages. Learn more about it on Wikipedia.  is the modulo operator.

Sample Input

  2 5
  1 0 5
  1 1 7
  1 0 3
  2 1 0
  2 1 1
  
Sample Output

  7
  3
