import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyClassTest1 {

    @Test
    void deleting() {
        MyClass tester = new MyClass();
        assertEquals(2, tester.deleting(10,5));
    }

    @Test
    void multiplying() {
        MyClass tester = new MyClass();
        assertEquals( 50, tester.multiplying(5,10));
    }
}