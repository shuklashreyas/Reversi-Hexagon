How to implement

Rules of the game
In order to to place a piece on the board, it must flip at least one piece on the board 
Game is over when the board is either full or there are no valid moves for either player
Both players can pass in which they dont make a move.
Game has an initial starting state defineed in the assignment page.
Blac player moves first

Implementation(possible)

Interface for the player
-place piece method
-boolean variable if its their turn
-Enum class variable determining their color.
-method to get the color of the player

Interface for the Disc
-color instance variable for the disc
-toString and other standard methods

Interface for the Board
-startGame method(similar to Klondike)
-isGameOver method(similar to Klondike)
-getScore method(similar to klondike)
-variable to keep track of whose turn it is 
-method to get who is currently playing

Interface for BoardView
-toString method to get everything on the board


