package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Sin extends Unary {
    public Sin (Sexpr _argument) {
        super(_argument);
    }

    @Override
    String getName() {
        return "Sin";
    }

    @Override
    Sexpr eval() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
