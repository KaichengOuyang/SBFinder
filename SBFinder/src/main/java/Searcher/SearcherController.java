package Searcher;


import Utils.PlayerUsername;

import java.net.MalformedURLException;

public class SearcherController {
    public static boolean found = false;
    public static int SearchedPlayers = 0;
    public static void main(String UUID) throws MalformedURLException {
        int threadss = 5;
        int total = PlayerUsername.PlayerUsername.size();
        Thread[] threads = new Thread[threadss];
        do {
            int i;
            for (i = 0; i < threads.length; i++) {
                String Username;
                try {
                    Username = PlayerUsername.PlayerUsername.get(i);
                    PlayerUsername.PlayerUsername.remove(Username);
                } catch (Exception e) {
                    continue;
                }
                threads[i] = new Thread(new InventorySearcher(UUID, Username));
                threads[i].start();
            }
        }
        while(PlayerUsername.PlayerUsername.size() > 0);
    }
}
