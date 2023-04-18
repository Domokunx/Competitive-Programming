package Kattis.Others;

import java.util.Scanner;

public class pyramids{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int blocks = scanner.nextInt();
        int layer = 1;
        short height = 0;

        while (blocks >= (layer * layer)){
            blocks = blocks - (layer * layer);
            layer += 2;
            height++;
        }
        System.out.println(height);
    }
}