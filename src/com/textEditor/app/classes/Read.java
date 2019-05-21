package com.textEditor.app.classes;

import com.textEditor.app.main.MainClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Read {
    public void startReading() throws FileNotFoundException {
        System.out.println("Enter the full path to the file you want to read:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.println("Enter the name of the file:");
        String fileName = scanner.nextLine();
        BufferedReader br = new BufferedReader(new FileReader(path + "/" + fileName + ".txt"));
        try{
            String line = br.readLine();
            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }finally{
            System.out.print("\n\n(1)Go back to main menu or..\n(2)Exit?\nDo you want to...");
            String answer = scanner.nextLine();
            if(answer.matches("1")){
                MainClass m = new MainClass();
                String[] args = {" "};
                m.main(args);
            }else if(answer.matches("2"))
                System.exit(0);
        }
    }
}
