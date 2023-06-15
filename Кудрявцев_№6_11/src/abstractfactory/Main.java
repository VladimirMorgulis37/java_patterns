package abstractfactory;

public class Main {
    public static void main(String[] args) {
    AnimalFactory factory1 = new SpanishAnimalFactory();
    Cat cat = factory1.createCat();
    Dog dog = factory1.createDog();
    cat.Meow();

    AnimalFactory factory2 = new EnglishAnimalFactory();
    Cat cat1 = factory2.createCat();
    Dog dog1 = factory2.createDog();
    dog1.Bark();
    }
}