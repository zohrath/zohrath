/**
 * Created by zohrath on 2016-03-18.
 */
public class Constant extends Atom {
    protected double value;

    @Override
    public String toString() {
        return "Constant{" +
                "value=" + value +
                '}';
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    String getName() {
        return null;
    }

    public Constant(double input) {
        value = input;
    }

    @Override
    Sexpr eval() {
        return null;
    }


}

