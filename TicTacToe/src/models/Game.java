package models;

import exception.DuplicateSymbolException;
import exception.InvalidBoardSizeException;
import exception.InvalidBotException;
import exception.InvalidNumberOfPlayersException;
import service.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board currentBoard;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private Player winner;
    private List<Move> moves;
    private List<Board> boardStates;
    private WinningStrategy winningStrategy;

    private int totalNumberOfSymbols;

    public Game(Board currentBoard, List<Player> players,WinningStrategy winningStrategy) {
        this.currentBoard = currentBoard;
        this.players = players;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.boardStates = new ArrayList<>();
        this.winningStrategy = winningStrategy;
    }

    public void setCurrentBoard(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setBoardStates(List<Board> boardStates) {
        this.boardStates = boardStates;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public int getTotalNumberOfSymbols() {
        return totalNumberOfSymbols;
    }

    public void setTotalNumberOfSymbols(int totalNumberOfSymbols) {
        this.totalNumberOfSymbols = totalNumberOfSymbols;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<Board> getBoardStates() {
        return boardStates;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private int dimension;
        private List<Player> players;
        private WinningStrategy winningStrategy;

        public Builder dimension(int dimension){
            this.dimension = dimension;
            return this;
        }

        public Builder players(List<Player> players){
            this.players = players;
            return this;
        }

        public Builder winningStrategy(WinningStrategy winningStrategy){
            this.winningStrategy = winningStrategy;
            return this;
        }

        public void validateBotCount() throws InvalidBotException {
            int botCount = 0;
            for(Player player : players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }

            if(botCount>1){
                     throw new InvalidBotException("Bot count can't be > 1 , currently it is : "+botCount);
            }
        }

        public void validateBoardSize() throws InvalidBoardSizeException {
             if(dimension < 3 || dimension > 10){
                 throw new InvalidBoardSizeException("Board size should be between 3 and 10");
             }
        }

        public void validatePlayerNumber() throws InvalidNumberOfPlayersException {
            if(players.size() != dimension-1){
                throw new InvalidNumberOfPlayersException("Number of players is invalid");
            }
        }

        public void validatePlayerSymbols() throws DuplicateSymbolException {
            HashSet<Character> symbols = new HashSet<>();
            for(Player player : players){
                symbols.add(player.getSymbol());
            }
            if(symbols.size() != players.size()){
                throw new DuplicateSymbolException("All pplayers should have unique symbols");
            }
        }

        public void validate() throws InvalidBoardSizeException, InvalidBotException, InvalidNumberOfPlayersException, DuplicateSymbolException {
            validateBoardSize();
            validateBotCount();
            validatePlayerNumber();
            validatePlayerSymbols();
        }

        public Game build() throws InvalidBotException, DuplicateSymbolException, InvalidNumberOfPlayersException, InvalidBoardSizeException {
            validate();
            return new Game(new Board(dimension),players,winningStrategy);
        }




    }
}
