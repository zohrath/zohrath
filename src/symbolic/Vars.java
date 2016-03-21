package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Vars extends Command {

    public Vars() {
        super();
        this.vars = true;
    }

    @Override
    String getName() {
        return "Vars";
    }

    @Override
    public Sexpr eval() {
        return new Constant(1337);
    }
}
