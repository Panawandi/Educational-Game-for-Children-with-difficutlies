package Support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//  cd  C:\Program Files\MySQL\MySQL Server 8.0\bin - Connect to database via CMD  Pass: Pandawandi110200
//  INSERT INTO `login`.`usernames`(
//`id`,`username`, `password`)
//
//VALUE(
//1,
//'Isaac',
//'Pandawandi')
/* To insert new id to table
ALTER TABLE `login`.`usernames`
        ADD COLUMN `level` INT NULL AFTER `password`;

        To apply/update some values

        UPDATE `login`.`usernames` SET `level` = '1' WHERE (`id` = '0');
UPDATE `login`.`usernames` SET `level` = '1' WHERE (`id` = '1');
UPDATE `login`.`usernames` SET `level` = '2' WHERE (`id` = '2');


*/

public class Connect {

   /* public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "Pandawandi110200");
        } catch (Exception ex){
        System.out.println(ex.getMessage());
        }

        return con;


        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "Pandawandi110200");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from usernames");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("id"));
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("password"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }*/
}