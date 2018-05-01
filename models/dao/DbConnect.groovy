import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement

public class DbConnect {

    static final def dbUrl = "jdbc:sqlite:score.db"
    static final def driver = "org.sqlite.JDBC"
    static Connection connection = null

    public static def createDb(){
        String createDatabase = "CREATE DATABASE IF NOT EXISTS score"

        String createScoresTable = "CREATE TABLE IF NOT EXISTS scores (" +
                " id INTEGER PRIMARY KEY," +
                " points REAL," +
                " date NUMERIC)"

        try{
            Connection connection = DBConnect.openConnection()
            Statement statement = connection.createStatement()
            statement.executeUpdate(createDatabase)
            statement.executeUpdate(createScoresTable)
            statement.close()
            DBConnect.closeConnection()
        }catch (Exception ex){
            print("an error occurred while creating database " + ex)
            return false
        }
        return true
    }

    public static def openConnection(){
        try {
            Class.forName(driver)
            connection = DriverManager.getConnection(dbUrl)
        }catch (Exception ex){
            print("An error occurred while opening connection" + ex)
            return connection
        }
        return connection
    }

    public static closeConnection(){
        try{
            if(!connection.isClosed()){
                connection.close()
            }
        }catch (Exception ex){
            print("An error occurred while closing connection " + ex)
        }
    }
}