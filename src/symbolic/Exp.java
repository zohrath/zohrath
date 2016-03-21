package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Exp extends Unary {

    public Exp(Sexpr _argument) {
        super(_argument);
    }

    @Override
    public String getName() {
        return "Exp";
    }

    @Override
    double getResult(double a) {
        return Math.exp(a);
    }
}
