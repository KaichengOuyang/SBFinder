import Utils.*;
import Searcher.*;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
//a2989758-9b73-4144-9288-49d9bc0265ba
public class Main {
    public static boolean load = false;
    public static String UID = "";
    public static void main(String[] args) throws IOException {
        if(!load){
            load();
        }
        CommandListener();
    }

    private static void load() throws IOException {
        System.out.println("Copyright (C) 2022 by Croticalism");
        System.out.println("This program comes with ABSOLUTELY NO WARRANTY.");
        System.out.println("Type 'help' for help.");
        load = true;
        APIKeys.readFromCSV("C:\\Users\\criti\\Desktop\\SBFinder\\src\\Test.csv");
        PlayerUsername.getPlayerUsernameCSV("C:\\Users\\criti\\Desktop\\SBFinder\\src\\Names2.txt");
        //PlayerUsername.getPlayerUsernameCSV("C:\\Users\\criti\\Desktop\\SBFinder\\src\\Players.csv");
    }

    private static void commandHandler(String Command) throws IOException {
        if(Command.equalsIgnoreCase("Help")){
            System.out.println("Searcher is a program that searches for item across the game");
            System.out.println("Usage: Searcher <UID>");
            System.out.println("Example: Searcher db7255c02114");
            CommandListener();
        }else if(Command.startsWith("Core/Searcher")) {
            if(APIKeys.APIKeys.size() == 0 && Objects.equals(UID, "") && PlayerUsername.PlayerUsername.size()==0){
                System.out.println("No API Keys or UID found or no players found");
                CommandListener();
            }
            String[] Args = Command.split(" ");
            if (Args.length == 2) {
                String UID = Args[1];
                SearcherController.main(UID);
            } else {
                System.out.println("Invalid arguments");
                System.out.println("Usage: Searcher <UID>");
            }
        } else if(Command.equalsIgnoreCase("ImportAPIKeys")){
            APIKeys.readFromCSV("C:\\Users\\criti\\Desktop\\SBFinder\\src\\Test.csv");
            load = true;
            CommandListener();
        } else if(Command.startsWith("UID") ){
            String[] Args = Command.split(" ");
            if (Args.length == 2) {
                UID = Args[1];
                System.out.println("UID set to " + UID);
                CommandListener();
            } else {
                System.out.println("Invalid arguments");
                System.out.println("Usage: UID <UID>");
                CommandListener();
            }
        } else if(Command.equalsIgnoreCase("ImportPlayers")){
            PlayerUsername.getPlayerUsername("C:\\Users\\criti\\Desktop\\SBFinder\\src\\names.txt");
            CommandListener();
        }
        else {
            System.out.println("Invalid command");
            System.out.println("Type 'help' for help.");
            CommandListener();
        }
    }

    private static void CommandListener() throws IOException {
        Scanner sc = new Scanner(System.in);
        commandHandler(sc.nextLine());
        sc.close();
    }
}