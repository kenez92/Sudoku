package com.kenez92.resolver;

import com.kenez92.board.SudokuBoard;
import com.kenez92.board.SudokuElement;
import com.kenez92.board.SudokuRow;

import java.util.ArrayList;
import java.util.List;

public class SudokuElementsInSection {
    public List<SudokuElement> row(SudokuBoard sudokuBoard, int positionY) {
        SudokuRow sudokuRow = sudokuBoard.getSudokuRowList().get(positionY);
        return new ArrayList<>(sudokuRow.getSudokuElementList());
    }

    public List<SudokuElement> column(SudokuBoard sudokuBoard, int positionX) {
        List<SudokuElement> elements = new ArrayList<>();
        for (int i = 0; i < sudokuBoard.getSize(); i++) {
            elements.add(sudokuBoard.getSudokuRowList().get(i).getSudokuElementList().get(positionX));
        }
        return elements;
    }

    public List<SudokuElement> block(SudokuBoard sudokuBoard, int positionX, int positionY) {
        List<SudokuElement> elements = new ArrayList<>();
        int x = 0;
        int y = 0;
        if (positionX % sudokuBoard.getSizeOfOneBlock() == 0) {
            x = positionX;
        } else {
            x = positionX - (positionX % sudokuBoard.getSizeOfOneBlock());
        }
        if (positionY % sudokuBoard.getSizeOfOneBlock() == 0) {
            y = positionY;
        } else {
            y = positionY - (positionY % sudokuBoard.getSizeOfOneBlock());
        }
        for (int i = x; i < x + sudokuBoard.getSizeOfOneBlock(); i++) {
            for (int j = y; j < y + sudokuBoard.getSizeOfOneBlock(); j++) {
                elements.add(sudokuBoard.getSudokuRowList().get(j).getSudokuElementList().get(i));
            }
        }
        return elements;
    }
}
