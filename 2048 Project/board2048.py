import random
from board import Board
from typing import List
from ui import debug




class Board2048(Board):
   """
   The board that is used for 2048 - inherits from ``Board`` and adds some unique
   methods specific for the game 2048.




   The constructor initializes a ``Board2048`` with a given dimension and ending target number.
   The target ending number (does not really have to be 2048 - it can be any other number).








   Args:
       rsize (int): row size
       csize (int): col size
       n (int): target number to achieve to meet game goal
   """
   #intialize all of the variables we need
       #rsize: the number of rows
       #csize: the number of columns
       #self.target = our target number, the goal
       #self.board the 2d array which stores all of the tiles


   def __init__(self, rsize: int, csize: int, n: int):
       """
       Initializes a 2048 Board with a given dimension and ending target number.
       The target ending number (does not really have to be 2048 - it can be any other number).








       Args:
           rsize (int): row size
           csize (int): col size
           n (int): target number to achieve to end game
       """


       self.rsize = rsize
       self.csize = csize
       self.target = n
       temp = Board(self.rsize, self.csize)
       self.board = temp.board
       # Hint... call the parent's __init__


   def getTarget(self):
       """
       Returns:
           int: Value of tile to achieve in game (e.g. 2048 nominally)
       """
       # self explanaotry
       return self.target


   def addRandomTile(self):
       """
       Adds a random tile into the board as long. Makes sure there is not a current tile there
       when new tile is places. A 2 is placed with a probability of 90% and a 4 is placed with
       a probability of 10%. The placement should be random within any of the empty locations
       in the board.






       If the board is full, then it just should just return to avoid an infinite loop.




       Returns:
           boolean: True if additional tile was added successfully
       """
              #brute force over all the tiles, keeping track of which one's don't store a number
       #if it doesn't store a number, then it is an open tile and a random number can be inserted there


       self.open_tiles = []
       for i in range(self.rsize):
           for j in range(self.csize):
               if self.board[i][j] == None:


                   self.open_tiles.append((i, j))
       rand_coord = random.choice(self.open_tiles)
       rand_num = random.random()
       # random.random() returns a number between 0 and 1
       if rand_num < 0.9:
           self.board[rand_coord[0]][rand_coord[1]] = 2
       else:
           self.board[rand_coord[0]][rand_coord[1]] = 4
   def strip_None(self, row):
       # strips the nones out of a row, to handle cases where you are comparing none with an integer
       # intitally only made for shift functions, but finds use in other methods.
       n = len(row)
       j = 0
       while j < n:
           if row[j] == None:
               row.pop(j)
               n -= 1
           else:
               j += 1
   def achievedGoal(self):
       """
       Check if board has a tile equal to the target number (ex. 2048). It does not
       check if the board has tiles above this value - only specifically the target
       tile value.


       Returns:
           boolean: True if the board has a tile with the target value (ex. 2048)
       """
       # using the max function to remove one loop, making code more efficent
       highest_num = 0
       for i in range(self.rsize):
           # acess each row
           temp = self.board[i].copy()
           self.strip_None(temp)
            #strip the nones because comparing a none to a number gives an error
           #when we strip, we must make a copy of the current row, because we don't actually want to strip out the whitespace on the actual board
           #must also check if the length of the stripped row is greater than 0, because max([]) -> error
           highest_num = max(highest_num, max(temp))
           # find the max of the max of each row
       return highest_num == self.target
   def legalSwipe(self, dir):
       """
       Can 2048 board be shifted in given direction? If no tiles move, then it is not a legal shift.






       Args:
           dir (str): direction of shift - "u" or "d" or "l" or "r"


       Returns:
           boolean: Returns true if at least 1 tile moves/merged in the given direction, should return
           false if *dir* is not a legal value
       """
              # we can make a temporary board, and if after we shift in the given direction, the temp board doesn't change at all, then we know no tiles shifted
       temp_board = Board2048(self.csize, self.rsize, 2048)
       temp_board.setBoard(self.board)
       val = 0

       temp_board.shift(dir)


       return temp_board.board != self.board


   def moreMoves(self):
       """
       Check if board is full w/o anymore moves possible




       Returns:
           boolean: Returns true if there are more possible moves/swipes
       """


       #we can use our legal swipe from earlier, if you can't shift the board in any direction, you have no more possible moves

       flag = False
       for dir in ['l','r','u','d']:
           if self.legalSwipe(dir):
               flag = True
               break
       return flag
  
  


   def shiftRow(self, row: List[int]) -> int:
       """
       Shift the given row to the left (i.e. index 1 shifts to index 0) and merge tiles if possible.
       Return the score from merging. The row is modified. This row may be technically of any length
       and is just a 1-dimensional list of pieces. Consider how you might be able to use this method
       in the ``shift`` method for the entire board.








       Args:
           row (List[int]): The row to be shifted
       Returns:
           int: score from merging
       """
           #1. strip out the nones, we will add them back later
       #2. iterate from left to right, as when we shift left, the leftmost tiles merge first. 

       n = len(row)
       self.strip_None(row)


       j = 0
       count = 0
       while j < len(row) - 1:


           if row[j] == row[j + 1]:
               row[j + 1] += row[j]
                #if tiles are equal, they combine


               count += row[j + 1]
               row.pop(j)
                #if two tiles combine, then we left with 1 less tile


           j += 1


       while len(row) < n: #add back the nones to the back
           row.append(None)


       return count


   def shift(self, dir):
       """
       Shifts the 2048 board up/down/left/right. If *dir* is not a legal
       value, then nothing happens. The score based on any merged tiles is
       returned.






       Args:
           dir (str): direction of shift - "u" or "d" or "l" or "r"








       Returns:
           int: Score from all the merging of tiles
       """
       # TODO
       # trying to change each row and column one by one
       # then reasign the temp rows and cols back to the actual board
       # struggles: possible out of bound errors, maybe iterating order is incorrect
       total_count = 0

           #create a list with all of the columns, will be used for the up and down shifts
       cols = []
       for i in range(self.csize):
           temp = []
           for j in range(self.rsize):
               temp.append(self.board[j][i])
           cols.append(temp)

       #create a list with all of the rows, will be used for left and right shifts
       rows = []
       for i in range(self.rsize):
           rows.append(self.board[i])


       if dir == "u":
           for i in range(self.csize):
               
            #use the column list

               total_count += self.shiftRow(cols[i])
       #                print(cols[i])
       elif dir == "d":
           for i in range(self.csize):
                #use the column list, and simluate iterating backwards, which can be done by reversion, shifting, and then reversing again
               #2 reverses will first combine the tiles correctly, then flip the nones
               cols[i].reverse()
               total_count += self.shiftRow(cols[i])


               cols[i].reverse()
       elif dir == "l":
            #use the rows list

           for i in range(self.rsize):
               total_count += self.shiftRow(rows[i])


       # 2 ->  2 -> 2 -> 2 rightmost is of most priorty
       elif dir == "r":
           for i in range(self.rsize):
               #use the rows list
               #2 reverses will first combine the tiles correctly, then flip the nones

               rows[i].reverse()
               total_count += self.shiftRow(rows[i])


               rows[i].reverse()
       if dir == "u" or dir == "d":
           for i in range(self.csize):
                #re-assign the columns back to the board

               for j in range(self.rsize):
                   self.board[i][j] = cols[j][i]
       else:
           for i in range(self.rsize):
               #re-assign the rows back to the board
               self.board[i] = rows[i]
       return total_count




def main():


   board = Board2048(4, 4, 2048)


   print(board.getPiece(0, 0))  # None
   board.putPiece("Hello", 1, 0)
   print(board.getPiece(1, 0))  # Hello


   print(board.getTarget())  # 2048
   print(board.shiftRow([None, 2, 2, None]))  # 4


   b = [
       [2, 2, 2, 4],  # make a board for testing
       [2, 2, None, None],
       [2, 2, 2, 2],
       [4, 2, 8, None],
   ]
   board.setBoard(b)
   print(board.board)
   for row in board.board:
       print(row)
   print(board.shift("d"))  # 8
   print("_____________________")
   for row in board.board:
       print(row)
   board.addRandomTile()
   for row in board.board:
       print(row)
   board.putPiece(2048, 2,2)
   for row in board.board:
       print(row)
   print(board.achievedGoal())
   b = [
       [1, 2, 3, 4],  # make a board for testing
       [5, 6, 7, 8],
       [9, 10, 11, 12],
       [13, 14, 15, 16],
   ]
   board.setBoard(b)
   print(board.moreMoves())
  
if __name__ == "__main__":
   main()
