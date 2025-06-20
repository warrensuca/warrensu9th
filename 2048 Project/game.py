from player import Player
from data2048 import Data2048
from ui2048 import UI2048
from board2048 import Board2048
import curses
from ui import debug

"""
game.py
"""

def turn(ui: UI2048, data: Data2048, pNum: int):
    '''
    Player makes a **single** turn according their swipe movement. 

    1. Get the player's swipe movement (quit, up, down, left, right) from the UI.
    2. Check if the move is legal. If not, get another move from the player
       until a legal move is made. If the player quits, return -1.
    3. Shift the tiles in the indicated direction merging any tiles that can be merged.
    4. Update the player's score.
    5. Update the display with the new board and the new player score.
    6. Write a message to the Message window indicating the player move and the points earned (if any).

    Args:
        ui (UI2048): User Interface instance to get key press and draw game
        data (Data2048): All the data for the game
        pNum (int): Player number making the move

    Returns:
        int: Points the player scored on turn (-1 if player decided to quit)    
    '''
    move = ui.getPlayerMove(pNum)
    board = data.getBoard()
    if board.legalSwipe(move):
        val = board.shift(move)
        data.updateScore(val)
        ui.updateGameWindow()

def playGame(ui: UI2048, data: Data2048, player_list: list):
    '''
    1. Add 2 random tiles to the board
    2. Draw the board
    3. Play the game by calling ``turn()`` repeatedly until the player(s)
       achieve the 2048 tile or there are no more legal moves to make (board is full
       and shifting does not yeild any merged tiles). Also stop if the player presses
       ``q`` to quit (i.e. ``turn()`` will return a -1 in this case). 
    4. After each turn, add an additional random tile to the board. Update the display.
    5. Check if the board is playable. If so, continue, but otherwise, end the game.

    Args:
        ui (UI2048): User Interface instance to draw the display
        data (Data2048): All the data for the game - player and board are initialized
    '''
    board = data.getBoard()


    board.addRandomTile()
    board.addRandomTile()
    
    ui.drawBoard(board)
    ui.updateGameWindow()
    move_count = 0
    n = len(player_list)
    '''
    while True:
        curr_player = move_count%n
        turn(ui,data,player_list[curr_player])
        if board.achievedGoal() or not board.moreMoves() or ui.getPlayerMove(curr_player) == 'quit':
            break
        else:
            board.addRandomTile()
        ui.updateGameWindow()'''
def main(stdscr):
    '''
    Some initial code has been given to create the initial ``UI2048`` display and the
    initial ``Data2048`` object.  The ``main`` function should:

    1. Get player names and create the ``Player`` in the ``Data2048`` object
    2. Create the board in the ``Data2048`` object
    3. Play a 2048 game by calling ``playGame`` 
        a. Ask if they want to play again
        b. If yes, reset the game data and play again
        c. If no, end the game
    '''
    ui = UI2048()

    # Setup the UI player 1 key map
    ui.setPlayerKeyMap(1, [('q', 'quit'), ('w', 'up'), ('a', 'left'), ('s', 'down'), ('d', 'right')] )

    # Define basic settings for the game
    data = Data2048()
    data.setData('mode', 'basic')
    data.setData('numplayers', 1)
    player_list = []
    name = ui.askMsg("Hello! What is your name, player? ")
    
    player_list.append(len(player_list)+1)
    data.makePlayer(name)


    ui.writeHeaderMsg(name)
    score = data.getScore()
    ui.writeScore(1,score)
    data.createBoard(4,4,2048)
    board = data.getBoard()
    ui.drawBoard(board)
    ui.updateGameWindow()
    play_again = True
    while play_again:
        playGame(ui, data, player_list)
        '''q = ui.askMsg("Would you like to play again? (y/n)")
        while q.lower() != 'y' or q.lower() != 'n':
            q = ui.askMsg("Please press y or n")
        if q == 'n':
            play_again = False
        data.resetGame()'''


# DO NOT DELETE THE FOLLOWING LINE - it calls the main() to start the game
if __name__ == "__main__":
    curses.wrapper(main)
