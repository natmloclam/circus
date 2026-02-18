package circus.animal;

import java.util.Comparator;

import circus.Asset;

public abstract class Animal implements Asset {
    public String name;
    public abstract String speak();

    public static Comparator<Animal> AnimalNameComparator = new Comparator<Animal>() {
        @Override
        public int compare(Animal animal1, Animal animal2) {
            return animal1.name.compareToIgnoreCase(animal2.name);
        }
    };
}