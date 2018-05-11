package controllers

import java.util.Random
import groovyx.javafx.GroovyFX
import java.sql.*
import java.text.SimpleDateFormat
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import models.dao.*
import models.entities.*
import views.*
import controllers.*


public class ScoresController {

    def scoresView, scoreDAO, mainController, db, allScores

    public ScoresController(scoresView, db){
        this.scoresView = scoresView
        this.db = db
        scoreDAO = new ScoreDAO()
        mainController = new MainController()
        initView(scoresView)
        registerEventListeners()
    }

    def initView(scoresView){
        allScores = scoreDAO.readAll(this.db)
        convertDate()
        scoresView.init(allScores)
        scoresView.show()
    }

    def registerEventListeners(){
        scoresView.playGameMenuItem.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                gotoGameView(event)
            }
        })
    }

    def gotoGameView(event){
        def gameView = new GameView()
        def gameController = new GameController(gameView, this.db)
        this.scoresView.close()
    }

    def convertDate(){
        for(Score score :allScores){
            score.setDateString(score.getDate().toString().substring(3, 10)
            +", " + score.getDate().toString().substring(24))

        }
    }

}