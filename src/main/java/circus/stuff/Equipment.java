package circus.stuff;

import circus.Asset;

public abstract class Equipment implements Asset {
    protected int purchasePrice;

    public Equipment(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    // can make it abstract after adding implements
    public int getValue() {
        return purchasePrice;
    }
}