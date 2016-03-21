import symbolic.Sexpr;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by timsvensson on 19/03/16.
 */
public class Calculator {
    public static void main(String[] args) {

        boolean run = true;
        Map<String,Sexpr> variables = new HashMap<String,Sexpr>();


        while (run) {
            try {
                Parser p = new Parser();
                System.out.print("? ");
                Sexpr e = p.statement();



                if (e.isQuit()) {
                    System.out.println("Goodbye");
                    return;
                } else if (e.isVars()) {
                    System.out.println(variables);
                } else if (e.isAssignment()) {
                    variables.put(e.getName(), e.eval());
                    System.out.println(variables);
                } else {
                    System.out.println("Echo: " + e);
                    e = e.eval();
                    System.out.println(e.getValue());
                    variables.put("ans", e);
                }
            } catch(SyntaxErrorException e) {
                System.out.println(e);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
