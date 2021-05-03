package New;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author amedi
 */
public class Ex2 {
    public static void main (String[] args){
    
    /*This first part creates a file to a default location within src*/
    
    String home = "C:\\Users\\amedi\\Documents\\NetBeansProjects\\JavaEx\\src\\";
    try{
    File myFile = new File(home+"new\\userInput.txt");
    if(myFile.createNewFile()){
    System.out.println("Successfully created " + myFile.getPath());
    } else {
        System.out.println("File already exists.");
      }
    } catch(IOException e){
    System.out.println("Error! Something went wrong");
    }
    System.out.println();
    /*This part creates a new directory where we will then change a previous 
    created file.*/
    File dir = new File(home+"dir");
   boolean value = dir.mkdir();
    if(value) {
      System.out.println("New Dir." + dir.getPath());
    }
    else {
      System.out.println("Couldn't complete task.");
    }
    /*This is where we change the file from one location to another
    using a try and catch */
    
    System.out.println();
    String Origin = home+"new\\userInput.txt";
    String Dest = home+"dir\\userIntput.txt";
     try{
    Path From = Paths.get(Origin);
    Path To = Paths.get(Dest);
    Files.move(From, To);
    System.out.println("Successfully moved file");
    }
    catch(IOException e){
            System.out.println("Couldn't move file");
            }
     
     /*This part is for renaming the file*/
     System.out.println();
     Path File = Paths.get(home+"dir\\userIntput.txt");
    try{
    Files.move(File,File.resolveSibling("userIntput.txt.bck"));
    System.out.println("Successfully renamed file :" + File.getFileName());
    }
    catch(IOException e){
            System.out.println("Couldn't rename file");
            }
    System.out.println();
    /*Delete the created file*/
    File Del = new File (home+"dir\\userIntput.txt.bck");
    if (Del.delete()) { 
      System.out.println("File Deleted was : " + Del.getName());
    } else {
      System.out.println("Failed to complete task.");
    }
    }
}
