/**
 *  Animal is an abstract class. It's speak() and eat()
 *  method are abstract and meant to be implemented in 
 *  Animal subclasses, such as Cow, Cat.
 *  
 *  @author Arman Sarraf
 */
public abstract class Animal {
	
	protected String kind; // Cow, pig, cat, etc.

    /**
     * Animal() default constructor
     */
    public Animal()  {  }

    /**
     * toString() method overrides the Object toString() method.
     */
    public String toString() {
        return "I am a " + kind + " and I go " + speak() + "\n" + "I eat " + eat();
    }

    /**
     * speak() returns an appropriate String representing
     *  the way a certain kind of animal speaks. It is 
     *  implemented in the Animal subclasses.
     */
    public abstract String speak();   // Abstract method
    
    /**
     * eat() returns an appropriate String representing
     *  the food a certain kind of animal eats. It is 
     *  implemented in the Animal subclasses.
     */
    public abstract String eat();   // Abstract method

    /** 
     * main() creates instances of Animal subclasses and invokes
     *  their speak() methods, illustrating inheritance and 
     *  Polymorphism.
     */
	public static void main(String[] args) {
		Animal animal = new Cow(); // Creating an instance from Cow
        System.out.println(animal.toString()); // Printing information about the above animal
        animal = new Cat(); // Creating an instance from Cat
        System.out.println(animal.toString()); // Printing information about the above animal
        animal = new Goose(); // Creating an instance from Goose
        System.out.println(animal.toString()); // Printing information about the above animal
        
        Trainable pet = new Cat(); // Defining a new instance from Cat with the Trainable interface 
        System.out.println(pet.doATrick()); // Printing doATrick() method related to above animal
        pet = new Goose(); // Defining a new instance from Goose with the Trainable interface 
        System.out.println(pet.doATrick()); // Printing doATrick() method related to above animal
        
        Predator pr = new Wolf(); // Defining a new instance from Wolf with the Predator interface 
        System.out.println(pr.toString());
        animal = new Cat(); // Defining a new instance from Wolf with the Predator interface 
        System.out.println("I prey on cat: " + pr.preysOn(new Cat()));
        System.out.println("I prey on goose: " + pr.preysOn(new Goose()));
        System.out.println("I prey on cow: " + pr.preysOn(new Cow()));
        
        
	}

}
