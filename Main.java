import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //   System.out.println("Hello world");
//        int inputNumber = 9;
 //       int testNumber = 9;

 //       if (inputNumber > testNumber) {
  //          System.out.println("Liczba " + inputNumber + " jest większa od liczby " + testNumber);
  //      } else if (inputNumber == testNumber) {
   //         System.out.println("Liczby są sobie równe");
   //     } else {
   //         System.out.println("Liczba " + inputNumber + " jest mniejsza od liczby " + testNumber);
    //
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + ", ");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę: ");
        int inputNumber = scanner.nextInt();
        scanner.close();

        System.out.println("Podana liczba to: " + inputNumber);
    }
}