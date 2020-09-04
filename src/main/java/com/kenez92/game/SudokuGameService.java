package com.kenez92.game;

import com.kenez92.backtrack.BackTrack;
import com.kenez92.backtrack.LastMove;
import com.kenez92.board.SudokuBoard;
import com.kenez92.board.SudokuElement;
import com.kenez92.resolver.SudokuResolver;

import java.util.List;

public class SudokuGameService {
    private final SudokuResolver sudokuResolver = new SudokuResolver();


    public boolean putNumberIntoBoard(List<Integer> playerMove, SudokuBoard sudokuBoard) {
        if (playerMove.size() == 3) {
            SudokuElement sudokuElement = sudokuBoard.getSudokuRowList()
                    .get(playerMove.get(1) - 1)
                    .getSudokuElementList().get(playerMove.get(0) - 1);
            if (sudokuElement.getValue() == SudokuElement.EMPTY_VALUE) {
                LastMove lastMove = new LastMove(sudokuElement.getPositionX(), sudokuElement.getPositionY(),
                        playerMove.get(2));
                BackTrack.getInstance().addBackTrack(sudokuBoard, lastMove);
                sudokuElement.setValue(playerMove.get(2));
                return true;
            }
        }
        return false;
    }

    public void resolve(SudokuBoard sudokuBoard) {
        sudokuResolver.process(sudokuBoard);
    }
}
