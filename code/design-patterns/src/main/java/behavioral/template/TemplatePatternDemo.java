package behavioral.template;

public class TemplatePatternDemo {

    public static void main(String[] args) {
        Game game = new Cricket();
        game.isNeedInitialize(false);
        game.play();

        System.out.println();
        game = new Football();
        game.play();
    }
}
