package Kattis.Others;

import java.util.ArrayList;
import java.util.Scanner;

public class ofugsnuid {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        var numberArray = new ArrayList<Integer>();

        for (int i = 0; i < count; i++) {
            numberArray.add(scanner.nextInt());
        }

        for (int i = (numberArray.size() - 1); i >= 0; i--){
            System.out.println(numberArray.get(i));
        }
    }
}
