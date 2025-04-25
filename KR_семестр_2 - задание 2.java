import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        int upperCount = 0;
        int lowerCount = 0;
   
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    upperCount++;
                } else {
                    lowerCount++;
                }
            }
        }

        String result;
        if (upperCount > lowerCount) {
            result = input.toUpperCase();
        } else {
            result = input.toLowerCase();
        }

        System.out.println(result);
    }
}
