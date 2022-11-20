package samia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

class info  extends IdandPass{

    private int Id;
    private String Fname;
    private String Lname;
    private int Age;

    public info() {
    }

    public info(int id, String fname, String lname, int age) {
        this.Id = id;
        this.Fname = fname;
        this.Lname = lname;
        this.Age = age;
    }

    public int getId() {
        return this.Id;
    }

    public String getFname() {
        return this.Fname;
    }

    public String getLname() {
        return this.Lname;
    }

    public int getAge() {
        return this.Age;
    }
    public String ToString() {
        return this.Id + " " + this.Fname + " " + this.Lname + " " + this.Age;
    }
}

public class Users  {

    Users() {

    }

    public static Connection getConnection() {

        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/power", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(info.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<String, String>();

        Statement st = null;
        ResultSet rs = null;
        Connection con = getConnection();
        Users u;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM launchbooking where customer = ? and mobile = ?");
            while (rs.next()) {
                String name = rs.getString("customer");
                String pn = rs.getString("mobile");
                map.put(name, pn);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
