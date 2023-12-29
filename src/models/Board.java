package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();

        for(int i = 0;i<size;i++){
            this.board.add(new ArrayList<>());
            for(int j = 0;j<size;j++){
                Cell a = new Cell(i,j);
                this.board.get(i).add(a);
            }
        }

     }

     public Board(Board board){
        this.size = board.size;
        this.board = board.board;
     }

     public void printBoard(){
        for(int i = 0;i<size;i++){
            List<Cell> cells = board.get(i);
            for(Cell cell : cells){
                cell.display();
            }
            System.out.println();
        }
     }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}