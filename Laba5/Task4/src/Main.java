import java.util.Scanner;

public class Main {
    public static void p(String str) {
        System.out.println(str);
    }
    public static void pStr(String[] arrStr)
    {
        for(String k : arrStr)
            p(k);
    }

    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        int RandomNumber = (int) (Math.random() * ((100 - 0) + 1)) + 0;
        p("Enter integer Number:" + RandomNumber);
        int EnterNumber = -1;
        int[] arr1 = new int[]{0, 100};

        do{
            p("Enter integer Number " + "[" + arr1[0] + "," + arr1[1] + "]");
            while(!enter.hasNextInt())
            {
                System.out.println("u have made a mistake Enter integer Number [0,100]");
                enter.next();
            }
            EnterNumber =enter.nextInt();

            if(arr1[0] < EnterNumber && EnterNumber < RandomNumber )
                    arr1[0] = EnterNumber;
            if(RandomNumber < EnterNumber && EnterNumber < arr1[1])
                arr1[1] = EnterNumber;

        }while((EnterNumber < 0 || EnterNumber > 100) || (EnterNumber != RandomNumber));
        p("MY CONGRATULATION!!!You are winner!!!");
    }
}
