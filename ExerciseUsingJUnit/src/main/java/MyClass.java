

public class MyClass {

    public int deleting(int x, int y){
        if(y==0){
            throw new IllegalArgumentException("Y should be not 0");
        }
        return x/y;
    }

    public int multiplying(int x, int y){

        if(x > 999){
            throw new IllegalArgumentException("X should be less than 1000");
        }
        return x*y;
    }
    public static void main(String[] args) {

    }
}
