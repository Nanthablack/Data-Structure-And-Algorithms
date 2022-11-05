public class StackTester {
    public static void main(String[] args) {

        System.out.println();

        MyStackA stackA = new MyStackA();
        stackA.push(1);
        stackA.push(2);
        stackA.push(3);
        stackA.push(4);
        stackA.push(5);
        stackA.push(6);
        stackA.push(7);

        System.out.println(stackA);

        stackA.pop();
        stackA.pop();
        System.out.println(stackA);

        stackA.push(8);
        stackA.top();
        System.out.println(stackA);
        stackA.pop();
        stackA.pop();
        stackA.pop();
        stackA.pop();
        stackA.pop();
        System.out.println(stackA);
        stackA.pop();
        System.out.println(stackA);
        System.out.println("Empty :" + stackA.isEmpty());
        System.out.println("Full  :" + stackA.isFull());

        System.out.println();

        for (int i = 0; i < 100; i++) {
            stackA.push(1);
        }
        System.out.println("StackA isFull = " + stackA.isFull());

        System.out.println();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        MyStackL stackL = new MyStackL();
        stackL.push(1);
        stackL.push(2);
        stackL.push(3);
        stackL.push(4);
        stackL.push(5);
        stackL.push(6);
        stackL.push(7);

        System.out.println(stackL);

        stackL.pop();
        System.out.println(stackL);
        stackL.pop();
        System.out.println(stackL);

        stackL.push(8);
        stackL.top();
        System.out.println(stackL);
        stackL.pop();
        stackL.pop();
        stackL.pop();
        stackL.pop();
        stackL.pop();
        System.out.println(stackL);
        stackL.pop();
        System.out.println(stackL);
        System.out.println("Empty :" + stackL.isEmpty());
        System.out.println("Full  :" + stackL.isFull());
        System.out.println();

        System.out.println(); // ================================================================

        System.out.println();

    }
}