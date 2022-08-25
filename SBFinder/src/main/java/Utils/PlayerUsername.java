package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayerUsername {
    public static ArrayList<String> PlayerUsername = new ArrayList<>();

    public static void getPlayerUsername(String fileName) throws IOException {
        // File path is passed as parameter
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null)
            PlayerUsername.addAll(Arrays.asList(st.split(",")));

        System.out.println("Successfully imported " + PlayerUsername.size());

    }

}
