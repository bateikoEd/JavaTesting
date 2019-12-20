import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        System.out.println("Enter word:");
        String str1 = enter.next(), str2 = "";

        for(int i = str1.length() - 1; i >= 0; i--)
        {
            str2 += str1.charAt(i);
        }

        System.out.println("Enter word:\t" + str1 + "\nReverse word:\t" + str2);
    }

}
