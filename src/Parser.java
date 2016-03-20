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
        st.eolIsSignificant(true);
    }

    public Sexpr statement() {

        Sexpr s = null;

        try {

            int token = st.nextToken();
            st.pushBack();

            if (st.sval == "quit" || st.sval == "vars") {
                    s = command();

            } else {
                s = assignment();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (s == null) {
            throw new SyntaxErrorException();
        }

        return s;
    }

    private Sexpr command() {

        // quit
        // vars

        return null;
    }

    public Sexpr assignment() throws IOException {

        Sexpr a = expression();

        // =
        // identifier

        return a;
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
                    p.addParenthesis();
                } catch (NullPointerException e) {
                    throw new SyntaxErrorException("p == null");
                }

                token = st.nextToken();

                if (token != ')') {
                    throw new SyntaxErrorException();
                }
                p.subParenthesis();
                if (p.getParenthesis() < 0) {
                    throw new SyntaxErrorException();
                }

                return p;

            } else if (st.ttype == st.TT_WORD) {
                switch (st.sval) {
                    case "log":
                    case "sin":
                    case "cos":
                    case "exp":
                        p = unary();
                        break;
                    default:
                        p = identifier();
                }
            } else if (st.ttype == '-') {
                p = unary();


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