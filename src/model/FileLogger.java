package model;

import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.PortUnreachableException;

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
        //logStream.println("This message is for the developer");
        e.printStackTrace(logStream);
    }

    public void printMsgForUser(String  e){
        System.out.println(e);
    }
}
