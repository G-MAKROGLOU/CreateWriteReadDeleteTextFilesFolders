package com.textEditor.app.main;

import java.io.*;
import java.util.Scanner;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.textEditor.app.classes.*;

public class MainClass {
    public static void main(String[] args) {
        String menuChoice;
        System.out.println("Console Text Editor - CTE");
        System.out.println("==========================");
        Scanner scanner = new Scanner(System.in);
        System.out.print("(1)Read a file\n(2)Create Folder &| File\n(3)Delete File | Folder\n(0)Exit\nWhat do you want to do?");
        menuChoice = scanner.next( );
        if (menuChoice.matches("1")) {
            System.out.println("Console File Reader - CFR");
            Read reader = new Read();
            try{
                reader.startReading();
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
        }
        else if (menuChoice.matches("2")) {
            System.out.println("Create & Write - C&R");
            Create crfile = new Create( );
            try {
                crfile.CreateFile( );
            } catch (IOException ex) {
                ex.printStackTrace( );
            }
        } else if (menuChoice.matches("3"))
            System.out.println("Add Text To File - AT2T");
        else if (menuChoice.matches("4")) {
            System.out.println("Delete File or Folder - DF|F");
            Delete del = new Delete();
            System.out.println("Do you want to delete \n(1) a file \n(2) a folder? ");
            String choice = new Scanner(System.in).next();
            if(choice.matches("1")){
                try{
                    del.deleteFile();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }else if(choice.matches("2")){
                try{
                    del.deleteFolder();
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }
        else if(menuChoice.matches("0"))
            System.exit(0);
        else {
            System.out.println("Option not available, try again with a valid option!");
            MainClass m = new MainClass();
            m.main(args);
        }
    }
}