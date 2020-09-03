package com.kenez92;

import org.junit.Assert;
import org.junit.Test;

public class BackTrackTestSuite {

    @Test
    public void testAddBackTrack() throws CloneNotSupportedException {
        //Given
        LastMove lastMove = new LastMove(1, 1, 1);
        SudokuBoard sudokuBoard = new SudokuBoard(3);
        sudokuBoard.getSudokuRowList().get(0).getSudokuElementList().get(0).setValue(8);
        sudokuBoard.getSudokuRowList().get(3).getSudokuElementList().get(5).setValue(6);
        System.out.println(sudokuBoard);
        //When
        BackTrack.getInstance().addBackTrack(sudokuBoard, lastMove);
        //then
        Assert.assertEquals(1, BackTrack.getInstance().getLastMoves().size());
        Assert.assertEquals(1, BackTrack.getInstance().getSudokuBoards().size());
    }

    @Test
    public void testPollBackTrack() {
        //Given
        LastMove lastMove = new LastMove(1, 1, 1);
        SudokuBoard sudokuBoard = new SudokuBoard(3);
        sudokuBoard.getSudokuRowList().get(1).getSudokuElementList().get(1).setValue(1);
        System.out.println(sudokuBoard);
        //When
        BackTrack.getInstance().addBackTrack(sudokuBoard, lastMove);
        sudokuBoard.getSudokuRowList().get(3).getSudokuElementList().get(5).setValue(6);
        System.out.println(sudokuBoard);
        BackTrack.getInstance().doBackTrack(sudokuBoard);
        //Then
        System.out.println(sudokuBoard);
        Assert.assertEquals(80, sudokuBoard.countEmptyFields());
        Assert.assertEquals(0, BackTrack.getInstance().getSudokuBoards().size());
        Assert.assertEquals(0, BackTrack.getInstance().getLastMoves().size());

    }
}
