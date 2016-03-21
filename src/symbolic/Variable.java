package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Variable extends Atom {

    private String varName;

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
    public Sexpr eval() {
        return new Constant(1337);
    }

}
