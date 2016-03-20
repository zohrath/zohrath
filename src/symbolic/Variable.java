package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Variable extends Atom {

    private String variable;

    public Variable(String variable) {
        super();
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }

    @Override
    public String toString() {
        return variable;
    }

    @Override
    String getName() {
        return "Variable";
    }

    @Override
    Sexpr eval() {
        return null;
    }

}
