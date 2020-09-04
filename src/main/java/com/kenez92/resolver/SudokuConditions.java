package com.kenez92.resolver;

import com.kenez92.backtrack.BackTrack;
import com.kenez92.backtrack.LastMove;
import com.kenez92.board.SudokuBoard;
import com.kenez92.board.SudokuElement;

import java.util.HashSet;
import java.util.List;

public class SudokuConditions {
    private final SudokuElementsInSection sudokuElementsInSection = new SudokuElementsInSection();

    public boolean process(SudokuElement sudokuElement, SudokuBoard sudokuBoard) {
        if (noAvailableNumbers(sudokuElement, sudokuBoard)) {
            return true;
        } else if (onlyOneAvailableNumber(sudokuElement)) {
            return true;
        } else if (notAvailableInOtherFields(sudokuElement, sudokuBoard)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean onlyOneAvailableNumber(SudokuElement sudokuElement) {
        if (sudokuElement.getAvailableNumbers().size() == 1) {
            sudokuElement.setValue(sudokuElement.getAvailableNumbers().get(0));
            return true;
        }
        return false;
    }

    private boolean notAvailableInOtherFields(SudokuElement sudokuElement, SudokuBoard sudokuBoard) {
        HashSet<Integer> availableNumbersInOtherFields = new HashSet<>();
        if (sudokuElement.getAvailableNumbers().size() > 1) {
            List<SudokuElement> rowElements = sudokuElementsInSection.row(sudokuBoard, sudokuElement.getPositionY());
            rowElements.remove(sudokuElement);
            List<SudokuElement> columnElements = sudokuElementsInSection.column(sudokuBoard, sudokuElement.getPositionX());
            columnElements.remove(sudokuElement);
            List<SudokuElement> blockElements = sudokuElementsInSection.block(sudokuBoard, sudokuElement.getPositionX(),
                    sudokuElement.getPositionY());
            blockElements.remove(sudokuElement);

            availableNumbersInOtherFields.addAll(getAvailableNumbersInSection(rowElements));
            availableNumbersInOtherFields.addAll(getAvailableNumbersInSection(columnElements));
            availableNumbersInOtherFields.addAll(getAvailableNumbersInSection(blockElements));
        }
        if (availableNumbersInOtherFields.size() > 0) {
            for (Integer number : sudokuElement.getAvailableNumbers()) {
                if (!availableNumbersInOtherFields.contains(number)) {
                    sudokuElement.setValue(number);
                    sudokuElement.getValue();
                    LastMove lastMove = new LastMove(sudokuElement.getPositionX(), sudokuElement.getPositionY(), number);
                    BackTrack.getInstance().addBackTrack(sudokuBoard, lastMove);
                    return true;
                }

            }
        }
        return false;
    }


    private boolean noAvailableNumbers(SudokuElement sudokuElement, SudokuBoard sudokuBoard) {
        boolean result = false;
        if (sudokuElement.getAvailableNumbers().size() == 0) {
            result = BackTrack.getInstance().doBackTrack(sudokuBoard);
        }
        return result;
    }

    private HashSet<Integer> getAvailableNumbersInSection(List<SudokuElement> sudokuElements) {
        HashSet<Integer> availableNumbersInSection = new HashSet<>();
        for (SudokuElement sudokuElement : sudokuElements) {
            availableNumbersInSection.addAll(sudokuElement.getAvailableNumbers());
        }
        return availableNumbersInSection;
    }
}