package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Negation extends Unary {

    public Negation (Sexpr _argument) {
        super(_argument);
    }

    @Override
    String getName() {
        return "-";
    }

    @Override
    public Sexpr eval() {
        return null;
    }

}
