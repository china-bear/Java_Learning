package game;

public class Cricket extends Game {

    @Override
    protected void isNeedInitialize(boolean isNeedInitialize) {
        super.isNeedInitialize(isNeedInitialize);
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
        System.out.println(isNeedInitialize);
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

}
