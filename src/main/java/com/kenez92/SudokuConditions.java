package com.kenez92;

import java.util.HashSet;

public class SudokuConditions {
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
        for (SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()) {
            for (SudokuElement element : sudokuRow.getSudokuElementList()) {
                if (element != sudokuElement) {
                    availableNumbersInOtherFields.addAll(sudokuElement.getAvailableNumbers());
                }
            }
        }
        for (Integer availableNumber : sudokuElement.getAvailableNumbers()) {
            if (!availableNumbersInOtherFields.contains(availableNumber)) {
                sudokuElement.setValue(availableNumber);
                return true;
            }
        }
        return false;
    }

    private boolean noAvailableNumbers(SudokuElement sudokuElement, SudokuBoard sudokuBoard) {
        boolean result = false;
        if (sudokuElement.getAvailableNumbers().size() == 0) {
            result = makeBackTrack(sudokuBoard);
        }
        return result;
    }

    public boolean makeBackTrack(SudokuBoard sudokuBoard) {
        if (BackTrack.getInstance().getSudokuBoards().size() > 0 && BackTrack.getInstance().getLastMoves().size() > 0) {
            SudokuBoard backSudokuBoard = BackTrack.getInstance().getSudokuBoards().pollFirst();
            LastMove lastMove = BackTrack.getInstance().getLastMoves().pollFirst();
            SudokuElement sudokuElement = backSudokuBoard.getSudokuRowList().get(lastMove.getPositionY())
                    .getSudokuElementList().get(lastMove.getPositionX());
            sudokuElement.getAvailableNumbers().remove(Integer.valueOf(lastMove.getValue()));
            sudokuBoard.setSudokuRowList(backSudokuBoard.getSudokuRowList());
            return true;
        }
        return false;
    }
}