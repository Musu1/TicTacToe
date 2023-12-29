package service.botPlayingStrategy;

import exception.GameOverException;
import models.*;

import java.util.List;

public class EasyPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move makeMove(Board board,Player player) throws GameOverException {
        List<List<Cell>> matrix = board.getBoard();

        for(int i = 0;i<matrix.size();i++){
            for(int j = 0;j<matrix.size();j++){
                if(matrix.get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    board.getBoard().get(i).get(j).setCellState(CellState.FILLED);
                    board.getBoard().get(i).get(j).setPlayer(player);
                    return new Move(i,j,player);
                }
            }
        }



        throw new GameOverException("Game is over");
    }
}
