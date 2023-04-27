
package carrent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class user_method {
       File f = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\carRent\\src\\carrent");
    int ln;
    String Username,Password;
    
    
    
    public void createFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
    }
    public void addData(String usr,String pswd){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
            for(int i=0;i<ln;i++){
                raf.readLine();
            }
           
            raf.writeBytes(usr+ "\r\n");
            raf.writeBytes(pswd+ "\r\n");
                                        JOptionPane.showMessageDialog(null, "Data Added");

        } catch (Exception ex) {
        ex.printStackTrace();
        }
        
    }
    
   public void countLines(){
        try {
            ln=0;
            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
            for(int i=0;raf.readLine()!=null;i++){
                ln++;
            }
            System.out.println("number of lines:"+ln);
       } catch (Exception ex) {
        ex.printStackTrace();
        }
     }
     
   public void CheckData(String usr,String pswd){
    
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
            String line = raf.readLine();
            Username=line.substring(9);
            Password=raf.readLine().substring(9);
            if(usr.equals(Username)& pswd.equals(Password)){
                JOptionPane.showMessageDialog(null, "Password matched");
            }else{
                JOptionPane.showMessageDialog(null, "Wrong user/Password");
            }
          } catch (Exception ex) {
        ex.printStackTrace();
        }
            
    }
   public void readFile(){
        try {
            FileReader fr = new FileReader(f+"\\logins.txt");
            System.out.println("file exists!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f+"\\logins.txt");
                System.out.println("File created");
              } catch (Exception e) {
        e.printStackTrace();
        }
              } catch (Exception ex) {
        ex.printStackTrace();
        }
        
        
    }
   public  boolean logic(String usr,String pswd){
        try {
            countLines();
            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
            for(int i=0;i<ln;i++){
                System.out.println("count "+i);
            
                String forUser = raf.readLine();
                String forPswd = raf.readLine();
                if(usr.equals(forUser) & pswd.equals(forPswd)){
                    JOptionPane.showMessageDialog(null, "password matched");

                                                return true;

                }else if(i==(ln-3)){
                    JOptionPane.showMessageDialog(null, "incorrect username/password");
                                                                    return false;

                }
            
                for(int k=1;k==2;k++){
                    raf.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
ex.printStackTrace();
        } catch (IOException e) {
e.printStackTrace();
        }
        return false;
        
    }
    
        
    
}
