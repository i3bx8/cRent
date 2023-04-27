
package carrent;


public class Users {
    String user;
    String pass;

    public Users(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public Users() {
         this.user = "";
        this.pass = "";
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
