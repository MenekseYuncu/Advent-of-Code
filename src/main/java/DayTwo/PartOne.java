package DayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/main/java/DayTwo/input.txt"));
/*
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

        scanner.close();*/

        int possible = 0;

        int red = 12;
        int green = 13;
        int blue = 14;

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            int getIndexOf = input.indexOf(":");
            int gameNumber = Integer.parseInt(
                    input.substring("Game".length() + 1, getIndexOf));
            input = input.substring(getIndexOf + 1);

            String[] splitBySet = input.split(";");
            boolean canPlay = true;

            for (String set : splitBySet) {
                int countRed = 0;
                int countGreen = 0;
                int countBlue = 0;

                if (!canPlay) {
                    break;
                }

                String[] splitByComma = set.split(",");

                for (String current : splitByComma) {
                    current = current.trim();
                    String numOfCubes = current.substring(0, current.indexOf(" "));
                    int num = Integer.parseInt(numOfCubes);

                    if (current.contains("red")) {
                        countRed += num;
                    } else if (current.contains("green")) {
                        countGreen += num;
                    } else if (current.contains("blue")) {
                        countBlue += num;
                    }

                    if (canPlay && (countRed > red || countGreen > green || countBlue > blue)) {
                        canPlay = false;
                    }
                }
            }
            if (canPlay) {
                possible += gameNumber;
            }
        }
        scanner.close();
        System.out.println(possible);
    }
}