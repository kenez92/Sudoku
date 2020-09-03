package com.kenez92;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SudokuElement {
    public final static int EMPTY_VALUE = -1;
    private int value;
    private final int positionX;
    private final int positionY;
    private final List<Integer> availableNumbers;

    public SudokuElement(int size, int positionX, int positionY) {
        value = EMPTY_VALUE;
        this.positionX = positionX - 1;
        this.positionY = positionY - 1;
        availableNumbers = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            availableNumbers.add(i);
        }
    }

    public SudokuElement(int positionX, int positionY, int value, List<Integer> availableNumbers) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.value = value;
        this.availableNumbers = new ArrayList<>(availableNumbers);
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getAvailableNumbers() {
        return this.availableNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuElement that = (SudokuElement) o;
        return positionX == that.positionX &&
                positionY == that.positionY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionX, positionY);
    }
}