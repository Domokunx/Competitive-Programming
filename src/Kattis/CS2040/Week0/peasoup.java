package Kattis.CS2040.Week0;

import java.util.Scanner;

public class peasoup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        byte restaurants = scanner.nextByte();
        for (int i = 0; i < restaurants; i++) {
            byte items = scanner.nextByte();
            String name = scanner.next();
            boolean hasPancakes = false;
            boolean hasPeaSoup = false;
            for (int j = 0; j < items; j++) {
                String currentItem = scanner.next();
                if (currentItem.equals("pea soup")) hasPeaSoup = true;
                if (currentItem.equals("pancakes")) hasPancakes = true;
            }
            if (hasPancakes && hasPeaSoup) {
                System.out.println(name);
                return;
            }
        }
        System.out.println("Anywhere is fine I guess");
        return;
    }
}
