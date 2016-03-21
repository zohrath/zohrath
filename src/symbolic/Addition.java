package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Addition extends Binary {

    public Addition(Sexpr _left, Sexpr _right) {
        super(_left, _right);
    }

    @Override
    public String getName() {
        return "+";
    }

    public Sexpr eval() {
        if (left.getName() != "Constant") {
            this.left = this.left.eval();
        }
        if (right.getName() != "Constant") {
            this.right = this.right.eval();
        }
        Constant a = new Constant(getResult(left.getConstant(), right.getConstant()));

        return a;
    }

    public double getResult(double a, double b) {
        return a+b;
    }

}