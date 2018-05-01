public class Score {
    
    private def id
    private def points

    public Score (){ }

    public Score (def id, def points){
        this.id = id
        this.points = points
    }

    public def getId(){
        this.id
    }

    public setId(def id){
        this.id = id
    }

    public def getPoints(){
        this.id
    }

    public setPoints(def points){
        this.points = points
    }

    public String toString(){
        this.points.toString()
    }
}
