
package Database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author abaru
 */
public class Database {

    
    
     public  Connection connection = null;
    public Database() {
        try {
         connection = DriverManager.getConnection("jdbc:postgresql://182.74.146.14:5432/postgres","tpf", "@d0r@b!e_#2022");
//         connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Management","postgres", "arun");
            System.out.println("Sucessfully connected");
        } catch(Exception e) {
            System.out.println(e);
            // @d0r@b!e_#2022
        }
    }
    
}
