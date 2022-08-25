package Searcher;


import Utils.APIKeys;
import Utils.PlayerUsername;

import java.io.IOException;

public class SearcherController {
    public static void main(String UUID) throws IOException {
        int size = PlayerUsername.PlayerUsername.size()%100;

        Thread[] threads = new Thread[size];
        for (int i = 0; i < threads.length; i++) {
            String player = PlayerUsername.PlayerUsername.get(i);
            threads[i] = new Thread(new InventorySearcher(UUID, player));
            threads[i].start();
        }
    }
}
