package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Quit extends Command {
    @Override
    String getName() {
        return "Quit";
    }

    @Override
    public Sexpr eval() {
        return null;
    }
}
