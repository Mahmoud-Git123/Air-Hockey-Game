public class AirHockey{
  public static void main (String args[]){
    //CREATING OBJECTS
    
    GameArena gameObj = new GameArena(900, 500, true);
    
    Ball ballObj1 = new Ball (175, 250, 50, "BLUE", 5);
    Ball ballObj2 = new Ball (725, 250, 50, "BLUE", 5);
    
    Ball centerObj1 = new Ball (450, 250, 70, "WHITE" , 3); //center circle
    Ball centerObj2 = new Ball (450, 250, 72, "BLUE", 2); //center circle (blue stroke)
    
    Ball puckObj = new Ball(450, 250, 15, "BLACK", 6);
    
    Rectangle blueRecObj = new Rectangle (0, 0, 800, 350, "BLUE");
    Rectangle whiteRecObj = new Rectangle (0, 0, 775, 325, "WHITE");
    
    Rectangle goalObj1 = new Rectangle (62.5, 175, 10,150, "GREY", 4);
    Rectangle goalObj2 = new Rectangle (827.5, 175, 10, 150, "GREY", 4);
                                
    Line lineObj = new Line (450, 87.5, 450, 412.5, 1, "BLUE", 1);
    
    Text mainText = new Text ("Welcome to Air Hockey!", 20, 50, 50, "WHITE", 1);

    Text player2ScoreText = new Text ("0", 25, 860, 250, "WHITE", 2);
    Text player1ScoreText = new Text ("0", 25, 8, 250, "WHITE", 2);

    Movement movement = new Movement(ballObj1, gameObj);
    Collisions collisions = new Collisions(0, 0, puckObj, ballObj1, ballObj2, gameObj);

    
    //ADDING

    gameObj.addRectangle(goalObj1); //adding goal rectangle 1
    gameObj.addRectangle(goalObj2); //adding goal rectangle 2
    
    blueRecObj.setXPosition((gameObj.getWidth() - blueRecObj.getWidth())/2); //centering the blue rectangle
    blueRecObj.setYPosition((gameObj.getHeight() - blueRecObj.getHeight())/2); //centering the blue rectangle
    
    whiteRecObj.setXPosition((gameObj.getWidth() - whiteRecObj.getWidth())/2); //centering the white rectangle
    whiteRecObj.setYPosition((gameObj.getHeight() - whiteRecObj.getHeight())/2); //centering the white rectangle
  
    gameObj.addRectangle(blueRecObj); //adding blue rectangle
    gameObj.addRectangle(whiteRecObj); //adding white rectangle
    
    gameObj.addText(mainText); //adding text
    
    gameObj.addBall(ballObj1); //adding ball 1
    gameObj.addBall(ballObj2); //adding ball 2
    
    gameObj.addBall(centerObj1); //adding center circle (white) 1
    gameObj.addBall(centerObj2); //adding center circle (blue) 2
    
    gameObj.addBall(puckObj); //adding puck
    
    gameObj.addLine(lineObj); //adding line
    
    gameObj.addText(player1ScoreText);
    gameObj.addText(player2ScoreText);




    while (true){

    /*MOVEMENT*/
      //PLAYER 1
      movement.player1Move(ballObj1, gameObj);
      //PLAYER 2
      movement.player2Move(ballObj2, gameObj);

    /*COLLISIONS*/
      collisions.collides(puckObj, ballObj1, ballObj2, gameObj);
 
    /*GOALS */
      //PLAYER 1 SCORES
      collisions.player1Scores(puckObj, ballObj1, mainText, player1ScoreText, gameObj);

      //PLAYER 2 SCORES
      collisions.player2Scores(puckObj, ballObj2, mainText, player2ScoreText, gameObj);
      

      gameObj.pause();
      
    }


    
      
    
    
  }
}
    
          
                                
      
