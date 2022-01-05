/**
 * Trainable is an interface. This class has an abstract method named doATrick() and meant to be implemented in 
 *  Animal subclasses
 * 
 * @author Arman Sarraf
 */
public interface Trainable {

	/**
	 * doATrick() is an abstract method that could be implemented in other classes such as Goose, Cat.
	 * @return String
	 */
	public abstract String doATrick(); // An abstract method 
}
