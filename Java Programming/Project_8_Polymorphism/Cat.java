/**
 * Cat is a subclass of Animal. This class also implements Trainable interface
 * 
 * @author Arman Sarraf
 */
public class Cat extends Animal implements Trainable{

    /**
     * Cat() constructor sets its kind variable
     */
    public Cat() {
        kind = "cat";
    }

    /**
     * speak() implements the Animal speak() method. 
     *  When a cat speaks it says meow.
     *  @return String
     */
    public String speak() {
        return "meow";
    }
    
    /**
     * eat() implements the Animal eat() method. 
     *  When a cat eats it's food is mice.
     *  @return String
     */
    public String eat() {
    	return "mice";
    }
    
    /**
     * doATrick() implements the Trainable doATrick() method. 
     *  Cat have a few tricks.
     *  @return String
     */
    public String doATrick() {
    	return "Cat knows some tricks";
    }
}