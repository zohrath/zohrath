package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Assignment extends Binary {
    public Assignment(Sexpr _left, Sexpr _right) {
        super(_left, _right);
    }

    @Override
    public String getName() {
        return "Assignment";
    }

    @Override
    public Sexpr eval() {
        return new Constant(1337);
    }

    @Override
    public String toString() {
        return this.left + " = " + this.right;
    }
}
