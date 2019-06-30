package main;

import main.Animal;
import main.BreedType;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main1 {

    public static void main(String[] args) {
        List<Animal> animals = Arrays.asList(
                new Cat("cat1", BreedType.Abyssinian), new Cat("cat2", BreedType.Aegean),
                new Cat("cat3", BreedType.American_Bobtail), new Cat("cat4", BreedType.American_Curl),
                new Cat("cat5", BreedType.American_Shorthair), new Cat("cat6", BreedType.American_Wirehair),
                new Cat("cat7", BreedType.Aphrodite_Giant), new Cat("cat8", BreedType.Arabian_Mau),
                new Cat("cat9", BreedType.Asian), new Cat("cat10", BreedType.Asian_Semilonghair),
                new Cat("cat11", BreedType.Australian_Mist), new Cat("cat12", BreedType.Balinese),
                new Cat("cat13", BreedType.Bambino), new Cat("cat14", BreedType.Bengal),
                new Cat("cat15", BreedType.Birman), new Cat("cat16", BreedType.Bombay),
                new Cat("cat17", BreedType.Brazilian_Shorthair), new Cat("cat18", BreedType.British_Longhair),
                new Cat("cat19", BreedType.British_Semilonghair), new Cat("cat20", BreedType.British_Shorthair),
                new Cat("cat21", BreedType.Burmese), new Cat("cat22", BreedType.Burmilla),
                new Cat("cat23", BreedType.California_Spangled), new Cat("cat24", BreedType.Chantilly_Tiffany),
                new Cat("cat25", BreedType.Chartreux), new Cat("cat26", BreedType.Chausie),
                new Cat("cat27", BreedType.Cheetoh), new Cat("cat28", BreedType.Colorpoint_Shorthair),
                new Cat("cat29", BreedType.Cornish_Rex), new Cat("cat30", BreedType.Cymric),
                new Cat("cat31", BreedType.Cyprus), new Cat("cat32", BreedType.Donskoy),
                new Cat("cat33", BreedType.Devon_Rex), new Cat("cat34", BreedType.Dragon_Li),
                new Cat("cat35", BreedType.Dwelf), new Cat("cat36", BreedType.Egyptian_Mau),
                new Cat("cat37", BreedType.European_Shorthair), new Cat("cat38", BreedType.Exotic_Shorthair),
                new Cat("cat39", BreedType.Foldex), new Cat("cat40", BreedType.German_Rex),
                new Cat("cat41", BreedType.Havana_Brown), new Cat("cat42", BreedType.Highlander),
                new Cat("cat43", BreedType.Himalayan), new Cat("cat44", BreedType.Japanese_Bobtail),
                new Cat("cat45", BreedType.Javanese), new Cat("cat46", BreedType.Karelian_Bobtail),
                new Cat("cat47", BreedType.Khao_Manee), new Cat("cat48", BreedType.Korat),
                new Cat("cat49", BreedType.Korean_Bobtail), new Cat("cat50", BreedType.Korn_Ja) );

        Function<Cat, BreedType> change = Cat::getBreedType;
        List breedTypes = animals.stream().filter(cat -> {
            if (cat instanceof Cat) {
                if (((Cat) cat).getBreedType().toString().startsWith("A") ||
                        ((Cat) cat).getBreedType().toString().startsWith("C") ||
                        ((Cat) cat).getBreedType().toString().startsWith("P"))
                    return true;
            }
            return false;
        }).filter(cat -> Integer.parseInt(cat.getName().substring(3)) % 2 == 0)
                .map(c -> change.apply((Cat) c)).collect(Collectors.toList());

        System.out.println(breedTypes);
    }
}
