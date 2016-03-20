package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Sin extends Unary {
    public Sin (Sexpr _argument) {
        super(_argument);
    }

    @Override
    String getName() {
        return "Sin";
    }

    public Sexpr eval() {
        if (this.argument.getName() != "Constant") {
            this.argument.eval();
        }
        if (this.argument.getName() == "Constant") {
            Constant a = new Constant(Math.sin(this.argument.getConstant()));
            return a;
        }
        return this;
    }

}
