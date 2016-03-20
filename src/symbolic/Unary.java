package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Unary extends Sexpr {
    Sexpr argument;

    public Unary(Sexpr _argument) {
        this.argument = argument;
    }

    public String toString() {

        return "(" + argument.toString() + ")";
    };

    @Override
    String getName() {
        return "Unary";
    }

    int priority() {
        return 0;
    }
}
