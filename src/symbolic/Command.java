package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public abstract class Command extends Sexpr {
    @Override
    String getName() {
        return "Command";
    }
}
