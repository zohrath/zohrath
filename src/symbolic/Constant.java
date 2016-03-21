package symbolic;

import java.util.Map;

/**
 * Created by zohrath on 2016-03-18.
 */
public class Constant extends Atom {

    public Constant(double _value) {
        this.value = _value;
        this.constant = true;
    }

    @Override
    public String getName() {
        return "Constant";
    }

    public double getValue() {
        return this.value;
    }
}