package service.botPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy  getBotStrategy(BotPlayingStrategies botPlayingStrategies){
        return switch (botPlayingStrategies){
            case EASY -> new EasyPlayingStrategy();
        };
    }
}
