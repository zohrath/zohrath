package symbolic;

import java.util.Map;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Variable extends Atom {

    String varName;

    public Variable(String variable) {
        super();
        this.varName = variable;
        this.variable = true;
    }

    @Override
    public String toString() {
        return varName;
    }

    @Override
    public String getName() {
        return varName;
    }

    @Override
    public Sexpr eval(Map<String,Sexpr> variables){
        Sexpr val = variables.get(getName());

        if (val == null) {
            return this;
        } else {
            return val;
        }
    }
}
