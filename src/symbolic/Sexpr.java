package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Sexpr {

    public Sexpr() {
    }

    abstract String getName();

    double getValue() {
        return 0;
    }

    int priority() {
       return 0;
    }

    boolean isConstant() {
        return true;
    }

    abstract Sexpr eval();



}
