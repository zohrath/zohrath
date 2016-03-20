package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Exp extends Unary {

    public Exp(Sexpr _argument) {
        super(_argument);
    }

    @Override
    String getName() {
        return "^";
    }

    public Sexpr eval() {
        if (this.argument.getName() != "Constant") {
            this.argument.eval();
        }
        if (this.argument.getName() == "Constant") {
            Constant a = new Constant(Math.exp(this.argument.getConstant()));
            return a;
        }
        return this;
    }


}
