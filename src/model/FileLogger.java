package model;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger {
    private PrintWriter logStream;

    public FileLogger(){
        try{
            logStream = new PrintWriter(new FileWriter("log.txt"), true);
        }catch (IOException ioe){
            System.out.println("Can not log");
            ioe.printStackTrace();
        }
    }
    public void printMsgForDev(Exception e) {
        e.printStackTrace(logStream);
    }

    public void printMsgForUser(String  e){
        System.out.println(e);
    }
}
