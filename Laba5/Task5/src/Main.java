import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        try{
            File file = new File ("text.txt");
            p(file.createNewFile()? "File created: "+file.getName() : "File already exists. ");
            Scanner myReader = new Scanner(file);

            String data = "";
            while(myReader.hasNextLine())
                data += " " + myReader.nextLine();

            p("inform: " + data);
            myReader.close();

            data = data.trim().replaceAll("\\d|\\W"," ");

            p("replace:" + data);
            String[] strArr = data.split("\\s+");

            Stream<String> stringStream= Arrays.stream(strArr);
            List<String> myList=stringStream.sorted((o1,o2)->o1.compareToIgnoreCase(o2)).collect(Collectors.toUnmodifiableList());;
            p("Output data: ");
            pStr(strArr);
            System.out.println(myList);
        }catch(IOException e){
            p("An error occured.");
            e.printStackTrace();
        }

    }
}