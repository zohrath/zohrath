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
    public Sexpr eval() {
        return null;
    }

}
