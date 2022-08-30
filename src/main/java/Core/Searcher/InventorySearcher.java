package Core.Searcher;


import Core.Utilities.Importer;
import com.sbfinderfx.sbfinderfx.HelloController;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class InventorySearcher implements Runnable {

    private static String UID = "";
    private final URL url;
    private static String player = "";
    private static String APIKey = "";

    InventorySearcher(String APIKeys, String Player, String UID) throws MalformedURLException {
        InventorySearcher.UID = UID;
        this.url = new URL("https://api.slothpixel.me/api/skyblock/profile/" + Player);
        InventorySearcher.player = Player;
        InventorySearcher.APIKey = APIKeys;
    }


    @Override
    public void run() {
        //Retrieving the contents of the specified page
        Scanner sc;
        try {
            sc = new Scanner(url.openStream());
        } catch (Exception e) {
            Importer.UncheckedPlayers.add(player);
            return;
        }
        //Instantiating the StringBuffer class to hold the result
        StringBuffer sb = new StringBuffer();
        while (sc.hasNext()) {
            sb.append(sc.next());
            //System.out.println(sc.next());
        }
        String result = sb.toString();
        result = result.replaceAll("<[^>]*>", "");
        if (result.contains(UID)) {
            foundPlayer();
        }
    }

    private static void foundPlayer(){
        HelloController.Output.appendText("Found " + UID + " in " + player);
    }

}