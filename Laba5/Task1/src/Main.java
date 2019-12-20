import java.util.*;
/*---
    Додавання: time HashSet < time ArrayList < time LinkedList < time TreeSet
    Пошук: time HashSet < time TreeSet < time ArrayList < time LinkedList
    Видалення: time HashSet < time ArrayList < time LinkedList < time TreeSet

     NOTE: LinkedList при додаванні повільніший за ArrayList;
    TreeSet повільніше за всіх додає елементи, бо внього вони зразу сортуються(при збільшенні кількості елементів стає швидшив за всіх);
    HashSet найшвидше додаються елементи
    ArrayList організований як масив з елементів лінійний
    LinkedList організований як List пошук по індексу довший ніж ArrayList
    TreeSet реалізований як червоно-чорне дерево  add, remove and search take O(Log n) time
    Underlying data structure for HashSet is hashtable,
    Objects that you insert in HashSet are not guaranteed to be inserted in same order. Objects are inserted based on their hash code.
    ArrayList змінює свій розмір в процеці видалення об'єктів
    ---*/
public class Main {
    int Size = 100;
    public static void main(String[] args) {
        List<Integer> ArrList = new ArrayList<>();
        List<Integer> ArrLinkedList = new LinkedList<>();
        AbstractSet<Integer> ArrTreeSet = new TreeSet<>();
        AbstractSet<Integer> ArrHashSet = new HashSet<>();
        Main ObjMain = new Main();
        int[] ArrInt = new int[ObjMain.Size];
        for(int i = 0; i < ObjMain.Size; i++){
            int Number = (int) (Math.random() * ((1000 + 1000) + 1)) - 1000;
            long NowTime = System.nanoTime();
            ArrList.add(Number);
            ArrInt[i] = Number;
            long AfterTime = System.nanoTime();
            System.out.println("AddNumber: " + Number + " Result of nano time ArrayList:");
            System.out.println(AfterTime - NowTime);

            NowTime = System.nanoTime();
            ArrLinkedList.add(Number);
            AfterTime = System.nanoTime();
            System.out.println("AddNumber: " + Number + " Result of nano time LinkedList:");
            System.out.println(AfterTime - NowTime);

            NowTime = System.nanoTime();
            ArrTreeSet.add(Number);
            AfterTime = System.nanoTime();
            System.out.println("AddNumber: " + Number + " Result of nano time TreeSet:");
            System.out.println(AfterTime - NowTime);

            NowTime = System.nanoTime();
            ArrHashSet.add(Number);
            AfterTime = System.nanoTime();
            System.out.println("AddNumber: " + Number + " Result of nano time HashSet:");
            System.out.println((AfterTime - NowTime) + " step:" + i  +"\n");
        }

        for(int i = 0; i < ObjMain.Size; i++) {
            int Number = ArrInt[i];
            long NowTime = System.nanoTime();
            boolean Trust = ArrList.contains(Number);
            long AfterTime = System.nanoTime();
            System.out.println("FindNumber: " + Number + " "+ Trust + " Result of nano time ArrayList:");
            System.out.println(AfterTime - NowTime);

            NowTime = System.nanoTime();
            Trust = ArrLinkedList.contains(Number);
            AfterTime = System.nanoTime();
            System.out.println("FindNumber: " + Number + " "+ Trust +" Result of nano time LinkedList:");
            System.out.println(AfterTime - NowTime);

            NowTime = System.nanoTime();
            Trust = ArrTreeSet.contains(Number);
            AfterTime = System.nanoTime();
            System.out.println("FindNumber: " + Number + " "+ Trust +" Result of nano time TreeSet:");
            System.out.println(AfterTime - NowTime);

            NowTime = System.nanoTime();
            Trust = ArrHashSet.contains(Number);
            AfterTime = System.nanoTime();
            System.out.println("FindNumber: " + Number + " "+ Trust + " Result of nano time HashSet:");
            System.out.println((AfterTime - NowTime) + " step:" + i +"\n");
        }

        for(int i = 0; i < ObjMain.Size/2.0; i++) {
            int Number = ArrInt[i];
            long NowTime = System.nanoTime();
            ArrList.remove(i);
            long AfterTime = System.nanoTime();
            System.out.println("RemoveNumber: " + Number + " Result of nano time ArrayList:");
            System.out.println(AfterTime - NowTime);

            NowTime = System.nanoTime();
            ArrLinkedList.remove(i);
            AfterTime = System.nanoTime();
            System.out.println("RemoveNumber: " + Number + " Result of nano time LinkedList:");
            System.out.println(AfterTime - NowTime);

            NowTime = System.nanoTime();
            ArrTreeSet.remove(Number);
            AfterTime = System.nanoTime();
            System.out.println("RemoveNumber: " + Number + " Result of nano time TreeSet:");
            System.out.println(AfterTime - NowTime);

            NowTime = System.nanoTime();
            ArrHashSet.remove(i);
            AfterTime = System.nanoTime();
            System.out.println("RemoveNumber: " + Number + " Result of nano time HashSet:");
            System.out.println((AfterTime - NowTime) + " step:" + i + "\n");
        }
    }
}