import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static final int MaxSize = 150;
    public static void main(String[] args) {
        Main max = new Main();

        List<Integer> Alfa = new ArrayList<>();

        for(int i = 0; i < max.MaxSize; i++)
            Alfa.add((int) (Math.random() * ((1000 + 1000) + 1)) - 1000);
        List<Integer> Betta = Alfa.stream().sorted((p1,p2)->p2-p1).limit(15).collect(Collectors.toList());
        System.out.println(Alfa);
        System.out.println(Betta);
    }
}
