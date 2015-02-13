# Towers
Implement the recursive method solveTowers to complete the Towers of Hanoi program.

## Rules of the Game
- Only one disk can be moved to the other tower at a time.
- You can’t keep larger diameter disk on top of smaller diameter disk.

## Goal
- Goal of the game is to move all the disks from tower A to tower C, find smallest number of disk movements required.

## Algorithm
1. Move top n-1 disks form start pole (A) to auxiliary tower (B).
2. Move “n” th disk from start pole (A) to end pole (C).
3. Move n-1 disks from auxiliary tower (B) to end pole (C)

Above step 1 & 3, transferring the top n-1 disks, can be thought as a fresh problem and can be solved in a similar fashion.

## Play Online
http://www.mathsisfun.com/games/towerofhanoi.html

## Output for 3 discs:
```
Enter number of discs: 3

   *       |       |    
  ***      |       |    
 *****     |       |    


   |       |       |    
  ***      |       |    
 *****     |       *    


   |       |       |    
   |       |       |    
 *****    ***      *    


   |       |       |    
   |       *       |    
 *****    ***      |    


   |       |       |    
   |       *       |    
   |      ***    *****  


   |       |       |    
   |       |       |    
   *      ***    *****  


   |       |       |    
   |       |      ***   
   *       |     *****  


   |       |       *    
   |       |      ***   
   |       |     *****  

Number of moves: 7
```
