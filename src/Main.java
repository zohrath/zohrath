import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Main {

    public static void main(String[] args) {
        Parser p = new Parser();
        Map<String, Sexpr> variables = new HashMap<String, Sexpr>();

        while (true) {
            System.out.print("? ");
            Sexpr e = p.statement();
            System.out.println("Inläst uttryck: " + e);  // För kontroll
            // System.out.println(e.eval(variables));
        }
    }
}
