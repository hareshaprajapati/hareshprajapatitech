
import java.sql.*;

public class StatementInsertExample {
    public static void main(String... arg) {
           Connection con = null;
           Statement stmt = null;
           ResultSet rs = null;
           try {
                  // registering Oracle driver class
                  Class.forName("oracle.jdbc.driver.OracleDriver");
                   // getting connection
                  con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ankit", "Oracle123");
                  System.out.println("Connection established successfully!");
                  
                  stmt = con.createStatement();
                  //execute insert query
                  int numberOfRowsInserted=stmt.executeUpdate("INSERT into EMPLOYEE(ID,NAME)" + "values (1, 'ankit') ");
                  System.out.println("numberOfRowsInserted=" + numberOfRowsInserted);

				rs = stmt.executeQuery("select name, salary from emp");
				while(rs.next()){
					System.out.println(rs.getString("name"));
					System.out.println(rs.getInt("salary"));
				}
				  stmt.close();
				  rs.close();
				  con.close();
           } catch (ClassNotFoundException e) {
                  e.printStackTrace();
           } catch (SQLException e) {
                  e.printStackTrace();
           }
           finally{
                  try {
                        if(stmt!=null) stmt.close(); //close Statement
                        if(rs!=null) rs.close(); // close connection
						if(con!=null) con.close(); // close connection
                  } catch (SQLException e) {
                        e.printStackTrace();
                  }
           }
    }
}