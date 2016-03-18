/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Unary extends Sexpr {
    Sexpr arg;

    public String toString() {
        return "";
    }

    int priority() {
        return 0;
    }
}
