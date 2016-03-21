package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Constant extends Atom {

    private double value;

    public Constant(double _value) {
        this.value = _value;
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public String getName() {
        return "Constant";
    }

    @Override
    public Sexpr eval() {
        return this;
    }

    public double getConstant() {
        return this.value;
    }
}