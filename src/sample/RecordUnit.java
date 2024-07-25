package sample;

import java.io.Serializable;

public class RecordUnit implements Serializable {
    private static final long serialVersionUID = 1L;
    char XorO;
    int Order;
    int placeX;
    int placeY;

    public RecordUnit(char xorO, int order, int placeX, int placeY) {
        XorO = xorO;
        Order = order;
        this.placeX = placeX;
        this.placeY = placeY;
    }

    public char getXorO() {
        return XorO;
    }

    public void setXorO(char xorO) {
        XorO = xorO;
    }

    public int getOrder() {
        return Order;
    }

    public void setOrder(int order) {
        Order = order;
    }

    public int getPlaceX() {
        return placeX;
    }

    public void setPlaceX(int placeX) {
        this.placeX = placeX;
    }

    public int getPlaceY() {
        return placeY;
    }

    public void setPlaceY(int placeY) {
        this.placeY = placeY;
    }

    @Override
    public String toString() {
        return "RecordUnit{" +
                "XorO=" + XorO +
                ", Order=" + Order +
                ", placeX=" + placeX +
                ", placeY=" + placeY +
                '}';
    }
}
