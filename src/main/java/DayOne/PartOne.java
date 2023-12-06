package DayOne;

import java.util.Scanner;

public class PartOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Each line as a separate input, type 'done' when finished:");

        String inputLine;
        StringBuilder documentBuilder = new StringBuilder();
        while (true) {
            inputLine = scanner.nextLine();
            if (inputLine.equals("done")) {
                break;
            }
            documentBuilder.append(inputLine).append("\n");
        }

        scanner.close();

        String[] calibrationDocument = documentBuilder.toString().split("\n");

        int sum = calculateCalibrationSum(calibrationDocument);

        System.out.println("Sum of all values: " + sum);
    }

    private static int calculateCalibrationSum(String[] document) {
        int sum = 0;

        for (String line : document) {
            int calibrationValue = extractCalibrationValue(line);
            sum += calibrationValue;
        }

        return sum;
    }

    private static int extractCalibrationValue(String line) {
        char firstDigit = findFirstDigit(line);
        char lastDigit = findLastDigit(line);
        return Character.getNumericValue(firstDigit) * 10 + Character.getNumericValue(lastDigit);
    }

    private static char findFirstDigit(String line) {
        return line.chars()
                .filter(Character::isDigit)
                .mapToObj(ch -> (char) ch)
                .findFirst()
                .orElse('\0');
    }

    private static char findLastDigit(String line) {
        return new StringBuilder(line).reverse().chars()
                .filter(Character::isDigit)
                .mapToObj(ch -> (char) ch)
                .findFirst()
                .orElse('\0');
    }
}
