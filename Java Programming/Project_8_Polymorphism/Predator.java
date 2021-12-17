/**
 * Predator is an interface. This class has an abstract method named preysOn() and meant to be implemented in 
 *  Animal subclasses
 * 
 * @author Arman Sarraf
 */
public interface Predator {
	
	/**
	 * preysOn() is an abstract method that could be implemented in other classes such as Goose, Cat. It gets an instance from Animal class
	 * and returns a boolean data type.
	 * @param a
	 * @return boolean
	 */
	public boolean preysOn(Animal a);   // Abstract method
}
