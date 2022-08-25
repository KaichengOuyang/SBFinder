package Utils;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class APIKeys {

    public static ArrayList<String> APIKeys = new ArrayList<>();

    public static void readFromCSV(String fileName) throws IOException {
        // File path is passed as parameter
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null)
            APIKeys.addAll(Arrays.asList(st.split(",")));

        System.out.println("Successfully imported " + Utils.APIKeys.APIKeys);

    }
}
