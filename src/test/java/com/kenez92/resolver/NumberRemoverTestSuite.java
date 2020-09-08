package com.kenez92.resolver;

import com.kenez92.board.SudokuBoard;
import com.kenez92.board.SudokuElement;
import org.junit.Assert;
import org.junit.Test;

public class NumberRemoverTestSuite {
    private final NumberRemover numberRemover = new NumberRemover();

    @Test
    public void testExcludeNumbersOnlyBlock() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard(3);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(0).setValue(1);
        sudokuBoard.getSudokuRowList().get(1).getSudokuElementList().get(0).setValue(2);
        sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(0).setValue(3);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(4);
        sudokuBoard.getSudokuRowList().get(1).getSudokuElementList().get(1).setValue(5);
        sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(1).setValue(6);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(2).setValue(7);
        sudokuBoard.getSudokuRowList().get(1).getSudokuElementList().get(2).setValue(8);
        SudokuElement sudokuElement = sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(2);
        //When
        numberRemover.excludeTakenNumbers(sudokuBoard, sudokuElement);
        int number = sudokuElement.getAvailableNumbers().get(0);
        //Then
        Assert.assertEquals(1, sudokuElement.getAvailableNumbers().size());
        Assert.assertEquals(9, number);
    }

    @Test
    public void testExcludeNumbersOnlyColumn() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard(3);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(1);
        sudokuBoard.getSudokuRowList().get(1).getSudokuElementList().get(1).setValue(2);
        sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(1).setValue(3);
        sudokuBoard.getSudokuRowList().get(3).getSudokuElementList().get(1).setValue(4);
        sudokuBoard.getSudokuRowList().get(4).getSudokuElementList().get(1).setValue(5);
        sudokuBoard.getSudokuRowList().get(5).getSudokuElementList().get(1).setValue(6);
        sudokuBoard.getSudokuRowList().get(6).getSudokuElementList().get(1).setValue(7);
        sudokuBoard.getSudokuRowList().get(7).getSudokuElementList().get(1).setValue(8);
        SudokuElement sudokuElement = sudokuBoard.getSudokuRowList().get(8).getSudokuElementList().get(1);
        //When
        numberRemover.excludeTakenNumbers(sudokuBoard, sudokuElement);
        int number = sudokuElement.getAvailableNumbers().get(0);
        //Then
        Assert.assertEquals(1, sudokuElement.getAvailableNumbers().size());
        Assert.assertEquals(9, number);
    }

    @Test
    public void testExcludeNumbersOnlyRow() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard(3);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(0).setValue(1);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(2);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(2).setValue(3);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(3).setValue(4);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(4).setValue(5);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(5).setValue(6);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(6).setValue(7);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(7).setValue(8);
        SudokuElement sudokuElement = sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(8);
        //When
        numberRemover.excludeTakenNumbers(sudokuBoard, sudokuElement);
        int number = sudokuElement.getAvailableNumbers().get(0);
        //Then
        Assert.assertEquals(1, sudokuElement.getAvailableNumbers().size());
        Assert.assertEquals(9, number);
    }

    @Test
    public void testExcludeNumbers() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard(3);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(0).setValue(1);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(2);
        sudokuBoard.getSudokuRowList().get(1).getSudokuElementList().get(2).setValue(4);
        sudokuBoard.getSudokuRowList().get(1).getSudokuElementList().get(2).setValue(5);
        sudokuBoard.getSudokuRowList().get(1).getSudokuElementList().get(2).setValue(6);
        sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(2).setValue(7);
        sudokuBoard.getSudokuRowList().get(1).getSudokuElementList().get(4).setValue(7);
        sudokuBoard.getSudokuRowList().get(1).getSudokuElementList().get(3).setValue(5);
        sudokuBoard.getSudokuRowList().get(8).getSudokuElementList().get(1).setValue(4);
        sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(0).setValue(9);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(4).setValue(8);
        sudokuBoard.getSudokuRowList().get(3).getSudokuElementList().get(0).setValue(8);
        SudokuElement sudokuElement = sudokuBoard.getSudokuRowList().get(1).getSudokuElementList().get(1);
        //When
        numberRemover.excludeTakenNumbers(sudokuBoard, sudokuElement);
        //Then
        Assert.assertEquals(2, sudokuElement.getAvailableNumbers().size());
    }
}