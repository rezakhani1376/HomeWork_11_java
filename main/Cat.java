package main;

import main.Animal;
import main.BreedType;

public class Cat extends Animal {
    private BreedType breedType;

    public Cat(String name, BreedType breedType) {
        super(name);
        this.breedType = breedType;
    }

    public BreedType getBreedType() {
        return breedType;
    }

    public void setBreedType(BreedType breedType) {
        this.breedType = breedType;
    }

    @Override
    public String toString() {
        return "main.Cat{" +
                " name= " + super.getName() +
                ", breedType=" + breedType +
                '}';
    }
}