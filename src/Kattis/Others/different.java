package Kattis.Others;

import java.io.EOFException;
import java.util.Scanner;

public class different {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        try {
            while (scanner.hasNext()) {
                long firstLong = scanner.nextLong();
                long secondLong = scanner.nextLong();

                System.out.println(Math.abs(firstLong - secondLong));
            }
        }
        catch (Exception e) {

        }
    }
}
