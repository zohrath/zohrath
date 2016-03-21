package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Cos extends Unary {
    public Cos(Sexpr _argument) {
        super(_argument);
    }

    @Override
    public String getName() {
        return "Cos";
    }

    @Override
    public double getResult(double a) {
        return Math.cos(a);
    }
}
