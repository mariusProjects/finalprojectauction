public class Palindrome {
    public static boolean isStringPalindrome(String string){
        String inverse = "";
                for(int i = string.length()-1; i >= 0; i--){
                    inverse = inverse + string.charAt(i);
                }
        System.out.println(inverse);
        System.out.println(string);
         if(string.equals(inverse)){
             return true;
         }else{
             return false;
         }

    }

    public static boolean isNumberPalindrome(int number){
        int lastDigit;
        int inverse = 0 ;
        int compare = number;
        while (number > 0){
            lastDigit = number % 10;
            inverse =( inverse * 10) + lastDigit;
            number = number / 10;
        }
        System.out.println(inverse);
        System.out.println(compare);
        if (inverse == compare){
            return true;
        }
        return false;
    }


}
