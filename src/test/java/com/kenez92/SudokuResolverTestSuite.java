package com.kenez92;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SudokuResolverTestSuite {
    @Test
    public void testResolverProcess() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard(3);
        SudokuResolver sudokuResolver = new SudokuResolver();
        sudokuResolver.process(sudokuBoard);
        List<List<Integer>> rowLists = new ArrayList<>();
        List<List<Integer>> columnLists = new ArrayList<>();
        List<List<Integer>> blockLists = new ArrayList<>();
        int number;
        //When
        SudokuElement sudokuElement;

        for (int i = 0; i < sudokuBoard.getSize(); i++) {
            List<Integer> rowList = new ArrayList<>();
            List<Integer> columnList = new ArrayList<>();

            for (int j = 0; j < sudokuBoard.getSize(); j++) {
                sudokuElement = sudokuBoard.getSudokuRowList().get(i).getSudokuElementList().get(j);
                number = sudokuElement.getValue();
                if (!rowList.contains(number) && number != SudokuElement.EMPTY_VALUE) {
                    rowList.add(number);
                }
                sudokuElement = sudokuBoard.getSudokuRowList().get(j).getSudokuElementList().get(i);
                number = sudokuElement.getValue();
                if (!columnList.contains(number) && number != SudokuElement.EMPTY_VALUE) {
                    columnList.add(number);
                }
            }
            rowLists.add(rowList);
            columnLists.add(columnList);
        }

        for (int i = 0; i < sudokuBoard.getSize(); i = i + sudokuBoard.getSizeOfOneBlock()) {
            for (int j = 0; j < sudokuBoard.getSize(); j = j + sudokuBoard.getSizeOfOneBlock()) {
                int resultX = 0;
                int resultY = 0;
                if (j % sudokuBoard.getSizeOfOneBlock() == 0) {
                    resultX = j;
                } else {
                    resultX = j / sudokuBoard.getSizeOfOneBlock() * sudokuBoard.getSizeOfOneBlock();
                }
                if (i % sudokuBoard.getSizeOfOneBlock() == 0) {
                    resultY = i;
                } else {
                    resultY = i / sudokuBoard.getSizeOfOneBlock() * sudokuBoard.getSizeOfOneBlock();
                }
                List<Integer> blockList = new ArrayList<>();
                int sizeX = resultX + sudokuBoard.getSizeOfOneBlock();
                int sizeY = resultY + sudokuBoard.getSizeOfOneBlock();
                for (int k = resultX; k < sizeX; ++k) {
                    for (int l = resultY; l < sizeY; ++l) {
                        sudokuElement = sudokuBoard.getSudokuRowList().get(l).getSudokuElementList().get(k);
                        number = sudokuElement.getValue();
                        if (number != SudokuElement.EMPTY_VALUE && !blockList.contains(number)) {
                            blockList.add(number);
                        }
                    }
                }
                blockLists.add(blockList);
            }
        }
        System.out.println(sudokuBoard);
        //Then
        for (List<Integer> rowList : rowLists) {
            int size = rowList.size();
            Assert.assertEquals(9, size);
        }
        for (List<Integer> columnList : columnLists) {
            int size = columnList.size();
            Assert.assertEquals(9, size);
        }
        for (List<Integer> blockList : blockLists) {
            int size = blockList.size();
            Assert.assertEquals(9, size);
        }
    }
}
