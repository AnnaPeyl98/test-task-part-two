## Tasks for second stage

### 1. Chess
Board orientation is as follows:

    4| | | | |
    3| | | | |
    2| | | | |
    1|_|_|_|_|
      a b c d
      
Maximum number of figures on board:
* Pawn - 4;
* Bishop - 2;
* Knight - 2;
* Rook -2;
* Queen - 1;
* King - 1.

Starting state pawn:

    4| | | | |
    3| | | | |
    2|P|P|P|P|
    1|_|_|_|_|
      a b c d
      
      
Can transfer figures in a string only in the form of capital letters. 
Before the **isCheck** in class **CheckController** method starts, the line goes through a series of checks:


1. The string must not be null or empty.
2. The length of string should correspond to the size of the future board (in our case 16)
3. String must contain only valid characters, which are subsequently initialized to shapes.
4. The number of a certain type of figures cannot exceed the permissible.


If at least one of the conditions is not met, an exception will be thrown.


Tests in the folder "figures" test the **isCheck** method for a specific figure, so if there is a check on another figure, 
they will still return false. Checks of the possibility of a check for all figures in the class **CheckerControllerTest**

## 2. Correcting time

You can correct in time any positive integer that allows you to store type int.

Example:

       "1895:478:967"

      