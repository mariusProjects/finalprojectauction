public class CMMDC {

    public static int cmmdc(int a, int b){
        int t;
        while (b != 0)
        {
            t = b;
            System.out.println("t: " + t);
            b = a % b;
            System.out.println("b: " + b);
            a = t;
            System.out.println("a: " + a);
        }
        System.out.println("CMMDC este: " + a);
        return a;
    }
}
