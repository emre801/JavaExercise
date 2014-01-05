JavaExercise
============

(A)
This code will run in O(n) time. It would iterate through the collection adding all the weights together to find the total weight.
Then it would pick a random number from 0 to Total Weight. The ads with the greater weight have a high chance of being selected.
For instance look at this example

placement_id | ad_id | weight

2 | 101 | 20

2 | 102 | 20

2 | 100 | 10


101 will get the range 0-19,102 will get 20-39, and 100 will get the range 40-49.
Any number picked from those will result in the corresponding ads being chosen. The higher weights will being given a greater range resulting in that ad being picked more often.

(B) 
In order to test adChoose I created a new class called TestCases.java
In that class I have 7 test cases. I also have a method called printPercentages. 
printPercentages takes an ArrayList of PlacementAdMappings and runs the chooseAd method multiple times.
It then takes result of chooseAd and inputs it into a Hashtable that keeps track of how many times each result was picked.
At the end it would print the percentages of how often each ad was chosen.
This would allow me to compare expected results to actual results.

Test cases 1-3 were from examples in the instructions.Test case 4 made sure Integer.MAX_VALUE would work as a weight.
Test case 5 would catch the error of nothing in the collection being passed into choseAd.
Test case 6 would catch an error of a negative weight being passed as a value.
Test case 7 was a unique error that I found while testing. When total weight was greater than Integer.MAX_VALUE, it resulted in a negative number being passed into r.nextInt(totalWeight);
This would catch the error and give the corresponding message.


