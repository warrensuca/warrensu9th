from ui import UI, debug
from board2048 import Board2048
from data2048 import Data2048




class UI2048(UI):




  # no need to define __init__(self) - can just inherit automatically




  def drawBoard(self, board: Board2048):
      '''
      Draws the 2048 board on the main game window.
      There is not a precise prescription of how to place the numbers of the
      4 x 4 board onto the Display screen, but it should display it "nicely" in a
      playable way. If there is a blank square (i.e. None), it should be
      displayed as a "_".




      Args:
          board (Board2048): The board to draw
      '''
      self.board = board
      board_x_interval = int(UI.getWidth(self)/board.rowSize()) #get the intervals of the spacing of rows in the board
      board_y_interval = int(UI.getHeight(self)/board.colSize()) #get the intervals of the spacing of columns in the board
      #we don't want to start in the very corner, so we create a start_x and start_y
      start_x = int(board_x_interval//2) 
      start_y = int(board_y_interval//2)
      for r in range(self.board.rowSize()):
          for c in range(self.board.colSize()):
              #iterate over every tile in the board
              curr_piece=self.board.getPiece(r, c)
              
              #add the correct board interval to our start position
              curr_x = board_x_interval*c+start_x
              curr_y = board_y_interval*r+start_y
              if(curr_piece==None): #handle the Nones, turn them into whitespace
                  self.writeStr('_', curr_x, curr_y)
                  self.updateGameWindow()
              else:
                  #turn the integer into a string so we can concatenate
                  self.writeStr(str(curr_piece), curr_x, curr_y)
                  self.updateGameWindow()
          print("\n")





















