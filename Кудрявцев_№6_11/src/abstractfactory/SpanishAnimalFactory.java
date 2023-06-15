package abstractfactory;

public class SpanishAnimalFactory implements AnimalFactory{
    @Override
    public Cat createCat(){
        return new SpanishCat();
    }

    @Override
    public Dog createDog() {
        return new SpanishDog();
    }
}
