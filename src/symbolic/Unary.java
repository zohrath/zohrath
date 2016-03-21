package symbolic;

import java.util.Map;

/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Unary extends Sexpr {
    Sexpr argument;


    public Unary(Sexpr _argument) {
        this.argument = _argument;
    }

    @Override
    public String toString() {

        return getName() + "(" + argument.toString() + ")";
    }

    @Override
    abstract public String getName();

    @Override
    public Sexpr eval(Map<String,Sexpr> variables) {
        if (argument.isVariable()) {
            argument.eval(variables);
        } else {
            return new Constant(getResult(this.argument.eval(variables).getValue()));
        }
        return this;
    }

    abstract double getResult(double a);
}
