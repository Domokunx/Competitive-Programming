package Kattis.CS2040.Week8Practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class zipf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int songs = scanner.nextInt();
        int targetCount = scanner.nextInt();
        int firstSongListens = scanner.nextInt();
        PriorityQueue<Song> songsByQuality = new PriorityQueue<>(songs, new SongComparator());
        songsByQuality.add(new Song(1, firstSongListens, scanner.next(), 1));
        for (int i = 2; i <= songs; i++) {
            int songListens = scanner.nextInt();
            songsByQuality.add(new Song(i, songListens, scanner.next(), songListens / (double)(firstSongListens / i)));
        }
        for (int i = 0; i < targetCount; i++) {
            System.out.println(songsByQuality.remove());
        }
    }
    static class SongComparator implements Comparator<Song> {
        @Override
        public int compare(Song o1, Song o2) {
            if (o1.quality < o2.quality)
                return 1;
            else if (o1.quality > o2.quality)
                return -1;
            else if (o1.quality == o2.quality) {
                if (o1.rank > o2.rank)
                    return -1;
                else return 0;
            }
            return 0;
        }
    }
    private static class Song {
        private int rank;
        private int listens;
        private String name;
        private double quality;

        public Song(int rank, int listens, String name, double quality) {
            this.listens = listens;
            this.rank = rank;
            this.name = name;
            this.quality = quality;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
