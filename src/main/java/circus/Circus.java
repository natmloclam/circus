package circus;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import circus.stuff.Equipment;
import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Ladder;

import circus.animal.Animal;
import circus.animal.Duck;
import circus.animal.Parrot;
import circus.animal.Tiger;
import circus.animal.Elephant;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
        ArrayList<Animal> animalArrayList = new ArrayList<Animal>(Arrays.asList(animals));
        animalArrayList.add(new Elephant("Strong one"));
        printAllAnimals(animalArrayList);
        printNumberOfAnimals(animalArrayList);

        animalArrayList.add(new Duck("Andy"));
        Tiger sherKhan = new Tiger("Sher Khan");
        animalArrayList.add(sherKhan);
        Parrot bobby = new Parrot("Bobby");
        animalArrayList.add(bobby);

        System.out.println("Position of Sher Khan in the array list: " + animalArrayList.indexOf(sherKhan));
        printNumberOfAnimals(animalArrayList);
        printAllAnimals(animalArrayList);

        Animal candidate = findAnimal(animalArrayList, "Polly");
        System.out.println("Polly is at index: " + animalArrayList.indexOf(candidate));

        // sorting
        System.out.println("Before sorting");
        printAllAnimals(animalArrayList);

        animalArrayList.sort(Animal.AnimalNameComparator);
        System.out.println("After sorting");
        printAllAnimals(animalArrayList);

        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("Louie");
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot("Blu");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);

        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);

        for(Cage c: cages) {
            c.release();
        }
    }

    private static void printNumberOfAnimals(ArrayList<Animal> animalArrayList) {
        System.out.println("number of animals in circus (AL): " + animalArrayList.size());
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }

    private static Animal findAnimal (ArrayList<Animal> animalArrayList, String name) {
        for (Animal a : animalArrayList) {
            if (a.name.equals(name)) {
                return a;
            }
        }
        return null;
    }
}