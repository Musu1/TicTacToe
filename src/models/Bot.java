package models;

import exception.GameOverException;
import exception.InvalidInputException;
import service.botPlayingStrategy.BotPlayingStrategies;
import service.botPlayingStrategy.BotPlayingStrategy;
import service.botPlayingStrategy.BotPlayingStrategyFactory;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(String botName, int dimension, PlayerType playerType, char symbol, BotDifficultyLevel botDifficultyLevel) {
        super(botName, dimension, playerType, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) throws GameOverException {
        BotPlayingStrategy botPlayingStrategy = BotPlayingStrategyFactory.getBotStrategy(BotPlayingStrategies.EASY);
        return botPlayingStrategy.makeMove(board,this);
    }
}
