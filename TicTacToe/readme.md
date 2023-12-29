# Design Tic-Tac-Toe

## What is Tic-Tac-Toe?

TicTacToe is a 2 player game played on a 3 x 3 board. Each player is allotted a symbol (one X and one O). Initially, the board is empty. Alternatively, each player takes a turn and puts their symbol at any empty slot. The first player to get their symbol over a complete row OR a complete column OR a diagonal wins.

You can play the game within Google Search by just searching for “tictactoe”!

![TicTacToe](https://www.tuitec.com/wp-content/uploads/2016/08/morpion-640x411.jpg)

## Game Design Checklist

* Board parameters - size of board/ initialization of board
* Leaderboard
* Pause/Resume buttons
* Timer
* Exit allowed in between?
* Can undo a move?
* Can replay moves?
* How will the game start and how will it end?
* Strategy to decide winner,runner up etc.

## Requirements

* Non-persistent system(we do not need DB)
* Size of board should be N * N
* No. of players - N-1
* Each player will have unique symbol
* The game can have a bot as a player in case user is playing alone
* Only one bot is allowed
* Bot can play at different difficult levels
* Game will be started when a player makes a move. The player will be chosen randomly.
* Game wil end 
  * If there is a winner, winner is decided based on any one of the below condition.
    * All cells of row
    * All cells of col
    * All cells of a diagnol
    * All 4 corners of board.
  * If ends in a draw
* No one exit game in between
* User will have an option to undo their moves.
* User should be able to show replay of the moves
* We need to check for winner after every move(TC of algo should be O(1))


## Undo Algo

* We maintain a list of moves(row,column and symbol info) and list of game-state(matrix n*n).
* Now to undo we just traverse through this list.
* TC is good here, SC will be bad.

## Finding Winner Algo

* We need to check for winner after every move
* Now instead of checking for all symbols and full board:
  * We check for only the last symbol
  * And only check in the row/column/diagnol 
* We maintain a hashmap for each row, column, diagnol and corners. Now anytime we add a entry, we will update the HMs and then check the count of the symbol in HM. If it is equal to N we have a winner.
  * SC wise, we will have 2N+3 HMs (N row,N col,2 diagnol and 1 corner HM). But each HM will have atmost N-1 entry. So we have (2N+3)*(N-1) enteries. i.e. -> 2*n^2+n-3
  * Now TC during update, we only will update 4 HMs(1 row,col,diagnol and corner) and check count in 4 HMs.
  * If in 4 HMs we see count of symbol = N, we have a winner. So TC = O(1).

## Design Pattern

* Builder Pattern to create a game
  * Validations
    * board should be of N size and there should be N-1 players
    * Each player should have unique symbol
    * Maximum 1 bot allowed per game
    
* Strategy pattern
  * Bot Playing strategy
  * Winning strategy


## Class diagram


## Game Play