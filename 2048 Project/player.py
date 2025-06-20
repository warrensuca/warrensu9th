'''
**DO NOT MODIFY THIS CLASS - FOR REFERENCE ONLY**
'''

class Player:
    '''
    A very generic Player class that might be used for an
    assortment of games. You will use this class, but you should **NOT**
    modify it at all.

    If you want to add additional methods, you would need to create a child
    class like ``player2048.py`` that inherits from this class and in that class
    you may add any additional methods you wish.

    The constructor initializes the Player's name and sets the score to 0
    
    Args:
        name (str): The name of the player
    '''

    def __init__(self, name: str):
        '''
        Initializes a player with a name and a score of 0.

        Args:
            name (str): The name of the player
        '''
        self.name = name
        self.score = 0

    def getName(self) -> str:
        '''
        Returns:
            str: The name of the player
        '''
        return self.name
    
    def setName(self, name: str) -> None:
        '''
        Set the name of the player

        Args:
            name (str): The new name of the player
        '''
        self.name = name

    def getScore(self) -> int:
        '''
        Returns:
            int: The score of the player
        '''
        return self.score

    def updateScore(self, point: int) -> None:
        '''
        Update the score of the player by a given amount

        Args:
            point (int): The amount to update the score by
        '''
        self.score += point

    def reset(self) -> None:
        '''
        Reset the player's score to 0
        '''
        self.score = 0


