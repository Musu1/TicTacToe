package service.winningStrategy;

import models.Board;
import models.Move;
import models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy{

    private  int dimension;
    private List<HashMap<Character,Integer>> rowHashmaps;
    private List<HashMap<Character,Integer>> colHashmaps;
    private HashMap<Character,Integer> topLeftHashMap;
    private HashMap<Character,Integer> topRightHashMap;
    private HashMap<Character,Integer> cornerHashMap;


    public OrderOneWinningStrategy(int dimension) {
        this.dimension = dimension;
        rowHashmaps = new ArrayList<>();
        colHashmaps = new ArrayList<>();
        topLeftHashMap = new HashMap<>();
        topRightHashMap = new HashMap<>();
        cornerHashMap = new HashMap<>();
        for(int i = 0;i<dimension;i++){
            rowHashmaps.add(new HashMap<>());
            colHashmaps.add(new HashMap<>());
        }
    }

    private boolean isTopLeft(int row,int col){
        return row == col;
    }

    private boolean isTopRight(int row,int col){
        return (row+col) == (dimension-1);
    }

    private boolean isCorner(int row,int col){
        if(row == 0 || row == dimension-1){
            return col == 0 || col == dimension-1;
        }
        return false;
    }

    @Override
    public Player checkWinner(Board board, Move lastMove) {

        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();
        Player player = lastMove.getPlayer();
        Character symbol = lastMove.getPlayer().getSymbol();
        if(isRowWin(row,symbol)){
            return player;
        }
        else if(isColWin(col,symbol)){
            return player;
        }
        else if(isTopLeft(row,col) && isTopLeftWin(symbol)){
            return player;
        }
        else if(isTopRight(row,col) && isTopRightWin(symbol)){
            return player;
        }
        else if(isCorner(row,col) && isCornerWin(symbol) ){
            return player;
        }
        return null;
    }

    private boolean isTopLeftWin(Character symbol){
            topLeftHashMap.putIfAbsent(symbol,0);
            topLeftHashMap.put(symbol,topLeftHashMap.get(symbol)+1);
            return topLeftHashMap.get(symbol) == dimension;
    }

    private boolean isTopRightWin(Character symbol){
        topRightHashMap.putIfAbsent(symbol,0);
        topRightHashMap.put(symbol,topRightHashMap.get(symbol)+1);
        return topRightHashMap.get(symbol) == dimension;
    }

    private boolean isCornerWin(Character symbol){
        cornerHashMap.putIfAbsent(symbol,0);
        cornerHashMap.put(symbol,cornerHashMap.get(symbol)+1);
        return cornerHashMap.get(symbol) == dimension;
    }

    private boolean isRowWin(int row,Character symbol){
        rowHashmaps.get(row).putIfAbsent(symbol,0);
        rowHashmaps.get(row).put(symbol,rowHashmaps.get(row).get(symbol)+1);
        return rowHashmaps.get(row).get(symbol) == dimension;
    }

    private boolean isColWin(int col,Character symbol){

        colHashmaps.get(col).putIfAbsent(symbol,0);
        colHashmaps.get(col).put(symbol,colHashmaps.get(col).get(symbol)+1);
        return colHashmaps.get(col).get(symbol) == dimension;
    }





}
