package controllers

import java.util.Random
import groovyx.javafx.GroovyFX
import java.sql.*
import java.text.SimpleDateFormat
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import models.dao.*
import models.entities.*
import controllers.*


public class GameController {

    def gameView, scoreDAO, mainController, db, firstNumber, secondNumber, operation, answer, currentScore

    public GameController(gameView, db){
        this.gameView = gameView
        this.db = db
        scoreDAO = new ScoreDAO()
        mainController = new MainController()
        initView(gameView)
        registerEventListeners()
    }

    def initView(gameView){
        currentScore = mainController.getCurrentScore(this.db)
        gameView.pointsValueLabel.setText(currentScore.getPoints()+"")
        operation = "addition"
        refresh()
        gameView.initGameView()
        gameView.show()
    }

    def registerEventListeners(){
        gameView.submitButton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
               submitButtonClicked(event)
            }
        })

        gameView.additionMenuItem.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                gotoAddition(event)
            }
        })

        gameView.subtractionMenuItem.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                gotoSubtraction(event)
            }
        })

        gameView.multiplicationMenuItem.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                gotoMultiplication(event)
            }
        })

        gameView.divisionMenuItem.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                gotoDivision(event)
            }
        })
    }

    def getRandomInterger(){
        Math.abs(new Random().nextInt()%10) + 1
    }

    def refresh(){
        firstNumber = getRandomInterger()
        secondNumber = getRandomInterger()
        gameView.firstNumberLabel.setText(firstNumber+"")
        gameView.secondNumberLabel.setText(secondNumber+"")
        gameView.answerTextField.setText("")
    }

    def submitButtonClicked(e){
        if(gameView.answerTextField.getText() == null || gameView.answerTextField.getText() == ""){
            gameView.feedbackLabel.setText("Invalid input")
        }else{
            answer = Double.parseDouble(gameView.answerTextField.getText())
           if(operation == "addition"){
               doAddition()
           }else if(operation == "subtraction"){
               doSubtraction()
           } else if(operation == "multiplication"){
               doMultiplication()
           }else if(operation == "division"){
               doDivision()
           }else {
               gameView.feedbackLabel.setText("Go back to Mars")
           }
            gameView.pointsValueLabel.setText(currentScore.getPoints()+"")
            scoreDAO.update(currentScore, db)
        }
    }

    def doAddition(){
        if(answer == (firstNumber + secondNumber)){
            gameView.feedbackLabel.setText("Very Good")
            currentScore.setPoints(currentScore.getPoints() + 10)
            refresh()
        }else {
            currentScore.setPoints(currentScore.getPoints() - 5)
            gameView.feedbackLabel.setText("Try Again")
        }
    }

    def doSubtraction(){
        if(answer == (firstNumber - secondNumber)){
            gameView.feedbackLabel.setText("Very Good")
            currentScore.setPoints(currentScore.getPoints() + 10)
            refresh()
        }else {
            currentScore.setPoints(currentScore.getPoints() - 5)
            gameView.feedbackLabel.setText("Try Again")
        }
    }

    def doMultiplication(){
        if(answer == (firstNumber * secondNumber)){
            gameView.feedbackLabel.setText("Very Good")
            currentScore.setPoints(currentScore.getPoints() + 10)
            refresh()
        }else {
            currentScore.setPoints(currentScore.getPoints() - 5)
            gameView.feedbackLabel.setText("Try Again")
        }
    }

    def doDivision(){
        def correctAnswer = firstNumber / secondNumber
        if(answer == (Math.round(correctAnswer * 10) / 10)){
            gameView.feedbackLabel.setText("Very Good")
            currentScore.setPoints(currentScore.getPoints() + 10)
            refresh()
        }else {
            currentScore.setPoints(currentScore.getPoints() - 5)
            gameView.feedbackLabel.setText("Try Again")
        }
    }

    def gotoAddition(e){
        operation = "addition"
        gameView.operationLabel.setText("Addition")
        gameView.signLabel.setText('+')
        refresh()
    }

    def gotoSubtraction(e){
        operation = "subtraction"
        gameView.operationLabel.setText("Subtraction")
        gameView.signLabel.setText('-')
        refresh()
    }

    def gotoMultiplication(e){
        operation = "multiplication"
        gameView.operationLabel.setText("Multiplication")
        gameView.signLabel.setText('X')
        refresh()
    }

    def gotoDivision(e){
        operation = "division"
        gameView.operationLabel.setText("Division")
        gameView.signLabel.setText("\u00F7")
        refresh()
    }

}