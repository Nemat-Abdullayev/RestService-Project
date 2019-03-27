package az.kapital.config;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {

    public  static Connection connect () throws NamingException, SQLException {

        Context context=new InitialContext();
        DataSource dataSource=(DataSource)context.lookup("java:comp/env/jdbc/phone");
        Connection c=dataSource.getConnection();
        if(c!=null){
            System.out.println("Connection Success!!");
        }
        return c;
    }
    public static void disconnect(Connection c, PreparedStatement ps, ResultSet rs) throws SQLException {
        if(c !=null){
            c.close();
        }
        if(ps !=null ){
            ps.close();
        }
        if(rs !=null){
            rs.close();
        }


    }


}
