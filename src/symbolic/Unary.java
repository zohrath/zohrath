package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Unary extends Sexpr {
    Sexpr argument;


    public Unary(Sexpr _argument) {
        this.argument = _argument;
    }

    @Override
    public String toString() {

        return getName() + "(" + argument.toString() + ")";
    }

    @Override
    abstract String getName();



    int priority() {
        return 0;
    }


}
