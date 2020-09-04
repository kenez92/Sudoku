package com.kenez92.resolver;

import com.kenez92.board.SudokuBoard;
import com.kenez92.board.SudokuElement;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SudokuElementsInSectionTest {

    @Test
    public void testGetElementsInColumn() {
        //Given
        SudokuElementsInSection sudokuElementsInSection = new SudokuElementsInSection();
        SudokuBoard sudokuBoard = new SudokuBoard(3);
        //When
        List<SudokuElement> sudokuElementList = sudokuElementsInSection.column(sudokuBoard, 2);
        //Then
        for (int i = 0; i < sudokuElementList.size(); i++) {
            Assert.assertEquals(sudokuElementList.get(i).getPositionX(), 2);
            Assert.assertEquals(sudokuElementList.get(i).getPositionY(), i);
        }
    }

    @Test
    public void testGetSudokuElementInRow() {
        //Given
        SudokuElementsInSection sudokuElementsInSection = new SudokuElementsInSection();
        SudokuBoard sudokuBoard = new SudokuBoard(3);
        //When
        List<SudokuElement> sudokuElements = sudokuElementsInSection.row(sudokuBoard, 2);
        //Then
        for (int i = 0; i < sudokuElements.size(); i++) {
            Assert.assertEquals(sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(i).getPositionX(), i);
            Assert.assertEquals(sudokuBoard.getSudokuRowList().get(2).getSudokuElementList().get(i).getPositionY(), 2);
        }
    }

    @Test
    public void testGetSudokuElementInBlock() {
        //Given
        SudokuElementsInSection sudokuElementsInSection = new SudokuElementsInSection();
        SudokuBoard sudokuBoard = new SudokuBoard(3);
        //When
        List<SudokuElement> sudokuElements = sudokuElementsInSection.block(sudokuBoard, 4, 7);
        //Then
        for (int i = 2; i <= 5; i++) {
            Assert.assertEquals(sudokuBoard.getSudokuRowList().get(6).getSudokuElementList().get(i).getPositionX(), i);
            Assert.assertEquals(sudokuBoard.getSudokuRowList().get(6).getSudokuElementList().get(i).getPositionY(), 6);
        }
        for (int i = 2; i <= 5; i++) {
            Assert.assertEquals(sudokuBoard.getSudokuRowList().get(7).getSudokuElementList().get(i).getPositionX(), i);
            Assert.assertEquals(sudokuBoard.getSudokuRowList().get(7).getSudokuElementList().get(i).getPositionY(), 7);
        }
        for (int i = 2; i <= 5; i++) {
            Assert.assertEquals(sudokuBoard.getSudokuRowList().get(8).getSudokuElementList().get(i).getPositionX(), i);
            Assert.assertEquals(sudokuBoard.getSudokuRowList().get(8).getSudokuElementList().get(i).getPositionY(), 8);
        }
    }
}