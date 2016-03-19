package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Atom extends Sexpr {

    abstract public String toString();

    @Override
    String getName() {
        return "Atom";
    }
}
