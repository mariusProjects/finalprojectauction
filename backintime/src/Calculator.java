import java.util.Scanner;

public class Calculator {

    public static void calculate(){
        Scanner s = new Scanner(System.in);

        System.out.println("Primul termen");
        Integer first = s.nextInt();

        System.out.println("Operator");
        String operator = s.next();

        System.out.println("Al doilea termen");
        Integer second = s.nextInt();



        switch (operator){
            case "+":
                System.out.println("Suma numerelor este: " + (first + second));
                break;
            case "-":
                System.out.println("Diferenta numerelor este" + (first - second));
                break;
            case "*":
                System.out.println("Produsul numerelor este: " + (first * second));
                break;
            case"/":
                System.out.println("Restul impartirii este: " + (first / second));
                break;

        }




    }
}
