package models;

import exception.GameOverException;
import exception.InvalidInputException;

import java.util.Scanner;

public class Player {
    private String name;
    private int id;
    private PlayerType playerType;
    private char symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public Move makeMove(Board board) throws InvalidInputException, GameOverException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row of your move: ");
        int row = sc.nextInt();
        System.out.println("Enter the col for your move");
        int col = sc.nextInt();
        // Validate the move, check row/col and cell state
        if(row>board.getSize()-1){
            throw new InvalidInputException("row number should be less than "+(board.getSize()-1));
        }
        if(col>board.getSize()-1){
            throw new InvalidInputException("Col number should be less than "+(board.getSize()-1));
        }
        if(board.getBoard().get(row).get(col).getCellState() == CellState.FILLED){
            throw new InvalidInputException("Cell already filled");

        }

        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(this);

        return new Move(row,col,this);
    }

    public Player() {
    }

    public Player(String name, int id, PlayerType playerType, char symbol) {
        this.name = name;
        this.id = id;
        this.playerType = playerType;
        this.symbol = symbol;
    }
}
