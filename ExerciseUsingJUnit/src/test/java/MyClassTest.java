import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyClassTest {

    public static void main(String[] args) {

    }
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test(expected = IllegalArgumentException.class)
    void testdeleting() {
        MyClass tester = new MyClass();
        assertEquals(1000/5, tester.deleting(1000,5));
    }
    @Test
    public void testMultiply(){
        MyClass tester = new MyClass();
        assertEquals( 50, tester.multiplying(5,10));
    }
}