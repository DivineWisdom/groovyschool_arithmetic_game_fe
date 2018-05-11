package views

import javafx.scene.Scene
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.layout.VBox
import javafx.stage.Stage

public class ScoresView extends Stage{

    def rootVbox = new VBox(10)
    def mainScene = new Scene(rootVbox,400,500)
    def menuBar = new MenuBar()
    public def scoreMenu = new Menu("Game")


    def initGameView(){
        this.menuBar.getMenus().addAll(scoreMenu)
        this.rootVbox.getChildren().addAll(menuBar)
        this.setTitle("Groovy School Arithmetic Game")
        this.setScene(mainScene)
    }
}