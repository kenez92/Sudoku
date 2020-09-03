package com.kenez92;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IO {
    private static final String INFO_SIZE_OF_THE_BOARD = "What size of the board do you want (2 - 9)? : ";
    private static final String ERR_NUMBERS_ARE_NOT_GOOD = "Please put properly number (2 - 9) : ";
    private static final String INFO_PLAYER_MOVE_INPUT = "Where do you want to put number ? (x, y, value) :";
    private static final String ERR_INPUT_LIST_IS_NOT_EQUAL_TO_3 = "Please put only three numbers (x, y and value)";
    private static final String SUDOKU = "SUDOKU";
    private static final String ERR_BAD_VALUE = "Please put only numbers (x, y and value)";
    private static final String ERR_VALUE_IS_BIGGER_THAN_BOARD_SIZE = "Your number is bigger than board! Put properly numbers :";
    private static final String ERR_BAD_PLAYER_MOVE = "This field is not empty !";
    private final Scanner scanner = new Scanner(System.in);

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
            resultList = convertToIntegers(move, boardSize * boardSize);
            if (resultList.size() != 3) {
                move = scanner.nextLine();
            }
        } while (resultList.size() != 3);
        return resultList;
    }

    private List<Integer> convertToIntegers(String input, int boardSize) {
        List<String> numbers = Arrays.asList(input.split(" |,"));
        List<Integer> resultList = new ArrayList<>();
        if (numbers.size() != 3) {
            System.out.println(ERR_INPUT_LIST_IS_NOT_EQUAL_TO_3);
            return new ArrayList<>();
        }
        for (String element : numbers) {
            for (int i = 0; i < element.length(); i++) {
                char character = element.charAt(i);
                byte characterCode = (byte) character;
                if (!(characterCode >= 38 && characterCode <= 57)) {
                    System.out.println(ERR_BAD_VALUE);
                    return new ArrayList<>();
                }
            }
            int number = Integer.parseInt(element);
            if (number > 0 && number <= boardSize) {
                resultList.add(number);
            } else {
                System.out.println(ERR_VALUE_IS_BIGGER_THAN_BOARD_SIZE);
                return new ArrayList<>();
            }
        }
        return resultList;
    }

    public void badPlayerMove() {
        System.out.println(ERR_BAD_PLAYER_MOVE);
    }
}