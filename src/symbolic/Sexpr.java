package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Sexpr {

    boolean quit = false;
    boolean vars = false;

    public Sexpr() {

    }

    abstract String getName();

    public void setQuit() {
        this.quit = true;
    }

    public boolean isQuit() {
        return this.quit;
    }

    public boolean isVars() {
        return this.vars;
    }

    public double getValue() {return 0;}

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
