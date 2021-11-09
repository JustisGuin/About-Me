//Fuse the FIleoutputStream
import java.io.*;

import javax.swing.plaf.metal.MetalIconFactory.FileIcon16;

public class FileWriting {
    public static void main(String[] args) throws IOException {
        //try to do this 
        try(FileOutputStream output = FileOutputStream("temp.txt");){
            //if it works do this 
            for(int i=0;i<=100;i++){
                int rando = (int)(Math.random()*10);
                output.write(rando);     //only allow ints and bytes 
                byte comma = 44;
                output.write();
            }

        }
        //if it fails... throw IOException 

        try(FileInputStream input =  new FileInputStream("temp.txt");){
            //We know that temp.txt has int and bytes 

            //loop through to render the ints and bytes 
            int value;
            while((value=input.read())!=-1){
                if(value!=44){
                    System.out.println(value);
                }

            }
        }
    
        
    }
    
}
