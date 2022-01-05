/**
 * Goose is a subclass of Animal. This class also implements Trainable interface. 
 * 
 * @author Arman Sarraf
 */
public class Goose extends Animal implements Trainable{
	
	 /**
     * Goose() constructor sets its kind variable
     */
	public Goose() {
		kind = "goose";
	}
	
	/**
     * speak() implements the Animal speak() method. 
     *  When a goose speaks it says cluck.
     *  @return String
     */
    public String speak() {
        return "cluck";
    }
    
    /**
     * eat() implements the Animal eat() method. 
     *  When a goose eats it's food is grass and seeds.
     *  @return String
     */
    public String eat() {
    	return "grass and seeds";
    }
    
    /**
     * doATrick() implements the Trainable doATrick() method. 
     *  Goose does not know any tricks.
     *  @return String
     */
    public String doATrick() {
    	return "Goose does not do any ticks";
    }
}
