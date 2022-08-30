package Core.Searcher;

import Core.Utilities.Importer;
import com.sbfinderfx.sbfinderfx.HelloController;

import java.net.MalformedURLException;

public class SearcherMain {

    public static void Searcher() throws MalformedURLException {

        Thread[] Threads = new Thread[Importer.APIKeys.size()];

        for(int i = 0; i < Threads.length; i++){
            while(Importer.PlayerUsername.size() > 0){
                String APIKey = Importer.APIKeys.get(0);
                Importer.APIKeys.remove(APIKey);
                Threads[i] = new Thread(new InventorySearcher(APIKey, Importer.PlayerUsername.get(0), HelloController.getUID()));
                Threads[i].start();
            }
        }
    }
}
