package com.textEditor.app.classes;

import com.textEditor.app.main.MainClass;

import java.io.*;
import java.util.Scanner;

public class Write  {
    public void startWriting(String path, String filename) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String content = " ";
        FileWriter fw = new FileWriter(path + "/" + filename + ".txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        while(!content.endsWith("*/")){
            content = scanner.nextLine();
            if(content.endsWith("*/")){
                content = content.substring(0, content.length() -2);
                pw.flush();
                pw.print(content);
                pw.close();
                break;
            }
            pw.println(content);
        }
        System.out.println("FILE SAVED AND EXITED");
        MainClass m = new MainClass();
        String[] args = {" "};
        m.main(args);
    }

}
