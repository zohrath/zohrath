package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Sexpr {

    int parenthesis = 0;

    public Sexpr() {
    }

    public int getParenthesis() {
        return parenthesis;
    }

    public void addParenthesis() {
        this.parenthesis++;
    }

    public void subParenthesis() {
        this.parenthesis--;
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
