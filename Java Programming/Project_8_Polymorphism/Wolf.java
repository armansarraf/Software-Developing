/**
 * Wolf is a subclass of Animal. It also implements Predator interface.
 * 
 * @author Arman Sarraf
 */
public class Wolf extends Animal implements Predator{
	/**
	 * Wolf() constructor sets its kind variable
	 */
	public Wolf() {
        kind = "Wolf";
    }

    /**
     * speak() implements the Animal speak() method. 
     *  When a Wolf speaks it says roar.
     *  @return String
     */
    public String speak() {
        return "roar";
    }
    
    /**
     * eat() implements the Animal eat() method. 
     *  When a Wolf eats it's food is meat.
     *  @return String
     */
    public String eat() {
    	return "meat";
    }
	
    /**
     * preysOn() implements the Predator preysOn() method. It gets an instance of Animal and after determining the condition 
     * it returns true or false.
     *  @return boolean
     */
	public boolean preysOn(Animal a) {
		if (a instanceof Cow) {
			return false;
		} // If a be an instance of Cow it returns false
		else if (a instanceof Cat) {
			return true;
		} // If a be an instance of Cat it returns true
		else if(a instanceof Goose) {
			return true;
		} // If a be an instance of Goose it returns true
		return false;
	}

}
