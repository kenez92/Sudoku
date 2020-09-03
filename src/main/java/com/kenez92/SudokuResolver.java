package com.kenez92;

public class SudokuResolver {
    private final NumberRemover numberRemover = new NumberRemover();
    private final SudokuConditions conditions = new SudokuConditions();
    private final SudokuRandomValue sudokuRandomValue = new SudokuRandomValue();

    public void process(SudokuBoard sudokuBoard) {
        boolean result = false;
        boolean conditionResult = false;
        do {
            result = false;
            conditionResult = false;
            for (SudokuRow sudokuRow : sudokuBoard.getSudokuRowList()) {
                for (SudokuElement sudokuElement : sudokuRow.getSudokuElementList()) {
                    if (sudokuElement.getValue() == SudokuElement.EMPTY_VALUE) {
                        numberRemover.excludeTakenNumbers(sudokuBoard, sudokuElement);
                        conditionResult = conditions.process(sudokuElement, sudokuBoard);
                        if (conditionResult == true && result == false) {
                            result = true;
                        }
                    }
                }
            }
            if (!conditionResult) {
                result = sudokuRandomValue.setRandomValue(sudokuBoard);
            }
        } while (result);
    }
}
