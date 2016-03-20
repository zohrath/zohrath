package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Cos extends Unary {
    public Cos(Sexpr _argument) {
        super(_argument);
    }

    @Override
    String getName() {
        return "Cos";
    }

    @Override
    public Sexpr eval() {
        return null;
    }

}
