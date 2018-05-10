package views

import groovyx.javafx.GroovyFX
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.paint.Paint
import javafx.stage.Stage

public class GameView extends Stage{

    def rootVbox = new VBox(10)
    def mainScene = new Scene(rootVbox,400,500)
    def menuBar = new MenuBar()
    def operationMenu = new Menu("Operation")
    public def scoreMenu = new Menu("All Scores")
    public def additionMenuItem = new MenuItem("Addition")
    public def subtractionMenuItem = new MenuItem("Subtraction")
    public def multiplicationMenuItem = new MenuItem("Multiplication")
    public def divisionMenuItem = new MenuItem("Division")
    def pointsHbox = new HBox(10)
    def pointsLabel = new Label("Score: ")
    public def pointsValueLabel = new Label("00")
    def gameVbox = new VBox(10)
    public def operationLabel = new Label("Addition")
    public def signLabel = new Label("+")
    public def firstNumberLabel = new Label("0")
    public def secondNumberLabel = new Label("0")
    def answerHbox = new HBox(10)
    def answerLabel = new Label('= ')
    public def answerTextField = new TextField()
    public def submitButton = new Button("Submit")
    public def feedbackLabel = new Label("")


     def initGameView(){
         this.operationMenu.getItems().addAll(additionMenuItem, subtractionMenuItem, multiplicationMenuItem, divisionMenuItem)
         this.menuBar.getMenus().addAll(operationMenu, scoreMenu)
         this.pointsHbox.setPadding(new Insets(5, 25, 0, 0))
         this.pointsHbox.setAlignment(Pos.CENTER_RIGHT)
         this.pointsLabel.setTextFill(Paint.valueOf("black"))
         this.pointsLabel.setStyle("-fx-font-size: 20pt;")
         this.operationLabel.setTextFill(Paint.valueOf("black"))
         this.operationLabel.setStyle("-fx-font-size: 30pt;")
         this.firstNumberLabel.setTextFill(Paint.valueOf("black"))
         this.firstNumberLabel.setStyle("-fx-font-size: 25pt;")
         this.signLabel.setTextFill(Paint.valueOf("black"))
         this.signLabel.setStyle("-fx-font-size: 30pt;")
         this.secondNumberLabel.setTextFill(Paint.valueOf("black"))
         this.secondNumberLabel.setStyle("-fx-font-size: 25pt;")
         this.answerLabel.setTextFill(Paint.valueOf("black"))
         this.answerLabel.setStyle("-fx-font-size: 25pt;")
         this.pointsValueLabel.setTextFill(Paint.valueOf("black"))
         this.pointsValueLabel.setStyle("-fx-font-size: 20pt;")
         this.submitButton.setStyle("-fx-font-size: 15pt;")
         this.answerTextField.setPromptText("Answer")
         this.gameVbox.setAlignment(Pos.CENTER)
         this.answerHbox.setAlignment(Pos.CENTER)
         answerHbox.getChildren().addAll(answerLabel,answerTextField)
         this.gameVbox.getChildren().addAll(operationLabel, firstNumberLabel, signLabel, secondNumberLabel, answerHbox, submitButton, feedbackLabel)
         this.pointsHbox.getChildren().addAll(pointsLabel, pointsValueLabel)
         this.rootVbox.getChildren().addAll(menuBar, pointsHbox, gameVbox)
        this.setTitle("Groovy School Arithmetic Game")
        this.setScene(mainScene)
    }
}

//menuBar(){
//    menu('Operation'){
//        menuItem("Addition", onAction:{
//            operationLable.setText("Addition")
//            operation = 'Addition'
//            sign = "+"
//            signLable.setText("+")
//            firstNumber = getRandomInterger()
//            firstNumberLable.setText(firstNumber+"")
//            secondNumber = getRandomInterger()
//            secondNumberLable.setText(secondNumber+"")
//        })
//        menuItem("Subtraction", onAction:{
//            operationLable.setText("Subtraction")
//            operation = 'Subtraction'
//            sign = "-"
//            signLable.setText("-")
//            firstNumber = getRandomInterger()
//            firstNumberLable.setText(firstNumber.toString())
//            secondNumber = getRandomInterger()
//            secondNumberLable.setText(secondNumber.toString())
//        })
//        menuItem("Multiplication", onAction:{
//            opesrationLable.setText("Multiplication")
//            operation = 'Multiplication'
//            sign = "X"
//            signLable.setText("X")
//            firstNumber = getRandomInterger()
//            firstNumberLable.setText(firstNumber.toString())
//            secondNumber = getRandomInterger()
//            secondNumberLable.setText(secondNumber.toString())
//        })
//        menuItem("Division", onAction:{
//            operationLable.setText("Division")
//            operation = 'Division'
//            sign = "/"
//            signLable.setText("/")
//            firstNumber = getRandomInterger()
//            firstNumberLable.setText(firstNumber.toString())
//            secondNumber = getRandomInterger()
//            secondNumberLable.setText(secondNumber.toString())
//        })
//    }
//}