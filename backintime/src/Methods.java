public class Methods {

    // afisare inversa a unui numar natural
    // afisare suma cifrelor

    public static void displayInverseAndSumNumber(int x) {
        int sum = 0;
        while (x > 0) {
            int lastDigit = x % 10;
            System.out.print(lastDigit);
            sum = sum + lastDigit;
            x = x / 10;
        }
        System.out.println();
        System.out.println("Sum of digits are: " + sum);

    }
}






