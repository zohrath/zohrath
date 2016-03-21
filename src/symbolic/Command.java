package symbolic;

import java.util.Map;

/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Command extends Sexpr {
    @Override
    public String getName() {
        return "Command";
    }
    @Override
    public Sexpr eval(Map<String,Sexpr> variables) {
        return null;
    }
}
