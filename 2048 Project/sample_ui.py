from data2048 import Data2048
from ui2048 import UI2048
from player import Player
from ui import debug
import curses

def main(stdscr):
    '''
    You can play around with the UI and Data objects here.
    '''

    ui = UI2048()
    data = Data2048()

    ui.writeMsg("Hello World!!")
    ui.writeStr("Press a key...", 2, 5)
    ui.updateGameWindow()

    debug("Hi, you can print debug messages using debug()")
    debug("Instead of print(), use debug()!!!")

    # Try out other UI methods!!!
    debug("\nTry other UI methods just to see it work")


    ui.waitForKey()

curses.wrapper(main)

