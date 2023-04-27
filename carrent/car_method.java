
package carrent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;


public class car_method {
       File f = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\carRent\\src\\carrent");
    int ln;
    
    
    
    public void createFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
    }
    public void addData(String type,String model,String duration){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\cars.txt", "rw");
            for(int i=0;i<ln;i++){
                raf.readLine();
            }
           
            raf.writeBytes(type+ "\r\n");
            raf.writeBytes(model+ "\r\n");
            raf.writeBytes(duration+ "\r\n");
                            JOptionPane.showMessageDialog(null, "Data Added");

        } catch (Exception ex) {
        ex.printStackTrace();
        }
        
    }
    
   public void countLines(){
        try {
            ln=0;
            RandomAccessFile raf = new RandomAccessFile(f+"\\cars.txt", "rw");
            for(int i=0;raf.readLine()!=null;i++){
                ln++;
            }
            System.out.println("number of lines:"+ln);
       } catch (Exception ex) {
        ex.printStackTrace();
        }
     }
     
  
   public void readFile(){
        try {
            FileReader fr = new FileReader(f+"\\cars.txt");
            System.out.println("file exists!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f+"\\cars.txt");
                System.out.println("File created");
              } catch (Exception e) {
        e.printStackTrace();
        }
              } catch (Exception ex) {
        ex.printStackTrace();
        }
        
        
    }
  
    
}
