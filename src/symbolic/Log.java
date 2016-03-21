package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Log extends Unary {
    public Log(Sexpr _argument) {
        super(_argument);
    }

    @Override
    public String getName() {
        return "Log";
    }

    @Override
    double getResult(double a) {
        return Math.log(a);
    }


}
