package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Sin extends Unary {
    public Sin (Sexpr _argument) {
        super(_argument);
    }

    @Override
    public String getName() {
        return "Sin";
    }

    @Override
    double getResult(double a) {
        return Math.sin(a);
    }

}
