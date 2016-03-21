package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Negation extends Unary {

    public Negation (Sexpr _argument) {
        super(_argument);
    }

    @Override
    public String getName() {
        return "-";
    }

    @Override
    double getResult(double a) {
        return a * (-1);
    }

    @Override
    public String toString() {
        return "(-" + argument + ")";
    }
}
