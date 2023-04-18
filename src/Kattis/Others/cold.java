package Kattis.Others;

import java.util.Scanner;

public class cold {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        byte count = scanner.nextByte();
        byte lessThanZero = 0;
        for (int i = 0; i < count; i++){
            int temperature = scanner.nextInt();
            if (temperature < 0) lessThanZero++;
        }
        System.out.println(lessThanZero);
    }
}
