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
        st.eolIsSignificant(true);
    }

    public Sexpr statement() {

        Sexpr s = null;

        try {

            int token = st.nextToken();
            st.pushBack();

            if (token == st.TT_WORD) {
                if (st.sval == "quit" || st.sval == "vars") {
                    s = command();
                }
            } else {
                s = assignment();
            }
        } catch (IOException e) {
            e.printStackTrace();
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
        }

        return sum;
    }

    private Sexpr term() throws IOException {

        Sexpr t = factor();

        st.nextToken();
        if (st.nval == '*' || st.nval == '/') {

        } else {
            st.pushBack();
        }

        return t;
    }

    private Sexpr factor() throws IOException {

        return primary();
    }

    private Sexpr primary() throws IOException {

        Sexpr p = null;
        st.nextToken();

        if (st.ttype == st.TT_NUMBER) {
            p = number();
        } else {
            st.pushBack();
        }
            // ( -> assignment -> )
            // unary
            // identifier

        return p;
    }

    private Sexpr unary() {

        // negate (unary '-')
        // exp
        // log
        // sin
        // cos

        return null;
    }

    private Sexpr number() {

        return new symbolic.Constant(st.nval);
    }

    private Sexpr identifier() {

        return null;
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