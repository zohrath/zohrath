package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Variable extends Atom {
    @Override
    String getName() {
        return "Variable";
    }

    @Override
    public Sexpr eval() {
        return null;
    }
}
