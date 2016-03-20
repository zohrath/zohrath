package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Addition extends Binary {

    public Addition(Sexpr _left, Sexpr _right) {
        super(_left, _right);
    }

    @Override
    String getName() {
        return "+";
    }

    @Override
    Sexpr eval() {
        return null;
    }

}