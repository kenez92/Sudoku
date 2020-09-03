package com.kenez92.board;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype {
    private List<SudokuRow> sudokuRowList;
    private final int size;
    private final int sizeOfOneBlock;

    public SudokuBoard(int size) {
        this.size = size * size;
        this.sizeOfOneBlock = size;
        sudokuRowList = new ArrayList<>();
        for (int i = 1; i <= this.size; i++) {
            sudokuRowList.add(new SudokuRow(this.size, i));
        }
    }

    public int getSize() {
        return size;
    }

    public int getSizeOfOneBlock() {
        return sizeOfOneBlock;
    }

    public List<SudokuRow> getSudokuRowList() {
        return this.sudokuRowList;
    }

    public void setSudokuRowList(List<SudokuRow> sudokuRowList) {
        this.sudokuRowList = sudokuRowList;
    }

    @Override
    public String toString() {
        String board = " ~~~~~~~~~~ SUDOKU BOARD ~~~~~~~~~~ \n\n";
        board = board + "x -> ";
        for (int i = 1; i <= sudokuRowList.size(); i++) {
            if (i == 1) {
                board = board + "|";
            }
            board = board + i + "|";
            if (i % sizeOfOneBlock == 0 && i != sudokuRowList.size()) {
                board = board + " |";
            }
        }
        board = board + "\ny";
        for (int i = 0; i < sudokuRowList.size(); i++) {
            if (i < 9) {
                board = board + "\n" + (i + 1) + "  - ";
            } else {
                board = board + "\n" + (i + 1) + " - ";
            }
            for (int j = 0; j < sudokuRowList.get(i).getSudokuElementList().size(); j++) {
                if (j % sizeOfOneBlock == 0 && j != 0) {
                    board = board + "| ";
                }
                board = board + "|";
                if (sudokuRowList.get(i).getSudokuElementList().get(j).getValue() == SudokuElement.EMPTY_VALUE) {
                    board = board + "_";
                } else {
                    board = board + sudokuRowList.get(i).getSudokuElementList().get(j).getValue();
                }
            }
            board = board + "|";
            if ((i + 1) % sizeOfOneBlock == 0) {
                board = board + "\n";
            }
        }
        return board;
    }

    public int countEmptyFields() {
        int counter = 0;
        for (SudokuRow sudokuRow : sudokuRowList) {
            for (SudokuElement sudokuElement : sudokuRow.getSudokuElementList()) {
                if (sudokuElement.getValue() == SudokuElement.EMPTY_VALUE) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public SudokuBoard deepClone() throws CloneNotSupportedException {
        SudokuBoard clonedSudokuBoard = (SudokuBoard) super.clone();
        clonedSudokuBoard.setSudokuRowList(new ArrayList<>(size));
        for (SudokuRow sudokuRow : sudokuRowList) {
            SudokuRow clonedSudokuRow = new SudokuRow(size);
            for (int j = 0; j < sudokuRow.getSudokuElementList().size(); j++) {
                SudokuElement sudokuElement = sudokuRow.getSudokuElementList().get(j);
                clonedSudokuRow.getSudokuElementList().add(new SudokuElement(
                        sudokuElement.getPositionX(),
                        sudokuElement.getPositionY(),
                        sudokuElement.getValue(),
                        sudokuElement.getAvailableNumbers()));
            }
            clonedSudokuBoard.getSudokuRowList().add(clonedSudokuRow);
        }
        return clonedSudokuBoard;
    }
}