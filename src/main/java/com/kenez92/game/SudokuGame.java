package com.kenez92.game;

import com.kenez92.backtrack.BackTrack;
import com.kenez92.board.SudokuBoard;
import com.kenez92.controller.SudokuController;
import com.kenez92.io.IOEnum;

import java.util.List;

public class SudokuGame {
    private final SudokuController sudokuController = new SudokuController();
    private SudokuBoard sudokuBoard;
    private final SudokuGameService sudokuGameService = new SudokuGameService();

    public SudokuGame() {
        BackTrack.getInstance().getLastMoves().clear();
        BackTrack.getInstance().getSudokuBoards().clear();
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public boolean process() {
        sudokuBoard = sudokuController.createSudokuBoard();
        System.out.println(sudokuBoard);
        do {
            IOEnum choice = sudokuController.getPlayerChoice();
            switch (choice) {
                case BACK:
                    BackTrack.getInstance().doBackTrack(sudokuBoard);
                    System.out.println(sudokuBoard);
                    break;
                case HINT:
                    sudokuGameService.getHint(sudokuBoard);
                    System.out.println(sudokuBoard);
                    break;
                case CLEAR:
                    return false;
                case EXIT:
                    System.exit(0);
                    break;
                case SUDOKU:
                    sudokuGameService.resolve(sudokuBoard);
                    System.out.println(sudokuBoard);
                    break;
                case PLAYER_MOVE:
                    List<Integer> playerMove = sudokuController.getPlayerMove(sudokuBoard.getSize());
                    if (sudokuGameService.putNumberIntoBoard(playerMove, sudokuBoard)) {
                        System.out.println(sudokuBoard);
                    } else {
                        sudokuController.badPlayerMove();
                    }
                    break;
            }
        } while (sudokuBoard.countEmptyFields() > 0);
        return sudokuController.playAgain();
    }
}