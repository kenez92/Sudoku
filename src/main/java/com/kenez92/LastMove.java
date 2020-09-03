package com.kenez92;

public class LastMove {
    private final int positionX;
    private final int positionY;
    private final int value;

    public LastMove(int positionX, int positionY, int value) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.value = value;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getValue() {
        return value;
    }
}