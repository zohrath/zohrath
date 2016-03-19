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
            boolean eof = false;
            do {
                st.nextToken();

                if (st.ttype == st.TT_EOF || st.ttype == st.TT_EOL) {
                    eof = true;
                } else {
                    s = assignment();
                }

            } while (!eof);
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

        if (st.ttype != st.TT_EOF || st.ttype != st.TT_EOL) {
            st.nextToken();
        }
        
        while (st.ttype == '+' || st.ttype == '-') {
            int operation = st.ttype;
            st.nextToken();
            Sexpr tmp = null;
            if (operation == '+') {
                tmp = new symbolic.Addition(sum, term());
            } else {
                tmp = new symbolic.Subtraction(sum, term());
            }
            sum = tmp;
        }

        return sum;
    }

    private Sexpr term() {

        Sexpr t = factor();

        // *
        // /

        return t;
    }

    private Sexpr factor() {

        return primary();
    }

    private Sexpr primary() {

        Sexpr p = null;

        if (st.ttype == st.TT_NUMBER) {
            p = number();
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