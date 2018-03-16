
package stoktakibi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBCon {
    
    final private String url="org.sqlite.JDBC";
    final private String db="jdbc:sqlite:db/";
    private String dbName= "hammaddeler.db";
    
    
    private Connection conn=null;
    private Statement st=null;
    
    public Statement baglan(){
        try {
            Class.forName(url);
            conn= DriverManager.getConnection(db+dbName);
            st=conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Bağlantı Hatası: "+e);
        }
        return st;
    }
    
    public void kapat(){
        if (st!=null && conn!=null) {
            try {
                st.close();
                 conn.close();
                 st=null;
                 conn=null;
            } catch (SQLException ex) {
                System.err.println("Kapatma Hatası: "+ex);;
            }
           
        }
    }
    

    
}
