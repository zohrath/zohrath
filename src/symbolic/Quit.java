package symbolic;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Quit extends Command {

    public Quit() {
        super();
        this.quit = true;
    }

    @Override
    public String getName() {
        return "Quit";
    }
}
