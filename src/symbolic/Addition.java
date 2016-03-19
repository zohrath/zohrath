package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Addition extends Binary {


    public Addition(Sexpr _left, Sexpr _right) {
        this.left = _left;
        this.right = _right;
        this.eval();
    }

    @Override
    String getName() {
        return null;
    }

    @Override
    Sexpr eval() {
        return this;
    }


    @Override
    public String toString() {
        return null;
    }
}

