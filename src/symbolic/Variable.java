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
    Sexpr eval() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
