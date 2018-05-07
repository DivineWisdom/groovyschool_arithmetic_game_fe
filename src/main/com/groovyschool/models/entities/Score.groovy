package models.entities

import java.text.SimpleDateFormat

public class Score {
    
    private def id
    private def points
    private def date
    def dateFormater = new SimpleDateFormat("dd/MM/yyyy")

    Score(id, points, date) {
        this.id = id
        this.points = points
        this.date = dateFormater.parse(dateFormater.format(date))
    }

    Score(points, date) {
        this.points = points
        this.date = dateFormater.parse(dateFormater.format(date))
    }

    public Score (){ }

    public def getId(){
        this.id
    }

    public setId(id){
        this.id = id
    }

    public def getPoints(){
        this.points
    }

    public setPoints(points){
        this.points = points
    }

    public String toString(){
        this.points.toString()
    }

    public def getDate() {
        dateFormater.parse(dateFormater.format(this.date))
    }

    public void setDate(date) {
        this.date = dateFormater.parse(dateFormater.format(date))
    }
}
