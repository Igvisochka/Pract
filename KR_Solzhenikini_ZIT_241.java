import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.close();

        int nFloor = (int) Math.floor(Math.sqrt(x));
        int nCeil = nFloor + 1;

        long diffFloor = x - (long) nFloor * nFloor;
        long diffCeil = (long) nCeil * nCeil - x;

        System.out.println(diffFloor < diffCeil ? nFloor : nCeil);
    }
}