@Grab('org.codehaus.groovyfx:groovyfx:0.1')

import groovyx.javafx.GroovyFX
import groovyx.javafx.SceneGraphBuilder
import java.util.Random

GroovyFX.start {
def sg = new SceneGraphBuilder()
def score = 0
def operation = 'Addition'
def sign = '+'
def firstNumber = getRandomInterger()
def secondNumber = getRandomInterger()
def feedback = ''

  sg.stage(title: "Groovy School Arithmetic Game", visible: true) {
    scene(width: 400, height: 500) {
        vbox(spacing: 10){
            menuBar(){
                menu('Operation'){
                    menuItem('Addition')
                    menuItem('subtraction')
                    menuItem('Multiplication')
                    menuItem('Division')
                }

            }
            hbox(spacing: 10, padding:[5,25, 0, 0], alignment: "center_right"){
                label("Score: ", textFill: black, style: "-fx-font-size: 20pt;")
                label(score, textFill: black, style: "-fx-font-size: 15pt;")
            }
             vbox(spacing: 10, alignment:'center'){
                label(operation, textFill: black, style: "-fx-font-size: 20pt;")
                label(firstNumber, textFill: black, style: "-fx-font-size: 30pt;")
                label(sign, textFill: black, style: "-fx-font-size: 30pt;")
                label(secondNumber,textFill: black, style: "-fx-font-size: 30pt;")
                hbox(spacing: 10, alignment:'center'){
                    label('= ', textFill: black, style: "-fx-font-size: 20pt;")
                    textField(promptText: 'Answer')
                }
                button('Submit', style: "-fx-font-size: 15pt"){

                }
                label(text: feedback)
            }
        }
      }
    } 

  }

    def add (firstNumber, secondNumber){
        firstNumber + secondNumber
    }

    def subtract (firstNumber, secondNumber){
        firstNumber - secondNumber
    }

    def multiply (firstNumber, secondNumber){
        firstNumber * secondNumber
    }

    def divide (firstNumber, secondNumber){
        firstNumber / secondNumber
    }

    def getRandomInterger(){
       Math.abs(new Random().nextInt()%10) + 1
    }