import symbolic.Sexpr;

/**
 * Created by timsvensson on 19/03/16.
 */
public class Calculator {
    public static void main(String[] args) {

        Parser p = new Parser();

        System.out.print("? ");
        Sexpr e = p.statement();

        System.out.println("Echo: " + e);
    }
}
