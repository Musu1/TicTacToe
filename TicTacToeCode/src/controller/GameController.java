package controller;

import exception.InvalidInputException;
import models.*;
import service.winningStrategy.WinningStrategies;
import service.winningStrategy.WinningStrategy;
import service.winningStrategy.WinningStrategyFactory;

import java.util.Dictionary;
import java.util.List;

public class GameController {

    public Game createGame(int dimension, List<Player> players){
       try {
           Game game = Game.builder()
                   .dimension(dimension)
                   .players(players)
                   .winningStrategy(WinningStrategyFactory.getWinningStrategy(dimension, WinningStrategies.ORDER_ONE_WINNING_STRATEGY))
                   .build();
       }
       catch (Exception e){
           System.out.println(e.getMessage());
           System.out.println("An error occured");
       }
       return null;
    }

    public void printBoard(Game game){
        game.getCurrentBoard().printBoard();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public Move makeMove(Game game,Player player) throws InvalidInputException {
        Move move = player.makeMove(game.getCurrentBoard());
        updateGameMoves(game,move);
        updateBoardStates(game);
        return move;
    }

    public Player checkWinner(Game game,Move lastPlayedMove){
        Player player = game.getWinningStrategy().checkWinner(game.getCurrentBoard(),lastPlayedMove);
        if(player != null){
            game.setWinner(player);
            game.setGameStatus(GameStatus.WINNER);
            return player;
        }
        return null;
    }

    public void updateGameMoves(Game game,Move move){
        game.getMoves().add(move);
    }

    public void updateBoardStates(Game game){
        // we do this so a new object is created.
        // copy constructor used.
        game.getBoardStates().add(new Board(game.getCurrentBoard()));
    }

}
