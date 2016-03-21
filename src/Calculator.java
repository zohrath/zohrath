import sun.tools.java.SyntaxError;
import symbolic.Binary;
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


                if(e != null) {
                    System.out.println("Echo: " + e);
                    e = e.eval();
                    System.out.println(e.getValue());
                    variables.put("ans", e);
                }
            }
            catch(QuitException e){
                run = false;
            }
            catch (VarsException e){
                System.out.println(variables.values());
            }
            catch(SyntaxErrorException e){
                System.out.println("Syntax Error");
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
