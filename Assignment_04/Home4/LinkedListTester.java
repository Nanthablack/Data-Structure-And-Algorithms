public class LinkedListTester {
    public static void main(String[] args) {
        MyLinkedList mList = new MyLinkedList();
        // -----------------------------------------------------------------------------------------------------------------------
        // your code here
        mList.add(1);
        mList.add(2);
        mList.add(3);
        mList.add(5);
        mList.add(6);

        System.out.println(mList.toString());

        mList.delete(4);
        System.out.println(mList.toString());
    }
}