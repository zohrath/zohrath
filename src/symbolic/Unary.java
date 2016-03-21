package symbolic;

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

    public Sexpr eval() {
        if (this.argument.getName() != "Constant") {
            this.argument = this.argument.eval();
        }
        if (this.argument.getName() == "Constant") {
            Constant a = new Constant(getResult(this.argument.getValue()));
            return a;
        }
        return this;
    }

    abstract double getResult(double a);
}
