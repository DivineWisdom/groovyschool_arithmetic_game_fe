package views

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.Scene
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem
import javafx.scene.control.TableColumn
import javafx.scene.control.TableSelectionModel
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.layout.VBox
import javafx.stage.Stage
import java.text.SimpleDateFormat
import models.entities.*

public class ScoresView extends Stage{



    def rootVbox = new VBox(10)
    def mainScene = new Scene(rootVbox,400,500)
    def menuBar = new MenuBar()
    public def gameMenu = new Menu("Game")
    public def playGameMenuItem = new MenuItem("Play Game")
    def tableView  = new TableView()
    def dateColumn = new TableColumn("Date")
    def pointColumn = new TableColumn("Points")
    ObservableList<Score> scoresObservableList = FXCollections.observableArrayList()


    def init(scores){
        dateColumn.setEditable(false)
        pointColumn.setEditable(false)
        tableView.setEditable(false)
        pointColumn.setCellValueFactory(new PropertyValueFactory<Score, Integer>("points"))
        dateColumn.setCellValueFactory(new PropertyValueFactory<Score, String>("dateString"))
        scoresObservableList.addAll(scores)
        tableView.getItems().addAll(scoresObservableList)
        this.tableView.getColumns().addAll(dateColumn, pointColumn)
        this.gameMenu.getItems().addAll(playGameMenuItem)
        this.menuBar.getMenus().addAll(gameMenu)
        this.rootVbox.getChildren().addAll(menuBar, tableView)
        this.setTitle("Groovy School Arithmetic Game")
        this.setScene(mainScene)
    }

}
