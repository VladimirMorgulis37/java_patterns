package abstractfactory;

public class EnglishAnimalFactory implements AnimalFactory{
    @Override
    public Cat createCat(){
        return new EnglishCat();
    }

    @Override
    public Dog createDog() {
        return new EnglishDog();
    }
}