/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Unary extends Sexpr {
    Sexpr arg;

    abstract public String toString();

    int priority() {
        return 0;
    }
}
