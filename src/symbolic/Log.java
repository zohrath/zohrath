package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Log extends Unary {
    public Log(Sexpr _argument) {
        super(_argument);
    }

    @Override
    String getName() {
        return "Log";
    }

    public Sexpr eval() {
        if (this.argument.getName() != "Constant") {
            this.argument.eval();
        }
        if (this.argument.getName() == "Constant") {
            Constant a = new Constant(Math.log(this.argument.getConstant()));
            return a;
        }
        return this;
    }

}
