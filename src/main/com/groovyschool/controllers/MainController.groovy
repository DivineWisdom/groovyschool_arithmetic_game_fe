package controllers

import models.dao.*
import models.entities.*

import java.text.SimpleDateFormat

public class MainController {

    def dateFormater = new SimpleDateFormat("dd/MM/yyyy")

    public def getCurrentScore(db){
        ScoreDAO scoreDAO = new ScoreDAO()
        List<Score> allScores = scoreDAO.readAll(db)
        def todaysDate = dateFormater.parse(dateFormater.format(new java.util.Date()))
        def score = findScore(allScores, todaysDate)
        if(score){
            return score
        }else{
            scoreDAO.create(new Score(0, todaysDate), db)
            allScores = scoreDAO.readAll(db)
            score = findScore(allScores, todaysDate)
        }

        return score
    }

    def findScore(allScores, todaysDate){
        for(Score score: allScores){
            if(score.getDate() == todaysDate){
                return score
            }
        }
        return null
    }
}