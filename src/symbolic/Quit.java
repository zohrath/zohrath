package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Quit extends Command {

    public Quit() {
        super();
        setQuit();
    }

    @Override
    public String getName() {
        return "Quit";
    }

    @Override
    public Sexpr eval() {
        return new Constant(1337);
    }
}
