package com.kenez92.resolver;

import com.kenez92.board.SudokuBoard;
import com.kenez92.board.SudokuElement;
import com.kenez92.board.SudokuRow;

import java.util.HashSet;

public class DuplicatesValidator {
    public boolean process(SudokuBoard sudokuBoard) {
        if (duplicatesInRow(sudokuBoard)) {
            return true;
        } else if (duplicatesInColumn(sudokuBoard)) {
            return true;
        } else if (duplicatesInBlock(sudokuBoard)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean duplicatesInRow(SudokuBoard sudokuBoard) {
        for (SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()) {
            HashSet<Integer> numberSet = new HashSet<>();
            for (SudokuElement sudokuElement : sudokuRow.getSudokuElementList()) {
                int number = sudokuElement.getValue();
                if (numberSet.contains(number) && number != SudokuElement.EMPTY_VALUE) {
                    return true;
                } else {
                    if (number != SudokuElement.EMPTY_VALUE) {
                        numberSet.add(number);
                    }
                }
            }
        }
        return false;
    }

    private boolean duplicatesInColumn(SudokuBoard sudokuBoard) {
        for (int i = 0; i < sudokuBoard.getSize(); i++) {
            HashSet<Integer> numberSet = new HashSet<>();
            for (int j = 0; j < sudokuBoard.getSize(); j++) {
                int number = sudokuBoard.getSudokuRowList().get(i).getSudokuElementList().get(j).getValue();
                if (numberSet.contains(number) && number != SudokuElement.EMPTY_VALUE) {
                    return true;
                } else {
                    if (number != SudokuElement.EMPTY_VALUE) {
                        numberSet.add(number);
                    }
                }
            }
        }
        return false;
    }

    public boolean duplicatesInBlock(SudokuBoard sudokuBoard) {
        HashSet<Integer> numberSet = new HashSet<>();
        int x = 0;
        int y = 0;
        for (int n = 0; n < sudokuBoard.getSize(); n++) {
            x = n % sudokuBoard.getSizeOfOneBlock() * sudokuBoard.getSizeOfOneBlock();
            if (n % sudokuBoard.getSizeOfOneBlock() == 0) {
                y = n;
            }
            for (int i = x; i < x + sudokuBoard.getSizeOfOneBlock(); i++) {
                for (int j = y; j < y + sudokuBoard.getSizeOfOneBlock(); j++) {
                    int number = sudokuBoard.getSudokuRowList().get(j).getSudokuElementList().get(i).getValue();
                    if (numberSet.contains(number) && number != SudokuElement.EMPTY_VALUE) {
                        return true;
                    } else {
                        if (number != SudokuElement.EMPTY_VALUE) {
                            numberSet.add(number);
                        }
                    }
                }
            }
            numberSet.clear();
        }
        return false;
    }
}
