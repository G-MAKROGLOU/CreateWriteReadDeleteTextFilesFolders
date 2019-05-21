package com.textEditor.app.classes;

import com.textEditor.app.main.MainClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Delete {
    public void deleteFile()throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the file you want to delete: ");
        String path = scanner.nextLine();
        System.out.println("Enter the name of the file without the .txt extension:");
        String name = scanner.nextLine();
        Path fp = Paths.get(path + "/" + name + ".txt");
        System.out.println("Are you sure you want to delete " + path+"/"+name+".txt? (Y/N)");
        String deleteChoice = scanner.next();
        if(deleteChoice.matches("Y")){
            Files.delete(fp);
            System.out.println("File deleted successfully!");
            MainClass m = new MainClass( );
            String[] args = {" "};
            m.main(args);
        }
        else if(deleteChoice.matches("N")){
            MainClass m = new MainClass();
            String[] args = {" "};
            m.main(args);
        }
    }

    public void deleteFolder() throws IOException{
        String[] args = {" "};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the folder you want to delete: ");
        String path = scanner.nextLine();
        Path folder = Paths.get(path);
        System.out.println("Are you sure you want to delete " + path +  " directory? (Y/N)");
        String delChoice = scanner.next();
        if(delChoice.matches("Y")) {
            Files.delete(folder);
            System.out.println("Directory deleted successfully!");
            MainClass m = new MainClass( );
            m.main(args);
        }else if(delChoice.matches("N")){
            MainClass m1 = new MainClass();
            m1.main(args);
        }
    }
}
