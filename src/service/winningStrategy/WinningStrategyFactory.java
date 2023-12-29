package service.winningStrategy;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(int dimension, WinningStrategies winningStrategies){
        return switch (winningStrategies){
            case ORDER_ONE_WINNING_STRATEGY -> new OrderOneWinningStrategy(dimension);
        };
    }
}
