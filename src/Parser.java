/**
 * Created by zohrath on 2016-03-18.
 */
import java.io.StreamTokenizer;
import java.io.IOException;
import symbolic.Sexpr;

class Parser {

    StreamTokenizer st;

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

    private Sexpr command() {

        if (st.sval.equals("quit")) {
            return new symbolic.Quit();
        } else if (st.sval.equals("vars")) {
            return new symbolic.Vars();
        } else {
            throw new SyntaxErrorException();
        }
    }

    public Sexpr assignment() throws IOException {

        Sexpr a = expression();

        while (true) {
            st.nextToken();
            if (st.ttype == '=') {

                st.nextToken();
                if (st.ttype == st.TT_WORD) {
                    return new symbolic.Assignment(a, identifier());
                } else {
                    throw new SyntaxErrorException("Not identifier.");
                }

            } else {
                st.pushBack();
            }
            return a;
        }
    }

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

    private Sexpr factor() throws IOException {

        return primary();
    }

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

    private Sexpr number() {

        return new symbolic.Constant(st.nval);
    }

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