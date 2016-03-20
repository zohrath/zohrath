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

    Sexpr eval() {
           if (left.getName() != "Constant") {
                left.eval();
                }
            if (right.getName() != "Constant") {
                right.eval();
            }
            return new Constant(left.getConstant() + right.getValue());
    }

    }
