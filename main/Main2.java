package main;

import main.Animal;
import main.BreedType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(filterbynameandbreedtype(initList()));
    }


    private static List<Animal> initList() {
        List<Animal> animals = new ArrayList<>();
        BreedType[] breedTypes = BreedType.values();
        for (int i = 0; i < 99; i++) {
            animals.add(new Cat("cat" + (i + 1), breedTypes[i]));
        }
        return animals;
    }

    private static List<BreedType> filterbynameandbreedtype(List<Animal> animals) {
        Function<Cat, BreedType> change = Cat::getBreedType;
        List<BreedType> catsBreedTypes = animals.stream().filter(cat -> {
            if (cat instanceof Cat) {
                if (((Cat) cat).getBreedType().toString().startsWith("A") ||
                        ((Cat) cat).getBreedType().toString().startsWith("C") ||
                        ((Cat) cat).getBreedType().toString().startsWith("P"))
                    return true;
            }
            return false;
        }).filter(cat -> Integer.parseInt(cat.getName().substring(3)) % 2 == 0)
                .map(c -> change.apply((Cat) c)).collect(Collectors.toList());
        return catsBreedTypes;
    }
}


