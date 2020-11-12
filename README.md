# HD_Binary_LongestConsecutiveOfStringBetweenList
A certain client coding challenge and my answers to the task

Recruiting firm requested that I get this done as soon as possible, went ahead and got the challenge code functioning by 11:14 pm EST, started at 5:08pm. One handed might I add.

I did find a logical issue with the test data on the first task as cleared up below. Please inform the client. I explain the details of
my findings in the comments of my code. I also explain any areas I felt that needed some sort of supporting written dialog for the decisions I made. 

GitHub check in : https://github.com/rshanEmm/HD_Binary_LongestConsecutiveOfStringBetweenList
<pre>
*******************************************************************************************************
Task 1:
*******************************************************************************************************

Given a binary search tree and a target node K.
The task is to find the node with minimum absolute difference with given target value K.
Also provide the complexity of the algorithm

Example: 

    20
   /  \
  12   32
 /\    /\
8  18 25 38

// For above binary search tree
Input  :  k = 32
Output :  32

Input  :  k = 14
Output :  18 ( 4 positions away)
Candidate corrected output: 12 (2 positions away)
 

Input  :  k = 21
Output :  20

Input  :  k = 27
Output :  25

Complexity: O(n) linear


*******************************************************************************************************
Task 2:
*******************************************************************************************************
Given 2 lists of strings , find longest consecutive common elements between them in very efficient way.
Complexity of algorithms should be  close to O(n)

Example 1
List1 = ["sun", "moon", "flower", "fruit", "apple", "star", "rose", "fruit", "lily", "fairy"]
List2 = ["hercules", "flower", "fruit", "rose"]

Result: ["flower" , "fruit"]

Example 2:
List1 = ["sun", "moon", "flower", "fruit", "apple", "star", "rose", "fruit", "lily", "fairy"]
List2 = ["apple", "rose", "flower", "fruit", "apple"]

Result: ["flower", "fruit", "apple" ]

Example 3:
List1 = ["sun", "moon", "flower", "fruit", "apple", "star", "rose", "fruit", "lily", "fairy"]
List2 = ["mars", "earth", "jupiter"]

Result: []

Example 4:
List1 = ["sun", "moon", "flower", "fruit", "apple", "star", "rose", "fruit", "lily", "fairy"]
List2 = ["sun", "moon", "flower", "apple", "star", "rose", "fruit"]

Result: [ "apple", "star", "rose", "fruit"]
</pre>
