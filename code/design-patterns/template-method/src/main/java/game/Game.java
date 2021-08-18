package game;

public abstract class Game {

    protected boolean isNeedInitialize = true;  // 默认需要初始化

    //  钩子方法 子类可实现
    protected void isNeedInitialize(boolean isNeedInitialize) {
        this.isNeedInitialize = isNeedInitialize;
    }

    abstract void initialize();  // 基本方法 子类需要实现
    abstract void startPlay();   // 基本方法 子类需要实现
    abstract void endPlay();     // 基本方法 子类需要实现

    //模板方法负责调度基本方法， 子类不可实现
    public final void play(){

        //initialize the game
        if (isNeedInitialize) {
            initialize();
        } else {
            System.out.println("已经初始化了, 不需要再初始化");
        }

        //start game
        startPlay();

        //end game
        endPlay();
    }
}
