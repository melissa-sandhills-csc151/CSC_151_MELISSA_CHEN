package labs.example.mammals;

public class Mammal {
    // Properties
    String hairColor;
    String eyeColor;
    double bodyTemp;
    String furColor;
    double height;
    double weight;

    // Methods
    public void run() {
        System.out.println("The mammal is running.");
    }

    public void eat() {
        System.out.println("The mammal is eating.");
    }

    public void sleep() {
        System.out.println("The mammal is sleeping.");
    }

    public void scratch() {
        System.out.println("The mammal is scratching.");
    }

    public void drink() {
        System.out.println("The mammal is drinking.");
    }

    public void yawn() {
        System.out.println("The mammal is yawning.");
    }

    public void jump() {
        System.out.println("The mammal is jumping.");
    }

    public void laydown() {
        System.out.println("The mammal is laying down.");
    }

    public void sit() {
        System.out.println("The mammal is sitting.");
    }

    // Main method for testing
    public static void main(String[] args) {
        Mammal myMammal = new Mammal();
        myMammal.run();
        myMammal.eat();
        myMammal.sleep();
        myMammal.scratch();
        myMammal.drink();
        myMammal.yawn();
        myMammal.jump();
        myMammal.laydown();
        myMammal.sit();
    }
}
