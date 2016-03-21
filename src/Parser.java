import java.io.StreamTokenizer;
import java.io.IOException;
import symbolic.Sexpr;

/**
 *
 */
class Parser {

    StreamTokenizer st;

    /**
     *
     */
    public Parser(){
        st = new StreamTokenizer(System.in);
        st.ordinaryChar('-');
        st.ordinaryChar('/');
        st.ordinaryChar('(');
        st.ordinaryChar(')');
        st.ordinaryChar('^');
        st.lowerCaseMode(true);
        st.eolIsSignificant(true);
    }

    /**
     * Creates a tree of symbolic expressions.
     * @return A tree of of symbolic expressions.
     * @throws IOException
     */
    public Sexpr statement() throws IOException {

            st.nextToken();
            st.pushBack();

        if (st.ttype == st.TT_WORD) {
            if (st.sval.equals("quit") || st.sval.equals("vars")) {
                return command();
            }
        }
        return assignment();
    }

    /**
     * Creates a node containing either the "quit" or the "vars" command
     * @return A Sexpr-node.
     */
    private Sexpr command() {

        if (st.sval.equals("quit")) {
            return new symbolic.Quit();
        } else if (st.sval.equals("vars")) {
            return new symbolic.Vars();
        } else {
            throw new SyntaxErrorException();
        }
    }

    /**
     * Creates a node for assigning a variable a value.
     * @return a node for assigning values to variables.
     * @throws IOException
     */
    public Sexpr assignment() throws IOException {

        boolean run = true;
        Sexpr a = expression();

        while (run) {
            st.nextToken();
            if (st.ttype == '=') {

                st.nextToken();
                if (st.ttype == st.TT_WORD) {
                    a = new symbolic.Assignment(a, identifier());
                } else {
                    throw new SyntaxErrorException("Not identifier.");
                }

            } else {
                st.pushBack();
                run = false;
            }
        }

        return a;
    }

    /**
     * Creates an addition or subtraction node
     * @return a node corresponding to its type
     * @throws IOException
     */
    public Sexpr expression() throws IOException {

        Sexpr sum = term();

        while (true) {
            st.nextToken();
            if (st.ttype == '+' || st.ttype == '-') {

                int operation = st.ttype;

                if (operation == '+') {
                    sum = new symbolic.Addition(sum, term());
                } else {
                    sum = new symbolic.Subtraction(sum, term());
                }
            } else {
                st.pushBack();
                return sum;
            }
        }
    }

    /**
     * Creates a new node with either multiplication or division
     * @return a new node with multiplication or division
     * @throws IOException
     */
    private Sexpr term() throws IOException {

        Sexpr t = factor();

        while (true) {
            st.nextToken();
            if (st.ttype == '*' || st.ttype == '/') {

                int operation = st.ttype;

                if (operation == '*') {
                    t = new symbolic.Multiplication(t, term());
                } else {
                    t = new symbolic.Division(t, term());
                }
            } else {
                st.pushBack();
                return t;
            }
        }
    }

    /**
     * Returns value from primary to term.
     * @return primary
     * @throws IOException
     */
    private Sexpr factor() throws IOException {

        return primary();
    }

    /**
     * Checks if the symbol is a number, a parenthesis or a unary operand.
     * @return a node corresponding to its type otherwise returns null.
     * @throws IOException
     */
    private Sexpr primary() throws IOException {

        while (true) {
            Sexpr p = null;
            int token = st.nextToken();
            if (st.ttype == st.TT_NUMBER) {
                p = number();
            } else if (token == '(') {

                try {
                    p = assignment();
                } catch (NullPointerException e) {
                    throw new SyntaxErrorException("p == null");
                }
                token = st.nextToken();
                if (token != ')') {
                    throw new SyntaxErrorException("Too few ')");
                }
                return p;

            } else if (st.ttype == st.TT_WORD) {

                if (st.sval.equals("log") || st.sval.equals("sin") || st.sval.equals("cos") || st.sval.equals("exp")) {
                    p = unary();
                } else {
                    p = identifier();
                }
            } else if (st.ttype == '-') {
                p = unary();
            } else if (st.ttype == ')') {
                throw new SyntaxErrorException("Too many ')");
            } else {
                st.pushBack();
            }
            return p;
        }
    }

    /**
     * Creates a new node with either log, sin, cos and exp.
     * @return a new node with either log, sin, cos and exp.
     * @throws IOException
     */
    private Sexpr unary() throws IOException {

        Sexpr u = null;
        if (st.ttype == st.TT_WORD) {

            switch (st.sval) {
                case "log":
                    u = new symbolic.Log(primary());
                    break;
                case "sin":
                    u = new symbolic.Sin(primary());
                    break;
                case "cos":
                    u = new symbolic.Cos(primary());
                    break;
                case "exp":
                    u = new symbolic.Exp(primary());
                    break;
            }
        } else {
            u = new symbolic.Negation(primary());
        }

        return u;
    }

    /**
     * Creats a new node with a result of symbolic.Constant();
     * @return new node of a constant
     */
    private Sexpr number() {

        return new symbolic.Constant(st.nval);
    }

    /**
     * Creats a new node with a result of symbolic.Variable()
     * @return new node of a variable
     */
    private Sexpr identifier() {

        return new symbolic.Variable(st.sval);
    }

}



class SyntaxErrorException extends RuntimeException{
    public SyntaxErrorException(){
        super();
    }
    public SyntaxErrorException(String msg){
        super(msg);
    }
}




/* public double expression() throws IOException{

        double sum = term();
        st.nextToken();
        while (st.ttype == '+' || st.ttype == '-'){
            if(st.ttype == '+'){
                sum += term();
            }else{
                sum -= term();
            }
            st.nextToken();
        }
        st.pushBack();
        return sum;
    }
 */