package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Unary extends Sexpr {
    Sexpr argument;

    public String toString() {

        return "(" + argument.toString() + ")";
    };

    int priority() {
        return 0;
    }
}
