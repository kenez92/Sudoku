package com.kenez92;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SudokuRandomValue {
    private final Random random = new Random();

    public boolean setRandomValue(SudokuBoard sudokuBoard) {
        List<SudokuElement> sudokuElements = getEveryEmptySudokuElement(sudokuBoard);
        if (sudokuElements.size() != 0) {
            int randomElement = random.nextInt(sudokuElements.size());
            SudokuElement sudokuElement = sudokuElements.get(randomElement);
            if (sudokuElement.getAvailableNumbers().size() != 0) {
                int randomValue = random.nextInt(sudokuElement.getAvailableNumbers().size());
                int value = sudokuElement.getAvailableNumbers().get(randomValue);
                sudokuElement.setValue(value);
                LastMove lastMove = new LastMove(sudokuElement.getPositionX(),
                        sudokuElement.getPositionY(), value);
                BackTrack.getInstance().addBackTrack(sudokuBoard, lastMove);
                return true;
            }
        }
        return false;
    }

    private List<SudokuElement> getEveryEmptySudokuElement(SudokuBoard sudokuBoard) {
        List<SudokuElement> emptySudokuElements = new ArrayList<>();
        for (SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()) {
            for (SudokuElement sudokuElement : sudokuRow.getSudokuElementList()) {
                if (sudokuElement.getValue() == SudokuElement.EMPTY_VALUE && sudokuElement.getAvailableNumbers().size() > 0) {
                    emptySudokuElements.add(sudokuElement);
                }
            }
        }
        return emptySudokuElements;
    }
}
