import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement
import java.util.ArrayList

public class ScoreDao {

    public def create(score){
        String query = "INSERT INTO scores(points, date) VALUES (" +
                score.getPoints + "," +
                score.getDate + ")"

        try{
            Connection connection = DBConnect.openConnection()
            Statement statement = connection.createStatement()
            statement.executeUpdate(query)
            statement.close()
            DBConnect.closeConnection()
        }catch (Exception ex){
            print("an error occurred while inserting the score " + ex)
            return false
        }
        return true
    }

    public def readAll(){
        String query = "SELECT * FROM scores"
        List scores = new ArrayList<>()
        try{
            Connection connection = DBConnect.openConnection()
            Statement statement = connection.createStatement()
            ResultSet resultSet = statement.executeQuery(query)
            while(resultSet.next()){
               def score = new Score()
                score.setId(resultSet.getInt("id"))
                score.setPoints(resultSet.getDouble("points"))
                score.setDate(resultSet.getDate("id"))
                scores.add(score)
            }
            resultSet.close()
            statement.close()
            DBConnect.closeConnection()
        }catch (Exception ex){
            System.out.println("an error occurred while reading all " + ex)
            return null
        }
        return scores
    }

    public def readById(id){
        String query = "SELECT * FROM scores WHERE id = " + id
        def score = new Score()

        try{
            Connection connection = DBConnect.openConnection()
            Statement statement = connection.createStatement()
            ResultSet resultSet = statement.executeQuery(query)
            while(resultSet.next()){
                score.setId(resultSet.getInt("id"))
                score.setPoints(resultSet.getDouble("points"))
                score.setDate(resultSet.getDate("id"))
            }
            resultSet.close()
            statement.close()
            DBConnect.closeConnection()
        }catch (Exception ex){
            System.out.println("an error occurred while reading by id " + ex)
            return null
        }
        return scores
    }

    public def update(score){
        String query = "UPDATE scores SET" +
                " points = " + score.getPoints + " ," +
                " date = " + score.getDate +
                " WHERE id = " + score.getId

        try{
            Connection connection = DBConnect.openConnection()
            Statement statement = connection.createStatement()
            statement.executeUpdate(query)
            statement.close()
            DBConnect.closeConnection()
        }catch (Exception ex){
            print("an error occurred while updating the score " + ex)
            return false
        }
        return true
    }

    public def delete(id){
        String query = "DELETE FROM scores WHERE id =" + id

        try{
            Connection connection = DBConnect.openConnection()
            Statement statement = connection.createStatement()
            statement.executeUpdate(query)
            statement.close()
            DBConnect.closeConnection()
        }catch (Exception ex){
            print("an error occurred while deleting the score " + ex)
            return false
        }
        return true
    }
    
}