package DayTwo;

import java.io.File;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) throws Exception {

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

        int totalMinCubes = 0;

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            int getIndexOf = input.indexOf(":");
            input = input.substring(getIndexOf + 1);

            String[] splitBySet = input.split(";");

            int minRed = 0;
            int minGreen = 0;
            int minBlue = 0;

            for (String s : splitBySet) {

                String[] splitByComma = s.split(",");

                for (String value : splitByComma) {
                    String current = value.trim();
                    String numOfCubes = current.substring(0,
                            current.indexOf(" "));
                    int num = Integer.parseInt(numOfCubes);

                    if (current.contains("red") && num > minRed) {
                        minRed = num;
                    } else if (current.contains("green") && num > minGreen) {
                        minGreen = num;
                    } else if (current.contains("blue") && num > minBlue) {
                        minBlue = num;
                    }
                }
            }

            int powerOfSet = minRed * minGreen * minBlue;
            totalMinCubes += powerOfSet;
        }
        scanner.close();
        System.out.println(totalMinCubes);
    }
}