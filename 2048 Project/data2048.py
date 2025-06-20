from gamedata import GameData
from player import Player
from board2048 import Board2048
from ui import debug




import random




class Data2048(GameData):
  '''
  Holds the all the data for the 2048 game. This includes the players and the board.
  Contains methods to access and modify the data.
  Also it may hold different game settings for advanced features. You may decide to
  use ``GameData`` methods, or you do not have to either... ``GameData`` is there as a convenience
  if you find it useful to create additional data to be stored, but it is not the only
  way to store information in this object.
  '''
  # Note: No need to define __init__(self) - just inherit from GameData




  def makePlayer(self, name: str) -> None:
      #creates a new player with the player number and name
      self.newPlayer=Player(name)




  def createBoard(self, r: int, c: int, target: int) -> None:
     #creates a new board
      self.csize = c
      self.rsize = r
      self.newBoard=Board2048(r, c, target)




  def getBoard(self) -> Board2048:
      #gets and returns Board2048
      return self.newBoard




  def getName(self) -> str:
      #return name of player with name pNum
      return self.newPlayer.getName()




  def getScore(self) -> int:
      #gets score of player pNum
      if (self.getData(self.getName())==None):
          return 0
      else:
          return self.getData(self.getName())




  def updateScore(self, points: int) -> None:
      #updates score to player pNum
      self.setData(self.getName, self.getScore()+points)




  def resetGame(self):
      #resets all game data
      self.newPlayer=None
     
      self.newBoard=[[None]*self.rsize] * self.csize
      self.setData(self.getName(), 0)
    




 
















def main():
    data = Data2048()

    data.makePlayer(1, "Mark")      # creates player 1 named Mark
    print(data.getScore(1))         # 0
    data.updateScore(1, 10)         # add 10 points to player 1
    print(data.getName(1))          # Mark
    print(data.getScore(1))         # 10

    data.createBoard(4, 4, 2048)    # creates a typical 4x4 2048 board
    board = data.getBoard()         # get the Board2048

    board.addRandomTile()           # add a random tile to the board
    score = board.shift("l")        # shift board to the left
    for row in board.board:
        print(row)
if __name__ == "__main__":
    main()