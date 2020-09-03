package com.kenez92.game;

import com.kenez92.board.SudokuBoard;
import com.kenez92.board.SudokuElement;
import com.kenez92.controller.SudokuController;
import com.kenez92.resolver.SudokuResolver;

import java.util.List;

public class SudokuGame {
    private final SudokuController sudokuController = new SudokuController();
    private SudokuBoard sudokuBoard = new SudokuBoard(3);
    private final SudokuResolver sudokuResolver = new SudokuResolver();

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public boolean process() {
        sudokuBoard = sudokuController.createSudokuBoard();
        System.out.println(sudokuBoard);
        do {
            if (putNumberIntoBoard(sudokuController.getPlayerMove(sudokuBoard.getSize()))) {
                System.out.println(sudokuBoard);
            } else {
                sudokuController.badPlayerMove();
            }
        } while (sudokuBoard.countEmptyFields() > 0);
        return true; // temporary return true
    }

    public boolean putNumberIntoBoard(List<Integer> playerMove) {
        if (playerMove.size() == 0) {
            sudokuResolver.process(sudokuBoard);
        } else {
            SudokuElement sudokuElement = sudokuBoard.getSudokuRowList()
                    .get(playerMove.get(1) - 1)
                    .getSudokuElementList().get(playerMove.get(0) - 1);
            if (sudokuElement.getValue() == SudokuElement.EMPTY_VALUE) {
                sudokuElement.setValue(playerMove.get(2));
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}