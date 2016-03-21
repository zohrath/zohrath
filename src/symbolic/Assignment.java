package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Assignment extends Binary {
    public Assignment(Sexpr _left, Sexpr _right) {
        super(_left, _right);
        this.assignment = true;
    }

    @Override
    public String getName() {
        return this.right.getName();
    }

    @Override
    public Sexpr eval() {
        return this.left.eval();
    }

    @Override
    public String toString() {
        return this.left + " = " + this.right;
    }

    @Override
    public double getResult(double a, double b) {
        return 0;
    }
}
