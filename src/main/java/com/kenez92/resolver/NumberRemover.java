package com.kenez92.resolver;

import com.kenez92.board.SudokuBoard;
import com.kenez92.board.SudokuElement;

import java.util.HashSet;
import java.util.List;

public class NumberRemover {
    private final SudokuElementsInSection sudokuElementsInSection = new SudokuElementsInSection();

    public void excludeTakenNumbers(SudokuBoard sudokuBoard, SudokuElement sudokuElement) {
        List<SudokuElement> rowElements = sudokuElementsInSection.row(sudokuBoard, sudokuElement.getPositionY());
        List<SudokuElement> columnElements = sudokuElementsInSection.column(sudokuBoard, sudokuElement.getPositionX());
        List<SudokuElement> blockElements = sudokuElementsInSection.block(sudokuBoard, sudokuElement.getPositionX(),
                sudokuElement.getPositionY());

        HashSet<Integer> takenNumbersInRow = takenNumbers(rowElements);
        HashSet<Integer> takenNumbersInColumn = takenNumbers(columnElements);
        HashSet<Integer> takenNumbersInBlock = takenNumbers(blockElements);

        sudokuElement.getAvailableNumbers().removeIf(takenNumbersInRow::contains);
        sudokuElement.getAvailableNumbers().removeIf(takenNumbersInColumn::contains);
        sudokuElement.getAvailableNumbers().removeIf(takenNumbersInBlock::contains);
    }

    private HashSet<Integer> takenNumbers(List<SudokuElement> elements) {
        HashSet<Integer> takenNumbers = new HashSet<>();
        for (SudokuElement element : elements) {
            takenNumbers.add(element.getValue());
        }
        return takenNumbers;
    }
}