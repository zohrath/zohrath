package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Binary extends Sexpr {
    Sexpr left;
    Sexpr right;

    public Binary(Sexpr _left, Sexpr _right) {
        this.left = _left;
        this.right = _right;
    }

    abstract String getName();

    public String toString() {
        return "(" + this.left + " " + this.getName() + " " + this.right + ")";
    }

    public double getResult(double a, double b) {
        String t = this.getName();

        switch (t) {
            case "+" : return a+b;
            case "-" : return a-b;
            case "*" : return a*b;
            case "/" : return a/b;
            default: System.out.println("getResult did not return a binary operator as expected");
                return 0;
        }
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


}
