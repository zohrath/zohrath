package symbolic;

import java.util.Map;

/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Sexpr {

    boolean quit = false;
    boolean vars = false;
    boolean assignment = false;
    boolean variable = false;
    boolean constant = false;

    double value = 0;

    public Sexpr() {

    }

    abstract public String getName();

    public boolean isAssignment() {
        return assignment;
    }

    public boolean isQuit() {
        return this.quit;
    }

    public boolean isVars() {
        return this.vars;
    }

    public boolean isVariable() { return this.variable; }

    public boolean isConstant() { return this.constant; }

    public double getValue() {
        return this.value;
    }

    public abstract Sexpr eval();

    public abstract Sexpr eval(Map<String,Sexpr> variables);

}
