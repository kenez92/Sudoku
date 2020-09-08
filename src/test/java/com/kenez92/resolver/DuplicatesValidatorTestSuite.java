package com.kenez92.resolver;

import com.kenez92.board.SudokuBoard;
import org.junit.Assert;
import org.junit.Test;

public class DuplicatesValidatorTestSuite {
    private DuplicatesValidator duplicatesValidator = new DuplicatesValidator();

    @Test
    public void testDuplicateInRowShouldReturnFalse() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard(3);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(1);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(2);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(3);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(4);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(5);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(6);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(7);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(8);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(9);
        //When
        boolean result = duplicatesValidator.process(sudokuBoard);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testDuplicateInRowShouldReturnTrue() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard(3);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(1);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(2);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(3);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(4);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(5);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(6);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(7);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(9);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(9);
        //When
        boolean result = duplicatesValidator.process(sudokuBoard);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testDuplicateInColumnShouldReturnFalse() {
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
        sudokuBoard.getSudokuRowList().get(8).getSudokuElementList().get(1).setValue(9);
        //When
        boolean result = duplicatesValidator.process(sudokuBoard);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testDuplicateInColumnShouldReturnTrue() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard(3);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(1);
        sudokuBoard.getSudokuRowList().get(1).getSudokuElementList().get(1).setValue(2);
        sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(1).setValue(3);
        sudokuBoard.getSudokuRowList().get(3).getSudokuElementList().get(1).setValue(4);
        sudokuBoard.getSudokuRowList().get(4).getSudokuElementList().get(1).setValue(5);
        sudokuBoard.getSudokuRowList().get(5).getSudokuElementList().get(1).setValue(6);
        sudokuBoard.getSudokuRowList().get(6).getSudokuElementList().get(1).setValue(7);
        sudokuBoard.getSudokuRowList().get(7).getSudokuElementList().get(1).setValue(7);
        sudokuBoard.getSudokuRowList().get(8).getSudokuElementList().get(1).setValue(9);
        //When
        boolean result = duplicatesValidator.process(sudokuBoard);
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testDuplicateInBlockShouldReturnTrue() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard(3);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(0).setValue(1);
        sudokuBoard.getSudokuRowList().get(1).getSudokuElementList().get(0).setValue(2);
        sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(0).setValue(3);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(1).setValue(4);
        sudokuBoard.getSudokuRowList().get(1).getSudokuElementList().get(1).setValue(5);
        sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(1).setValue(6);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(2).setValue(7);
        sudokuBoard.getSudokuRowList().get(1).getSudokuElementList().get(2).setValue(7);
        sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(2).setValue(9);
        //When
        boolean result = duplicatesValidator.process(sudokuBoard);
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testDuplicateInBlockShouldReturnFalse() {
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
        sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(2).setValue(9);
        //When
        boolean result = duplicatesValidator.process(sudokuBoard);
        //Then
        Assert.assertFalse(result);
    }

}