// Compile with -Xlint for safety.
// Run with -ea option to enable assertions.
//
//     $ javac -Xlint BstTests.java
//     $ Java -ea BstTests 
//
// If any assertion fails, there is a bug in our program.
// If they all succeed, there may still be bugs.

public class BstTests {

  public static void main(String[] args) {
	/*
	 * Generic Tests.
	 */
    Bst<Integer,String> t1 = new Empty<>();
    assert(t1.size() == 0);
    assert(t1.height() == -1);
    assert(t1.isEmpty());
    System.out.println(t1);
    System.out.println("Test 1 Passed");

    Bst<Integer,String> t2 = t1.put(30,"John");  
    assert(t1.isEmpty());
    assert(t2.size() == 1);
    assert(t2.height() == 0);
    System.out.println(t2);
    System.out.println("Test 2 Passed");
    
    Bst<Integer,String> t3 = t2.put(40,"Mary").put(25,"Peter").put(37,"Monica").put(34,"Nicolas").put(31,"Martin"); 
    assert(t3.size() == 6);
    assert(t2.size() == 1);
    assert(t2.height() == 0);
    System.out.println(t3);
    System.out.println("Test 3 Passed");

    Bst<Integer,String> t4 = t3.put(31,"Kathy"); 
    assert(t3.size() == 6);
    assert(t4.size() == 6);
    System.out.println(t4);
    System.out.println("Test 4 Passed");

    //Test Fork.printInOrder();
    System.out.println("");
    System.out.println("Testing Fork.printInOrder()");
    t4.printInOrder();
    System.out.println("");

    System.out.println("-----Testing Fork.balanced()-----");
    Bst<Integer,String> t5 = t3.balanced();
    assert(t5.size() == t3.size());
    assert(t5.height() <= t3.height());
    assert(t5.height() <= log2floor(t5.size()));
    System.out.println(t5);
    System.out.println("Test 5 Passed");
    
    System.out.println("All Tests passed");
    
  }

  private static int log2floor(int x) {
    assert(x > 0);
    int y = 0; 
    do {
      y = y + 1;
      x = x / 2;
      } while (x > 0);
    return y;
  }
}
