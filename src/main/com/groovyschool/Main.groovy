@GrabConfig(systemClassLoader=true)
@Grab('org.codehaus.groovyfx:groovyfx:0.1')
@Grab('org.xerial:sqlite-jdbc:3.6.16')

import org.sqlite.*
import groovyx.javafx.GroovyFX
import controllers.GameController
import views.GameView
import models.dao.DbInit

GroovyFX.start {

    db = groovy.sql.Sql.newInstance("jdbc:sqlite:score.db","org.sqlite.JDBC")
    DbInit.initDb(db)
    def gameView = new GameView()
    def gameController = new GameController(gameView, db)

  }