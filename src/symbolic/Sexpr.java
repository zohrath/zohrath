package symbolic;

import java.util.Map;

/**
 * A symbolic expression.
 *
 * @author Adam Woods
 * @author Tim Svensson
 * @author Axel Hellman
 * @author Edvin Lundberg
 *
 */
public abstract class Sexpr {

    boolean quit = false;
    boolean vars = false;
    boolean assignment = false;
    boolean variable = false;
    boolean constant = false;

    double value = 0;

    /**
     * Sole constructor. (For invocation by subclass
     * constructors, typically implicit.)
     */
    public Sexpr() {

    }

    /**
     * Returns the name of the node.
     * @return the string of the name of the node
     */
    abstract public String getName();

    /**
     * Checks if node is an assignment.
     * @return a variables name
     */
    public boolean isAssignment() {
        return assignment;
    }

    /**
     * Checks if node is a quit-node
     * @return value quit
     */
    public boolean isQuit() {
        return this.quit;
    }

    /**
     * Checks if node is a vars-node
     * @return value of vars
     */
    public boolean isVars() {
        return this.vars;
    }

    /**
     * Checks if the node is a variable
     * @return value of variable
     */
    public boolean isVariable() { return this.variable; }

    /**
     * Checks if nodes is a constant
     * @return value of constant
     */
    public boolean isConstant() { return this.constant; }

    /**
     * Returns the value of the node
     * @return the value of value
     */
    public double getValue() {
        return this.value;
    }

    /**
     *
     * @param variables all the variables stored in the hash map
     * @return the evaluated node(s)
     */
    public abstract Sexpr eval(Map<String,Sexpr> variables);

}
