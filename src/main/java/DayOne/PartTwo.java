package DayOne;

import java.util.Arrays;
import java.util.Scanner;

public class PartTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the calibration document (press Enter after each line, type 'done' when finished):");
        StringBuilder inputBuilder = new StringBuilder();
        String line;

        while (true) {
            line = scanner.nextLine();
            if (line.equals("done")) {
                break;
            }
            inputBuilder.append(line).append("\n");
        }

        String input = inputBuilder.toString().trim();
        part2(input);

        scanner.close();
    }

    private static void part2(String input) {
        System.out.println("Day 1 Part 2: " + parseInput(input, true));
    }

    private static int parseInput(String input, boolean replace) {
        String[] lines = input.split("\n");

        return Arrays.stream(lines)
                .filter(line -> !line.isEmpty())
                .map(line -> replace ? replaceWords(line) : line)
                .map(line -> line.chars()
                        .filter(Character::isDigit)
                        .map(Character::getNumericValue)
                        .toArray())
                .mapToInt(digits -> 10 * digits[0] + digits[digits.length - 1])
                .sum();
    }

    private static String replaceWords(String line) {
        return line.replace("one", "one1one")
                .replace("two", "two2two")
                .replace("three", "three3three")
                .replace("four", "four4four")
                .replace("five", "five5five")
                .replace("six", "six6six")
                .replace("seven", "seven7seven")
                .replace("eight", "eight8eight")
                .replace("nine", "nine9nine");
    }
}