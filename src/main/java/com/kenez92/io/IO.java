package com.kenez92.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IO {
    private static final String INFO_SIZE_OF_THE_BOARD = "What size of the board do you want (2 - 9)? : ";
    private static final String ERR_NUMBERS_ARE_NOT_GOOD = "Please put properly number (2 - 9) : ";
    private static final String INFO_PLAYER_MOVE_INPUT = "Where do you want to put number ? (x, y, value) :";
    private static final String SUDOKU = "SUDOKU";
    private static final String BACK = "BACK";
    private static final String CLEAR = "CLEAR";
    private static final String EXIT = "EXIT";
    private static final String HINT = "HINT";
    private static final String PLAYER_MOVE = "PLAYER_MOVE";
    private static final String ERR_BAD_PLAYER_MOVE = "This field is not empty !";
    private static final String INFO_PLAY_AGAIN = "Do you want to play again ? (y = yes, n = no)";
    public static final String ERR_PLAY_AGAIN = "Please type 'y' to play again or 'n' to finish game";
    public static final String INFO_PLAYER_OPTION = "\nType : \"back\" to get back last move\n" +
            "Type \"clear\", to start new game\n" + "Type \"exit\" to close game" + "Type \"hint\" to get hint\n" +
            "Type \"SUDOKU\" to resolve sudoku\n" + "TYPE \"move\" to make new move\n";
    public static final String ERR_I_DONT_UNDERSTAND = "Sorry I dont understand your answer... ";
    private final Scanner scanner = new Scanner(System.in);
    private final IOService ioService = new IOService();

    public int getSudokuSize() {
        System.out.println(INFO_SIZE_OF_THE_BOARD);
        while (true) {
            String input = scanner.nextLine();
            if (input.length() > 1) {
                System.out.println(ERR_NUMBERS_ARE_NOT_GOOD);
            } else {
                byte size = (byte) input.charAt(0);
                if (size > 49 && size <= 57) {
                    return Character.getNumericValue(size);
                } else {
                    System.out.println(ERR_NUMBERS_ARE_NOT_GOOD);
                }
            }
        }
    }

    public List<Integer> getPlayerMove(int boardSize) {
        System.out.println(INFO_PLAYER_MOVE_INPUT);
        String move = scanner.nextLine();
        if (move.equals(SUDOKU)) {
            return new ArrayList<>();
        }
        List<Integer> resultList = new ArrayList<>();
        do {
            resultList = ioService.convertToIntegers(move, boardSize * boardSize);
            if (resultList.size() != 3) {
                move = scanner.nextLine();
            }
        } while (resultList.size() != 3);
        return resultList;
    }

    public void badPlayerMove() {
        System.out.println(ERR_BAD_PLAYER_MOVE);
    }

    public boolean playAgain() {
        System.out.println(INFO_PLAY_AGAIN);
        String answer = scanner.nextLine();
        while (true) {
            if (answer.equals("y")) {
                return false;
            } else if (answer.equals("n")) {
                return true;
            } else {
                System.out.println(ERR_PLAY_AGAIN);
                answer = scanner.nextLine();
            }
        }
    }

    public IOEnum getPlayerChoice() {
        System.out.println(INFO_PLAYER_OPTION);
        String input = scanner.nextLine().toUpperCase();
        while (true) {
            switch (input) {
                case BACK:
                    return IOEnum.BACK;
                case SUDOKU:
                    return IOEnum.SUDOKU;
                case EXIT:
                    return IOEnum.EXIT;
                case HINT:
                    return IOEnum.HINT;
                case CLEAR:
                    return IOEnum.CLEAR;
                case PLAYER_MOVE:
                    return IOEnum.PLAYER_MOVE;
                default:
                    System.out.println(ERR_I_DONT_UNDERSTAND);
            }
        }
    }
}