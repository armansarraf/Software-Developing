/**
 * Cow is a subclass of Animal.
 * 
 * @author Arman Sarraf
 */
public class Cow extends Animal {

    /**
     * Cow() constructor sets its kind variable
     */
    public Cow() {
        kind = "cow";
    }

    /**
     * speak() implements the Animal speak() method. 
     *  When a cow speaks it says moo.
     *  @return String
     */
    public String speak() {
        return "moo";
    }
    
    /**
     * eat() implements the Animal eat() method. 
     *  When a cow eats it's food is hay.
     *  @return String
     */
    public String eat() {
    	return "hay";
    }
}