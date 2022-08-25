package Searcher;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class InventorySearcher implements Runnable{

    private Thread t;
    private final String UID;
    private final URL url;
    private final String player;

    InventorySearcher(String UID, String Player) throws MalformedURLException {
        this.UID = UID;
        URL url = new URL("https://api.slothpixel.me/api/skyblock/profile/" + Player);
        this.url = url;
        this.player = Player;
    }


    @Override
    public void run() {
            //Retrieving the contents of the specified page
            Scanner sc;
            try {
                sc = new Scanner(url.openStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //Instantiating the StringBuffer class to hold the result
            StringBuffer sb = new StringBuffer();
            while(sc.hasNext()) {
                sb.append(sc.next());
                //System.out.println(sc.next());
            }
            String result = sb.toString();
            result = result.replaceAll("<[^>]*>", "");
            if(result.contains(UID)) {
                System.out.println("Found " + UID + " in " + player);
                System.exit(0);
            }
        }

    public void start () {
        if (t == null) {
            t = new Thread (this, UID);
            t.start ();
        }
    }
}
