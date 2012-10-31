package zqc.corejava.generics;

public class BoxDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Box<Integer> boxInt = new Box<Integer>(10);
        System.out.println(boxInt);
    }

}
