package circus.animal;

import circus.Asset;

public abstract class Animal implements Asset {

    // use abstract on methods to not have to define it
    public abstract String speak();
}