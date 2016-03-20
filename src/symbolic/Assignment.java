package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Assignment extends Binary {
    public Assignment(Sexpr _left, Sexpr _right) {
        super(_left, _right);
    }

    @Override
    String getName() {
        return "Assignment";
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
