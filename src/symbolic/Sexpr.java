package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Sexpr {

    public Sexpr() {
    }

    abstract String getName();

    public double getValue() {
        return 0;
    }

    int priority() {
       return 0;
    }

    boolean isConstant() {
        return true;
    }

    public abstract Sexpr eval();

    public double getConstant() {
        return this.getValue();
    }

}
