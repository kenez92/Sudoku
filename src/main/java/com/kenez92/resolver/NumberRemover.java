package com.kenez92.resolver;

import com.kenez92.board.SudokuBoard;
import com.kenez92.board.SudokuElement;
import com.kenez92.board.SudokuRow;

import java.util.HashSet;

public class NumberRemover {
    public void excludeTakenNumbers(SudokuBoard sudokuBoard, SudokuElement sudokuElement) {
        HashSet<Integer> takenNumbersInRow = takenNumbersInRow(sudokuBoard, sudokuElement.getPositionY());
        HashSet<Integer> takenNumbersInColumn = takenNumbersInColumn(sudokuBoard, sudokuElement.getPositionX());
        HashSet<Integer> takenNumbersInBlock = takenNumbersInBlock(sudokuBoard, sudokuElement.getPositionX(),
                sudokuElement.getPositionY());
        sudokuElement.getAvailableNumbers().removeIf(takenNumbersInRow::contains);
        sudokuElement.getAvailableNumbers().removeIf(takenNumbersInColumn::contains);
        sudokuElement.getAvailableNumbers().removeIf(takenNumbersInBlock::contains);
    }

    private HashSet<Integer> takenNumbersInRow(SudokuBoard sudokuBoard, int positionY) {
        HashSet<Integer> takenNumbers = new HashSet<>();
        SudokuRow sudokuRow = sudokuBoard.getSudokuRowList().get(positionY);
        for (SudokuElement sudokuElement : sudokuRow.getSudokuElementList()) {
            takenNumbers.add(sudokuElement.getValue());
        }
        return takenNumbers;
    }

    private HashSet<Integer> takenNumbersInColumn(SudokuBoard sudokuBoard, int positionX) {
        HashSet<Integer> takenNumbers = new HashSet<>();
        for (int i = 0; i < sudokuBoard.getSize(); i++) {
            SudokuElement sudokuElement = sudokuBoard.getSudokuRowList().get(i).getSudokuElementList().get(positionX);
            takenNumbers.add(sudokuElement.getValue());
        }
        return takenNumbers;
    }

    private HashSet<Integer> takenNumbersInBlock(SudokuBoard sudokuBoard, int positionX, int positionY) {
        HashSet<Integer> takenNumbers = new HashSet<>();
        int x = 0;
        int y = 0;
        if (positionX % sudokuBoard.getSizeOfOneBlock() == 0) {
            x = positionX;
        } else {
            x = positionX - (positionX % sudokuBoard.getSizeOfOneBlock());
        }
        if (positionY % sudokuBoard.getSizeOfOneBlock() == 0) {
            y = positionY;
        } else {
            y = positionY - (positionY % sudokuBoard.getSizeOfOneBlock());
        }
        for (int i = x; i < x + sudokuBoard.getSizeOfOneBlock(); i++) {
            for (int j = y; j < y + sudokuBoard.getSizeOfOneBlock(); j++) {
                SudokuElement sudokuElement = sudokuBoard.getSudokuRowList().get(j).getSudokuElementList().get(i);
                takenNumbers.add(sudokuElement.getValue());
            }
        }
        return takenNumbers;
    }
}