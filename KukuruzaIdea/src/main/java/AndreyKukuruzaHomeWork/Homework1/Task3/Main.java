package AndreyKukuruzaHomeWork.Homework1.Task3;

public class Main {
    public static void main(String[] args) throws Exception {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        for (int i = 0; i < 10000; i++) {
            myArrayList.add(i + "");
        }
        System.out.println(myArrayList.size());
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
        myArrayList.sort();
        System.out.println();
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
    }
}