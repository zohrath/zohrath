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

    @Override
    public Sexpr eval() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
