import java.util.ArrayList;

public class ArrayList_Code {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] p = new Integer[8];

        //Integer[] integers = list.toArray(new Integer[]{0,0,0,0,0,0});
        Integer[] integers = list.toArray(p);

        for (int i = 0; i < integers.length; i++) {
            System.out.println(integers[i]);

        }
    }
}
