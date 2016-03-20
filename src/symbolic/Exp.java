package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Exp extends Unary {

    public Exp(Sexpr _argument) {
        super(_argument);
    }

    @Override
    String getName() {
        return "Exp";
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
