package symbolic;

import java.util.Map;

/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Binary extends Sexpr {
    Sexpr left;
    Sexpr right;

    public Binary(Sexpr _left, Sexpr _right) {
        this.left = _left;
        this.right = _right;
    }

    abstract public String getName();

    @Override
    public Sexpr eval(Map<String,Sexpr> variables) {

        this.left = this.left.eval(variables);
        this.right = this.right.eval(variables);

        if (left.isConstant() && right.isConstant()) {
            return new Constant(getResult(left.getValue(), right.getValue()));
        }

        return this;
        }


    abstract public double getResult(double a, double b);

    public String toString() {
        return "(" + this.left + " " + this.getName() + " " + this.right + ")";
    }

}
