package circus.animal;

import circus.Asset;

public abstract class Bird extends Animal implements Asset {
    public void fly() {
        System.out.println("Whee ...");
    }

    public int getValue() {
        return 10;
    }
}