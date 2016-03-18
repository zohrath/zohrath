/**
 * Created by zohrath on 2016-03-18.
 */
import java.io.StreamTokenizer;
import java.io.IOException;

class Parser{
    StreamTokenizer st;

    @Override
    public String toString() {
        return "Parser{" +
                "st=" + st +
                '}';
    }

    public Parser(){
        st = new StreamTokenizer(System.in);
        st.ordinaryChar('-');
        st.ordinaryChar('/');
        st.eolIsSignificant(true);
    }

    public Sexpr statement() {
        return expression();
    }
    public Sexpr expression() {
        Sexpr sum = null;
        try {
            sum = term();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (st.ttype=='+' || st.ttype=='-') {
            int operation = st.ttype;
            try {
                st.nextToken();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (operation=='+')
                try {
                    sum = new Addition(sum, term());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            else
                try {
                    sum = new Subtraction(sum, term());
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return sum;
    }

    private Sexpr term() throws IOException{
        Sexpr prod = factor();

        while (st.nextToken() == '*' || st.nextToken() == '/'){
            int operation = st.ttype;
            try {
                st.nextToken();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (operation == '*') {
                prod = new Multiplication(prod, factor());
            }
            else {
                prod = new Division(prod, factor());
            }
        }
        //st.pushBack();
        return prod;
    }

    private Sexpr factor() throws IOException{
        Sexpr result;
        if(st.nextToken() != '('){
            st.pushBack();
            result = number();
        }else{
            result = expression();
            if(st.nextToken() != ')'){
                throw new SyntaxErrorException("expected ')'");
            }
        }
        return result;
    }

    private Sexpr number() throws IOException{
        if(st.nextToken() != st.TT_NUMBER){
            throw new SyntaxErrorException("Expected number");
        }

        return new Constant(st.nval);
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