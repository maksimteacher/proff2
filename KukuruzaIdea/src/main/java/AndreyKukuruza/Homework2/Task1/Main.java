package AndreyKukuruza.Homework2.Task1;

public class Main {
    public static void main(String[] args) {
        Calc calc = new Calc();
        String str = "177/10=";
        for(char p:str.toCharArray()){
            System.out.println("Input "+p);
            calc.inChar(p);
            System.out.println();
        }
    }
}
