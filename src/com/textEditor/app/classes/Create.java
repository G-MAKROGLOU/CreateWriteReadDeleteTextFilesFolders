package com.textEditor.app.classes;

import com.textEditor.app.main.MainClass;

import java.io.*;
import java.util.Scanner;

public class Create {
    public void CreateFile() throws IOException{
        System.out.println("Enter the full path of the folder you want your file to be created in: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine( );
        File file = new File(path);
        try {
            file.mkdirs( );
            proceedWithFile( );
        }
       finally {
            System.out.println("Enter the name of the file:");
            String name = scanner.nextLine( );
            file = new File(path + "/" + name + ".txt");
            file.createNewFile( );
            proceedWithWriting(path, name);
        }
    }


    public static boolean proceedWithFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to proceed with creating a file?(Y/N):");
        String answer = scanner.nextLine( );
        if (answer.matches("Y")) return true;
        else if (answer.matches("N")) {
            MainClass m = new MainClass();
            String[] args = {" "};
            m.main(args);
        } else {
            System.out.println("Option not available");
            proceedWithFile( );
        }
        return false;
    }

    public static void proceedWithWriting(String path, String name) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to edit the file now?(Y/N):");
        String answer = scanner.nextLine( );
        if (answer.equalsIgnoreCase("Y")) {
            System.out.println("You can now start typing, use */ at the end of a sentence to save and exit the file editor.");
            Write writer = new Write( );
            writer.startWriting(path, name);
        } else if (answer.equalsIgnoreCase("N")) System.exit(0);
        else {
            System.out.println("Option not available");
            proceedWithWriting(path, name);
        }
    }

}
