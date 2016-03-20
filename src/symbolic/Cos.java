package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Cos extends Unary {
    public Cos(Sexpr _argument) {
        super(_argument);
    }

    @Override
    String getName() {
        return "Cos";
    }

    public Sexpr eval() {
        if (this.argument.getName() != "Constant") {
            this.argument.eval();
        }
        if (this.argument.getName() == "Constant") {
            Constant a = new Constant(Math.cos(this.argument.getConstant()));
            return a;
        }
        return this;
    }

    @Override
    public String toString() {
        return null;
    }
}
