package symbolic;

import java.util.Map;

/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Atom extends Sexpr {

    public String toString() {
        return String.valueOf(getValue());
    }

    @Override
    public Sexpr eval() {
        return this;
    }

    @Override
    public Sexpr eval(Map<String,Sexpr> variables) {
        return eval();
    }
}
