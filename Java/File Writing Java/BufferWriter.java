import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.invoke.TypeDescriptor;


public class BufferWriter {
    //global variables to help out
    private static final String DATA_FILE = "mymedia.txt";
    private static Scanner in;
    private static BufferedWriter out;

    //writeString
    public static void writeString(String s){
        //check to see if out is already created or not 
        if(out==null){
            try{
                out = new BufferedWriter(new FileWriter(DATA_FILE));

            }
            catch(Exception e){
                System.err.println("Cannot open file for output!");
                e.printStackTrace();

            }
        }
        try{
            out.write(s);
            out.newLine();
        }
        catch(Exception e){
            System.err.println("Cannot write file!");
            e.printStackTrace();
        }     
    }
    //saveAndClose
    public static void saveAndClose(){
        //closes after the Scanner is done reading the file
        if(in!=null){
            try {
                
            } catch (Exception e) {
                //TODO: handle exception
                System.err.println("Cannot close input file!");
                e.printStackTrace();
            }   
        }
        //closes after the BUdderedWriter is done writing to the file 
        if(out!=null){
            try{ 
                out.close();
                out=null;
            } catch(Exception e){
                System.err.println("Cannpt close output file!");
                e.printStackTrace();
            }

        }
    }

    //readString
    public static String readString(){
        //check to see if you are already reading 
        if (in ==null){
            try{
                in = new Scanner(new File(DATA_FILE));
            }
            catch (Exception e){
                System.err.println("Cannot open file for input!");
                e.printStackTrace();
            }
        }
        //read in the values from the text file 
            try{
            //check to see if in hasNext lne
            if(in.hasNextLine()){

                String s = in.nextLine();
                return s; //grabbing everthing
            }

        }
        catch (Exception e){
            System.err.println("Cannot read the file");
            e.printStackTrace();
        }


        return null;
    }




    
}
