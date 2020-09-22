import java.util.*;

public class SystemIn {

    public static List<String> nameList = new ArrayList<String>();

    public static void insertFromKeyboard() {
        Scanner obj = new Scanner(System.in);
        System.out.println("Introduceti de la tastatura");
        String name = obj.nextLine();
        nameList.add(name);
        System.out.println("Numele este: " + name);

        Iterator it = nameList.iterator();

        while(it.hasNext()){
            System.out.println(name);
        }

    }

}
