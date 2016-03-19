package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Binary extends Sexpr {
    Sexpr left;
    Sexpr right;

    @Override
    String getName() {
        return "Binary";
    }

    abstract public String toString();
}
