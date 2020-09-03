package com.kenez92.board;

import com.kenez92.board.SudokuElement;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private final List<SudokuElement> sudokuElementList;

    public SudokuRow(int size) {
        sudokuElementList = new ArrayList<>(size);
    }

    public SudokuRow(int size, int positionY) {
        sudokuElementList = new ArrayList<>(size);
        for (int i = 1; i <= size; i++) {
            sudokuElementList.add(new SudokuElement(size, i, positionY));
        }
    }

    public List<SudokuElement> getSudokuElementList() {
        return this.sudokuElementList;
    }
}