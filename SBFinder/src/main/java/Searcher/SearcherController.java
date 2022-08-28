package Searcher;


import Utils.PlayerUsername;

import java.util.Random;

public class SearcherController {
    public static boolean found = false;
    public static void main(String UUID) {
        int total = PlayerUsername.PlayerUsername.size();
        Thread[] threads = new Thread[total];
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i] = new Thread(new InventorySearcher(UUID, PlayerUsername.PlayerUsername.get(i)));
                PlayerUsername.PlayerUsername.remove(i);
                threads[i].start();
            } catch (Exception ignored) {
            }
        }
    }
}
