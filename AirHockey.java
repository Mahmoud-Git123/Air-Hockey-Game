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
    
    Text welcomeTextObj = new Text ("Welcome to Air Hockey!", 20, 50, 50, "WHITE", 1);

    double xPuckSpeed = 0;
    double yPuckSpeed = 0;



    //ADDING

    gameObj.addRectangle(goalObj1); //adding goal rectangle 1
    gameObj.addRectangle(goalObj2); //adding goal rectangle 2
    
    blueRecObj.setXPosition((gameObj.getWidth() - blueRecObj.getWidth())/2); //centering the blue rectangle
    blueRecObj.setYPosition((gameObj.getHeight() - blueRecObj.getHeight())/2); //centering the blue rectangle
    
    whiteRecObj.setXPosition((gameObj.getWidth() - whiteRecObj.getWidth())/2); //centering the white rectangle
    whiteRecObj.setYPosition((gameObj.getHeight() - whiteRecObj.getHeight())/2); //centering the white rectangle
    


    gameObj.addRectangle(blueRecObj); //adding blue rectangle
    gameObj.addRectangle(whiteRecObj); //adding white rectangle
    
    gameObj.addText(welcomeTextObj); //adding text
    
    gameObj.addBall(ballObj1); //adding ball 1
    gameObj.addBall(ballObj2); //adding ball 2
    
    gameObj.addBall(centerObj1); //adding center circle (white) 1
    gameObj.addBall(centerObj2); //adding center circle (blue) 2
    
    gameObj.addBall(puckObj); //adding puck
    
    gameObj.addLine(lineObj); //adding line
    
    /*MOVEMENT*/

    //PLAYER 1
    while (true){
      
      if (ballObj2.getXPosition() < (837.5 - 25)){ //setting the x boundries (900 [game width] - 62.5 [gap between game rectangle and white rectangle]) of the ball so it doesn't go outside the game rectangle, ball radius is 25.
        if (gameObj.rightPressed()){ //if the right arrow button is pressed
          ballObj2.move(6, 0); //ball moves 6 in positive x direction (i.e. to the right)
        }
      }

      if (ballObj2.getXPosition() > (450 + 25)){ //setting the x boundires ((900[game width/2 = 450)) of the ball so it doesn't pass middle line, ball radius is 25.
        if (gameObj.leftPressed()){ //if the left arrow button is pressed
          ballObj2.move(-6, 0); //ball moves 6 in negative x direction (i.e. to the left)
        }
      }
      
      if (ballObj2.getYPosition() > (87.5 + 25)){ //setting the y boundries ((500[game height]-325[white rectangle height])/2 = 87.5) of the ball so it doesn't go outside the game rectangle, ball radius is 25.
        if (gameObj.upPressed()){ //if the up arrpuckObjow button is pressed
          ballObj2.move(0, -6); //ball moves 6 in negative y direction (i.e upwards)
        }
      }

      if (ballObj2.getYPosition() < (412.5 - 25)){ //setting the y boundries (500[game height] - 87.5[gap between game rectangle and white rectangle] = 412.5)  of the ball so it doesn't go outside the game rectangle, ball radius is 25.
        if (gameObj.downPressed()){ //if the down arrow button is pressed
          ballObj2.move(0, 6); //ball moves 6 in positive y direction (i.e. downwards)
        }
      }

      

      //PLAYER 2

      if (ballObj1.getXPosition() > (62.5 + 25)){ //setting the x boundries (gap between game rectangle and white rectangle is +62.5 in x direction from the right) of the ball so it doesn't go outside the game rectangle, ball radius is 25.
        if (gameObj.letterPressed('a')){ //if the 'a' key is pressed
          ballObj1.move(-6, 0); //ball moves 6 in positive x direction (i.e. to the right)
        }
      }

      if (ballObj1.getXPosition() < (450 - 25)){ //setting the x boundires (900[game width/2) of the ball so it doesn't pass middle line, ball radius is 25.
        if (gameObj.letterPressed('d')){ //if the 'd' key is pressed
          ballObj1.move(6, 0); //ball moves 6 in negative x direction (i.e. to the left)
        }
      }
    
      if (ballObj1.getYPosition() > (87.5 + 25)){ //setting the y boundries ((500[game height]-325[white rectangle height])/2 = 87.5) of the ball so it doesn't go outside the game rectangle, ball radius is 25.
        if (gameObj.letterPressed('w')){ //if the 'w' key is pressed
          ballObj1.move(0, -6); //ball moves 6 in negative y direction (i.e upwards)
        }
      }

      if (ballObj1.getYPosition() < (412.5 - 25)){ //setting the y boundries (500[game height] - 87.5[gap between game rectangle and white rectangle])  of the ball so it doesn't go outside the game rectangle, ball radius is 25.
        if (gameObj.letterPressed('s')){ //if the 's' key is pressed
          ballObj1.move(0, 6); //ball moves 6 in positive y direction (i.e. downwards)
        }
      }

      
      /*COLLISIONS */

      //PLAYER 1
      if (puckObj.collides(ballObj2)){ //if player 2's ball/mallett hits the puck

        //Creating an object of the physics class for player 1, where xpseed 1 and yspeed 1 are the puck's speeds and ball/mallet speeds is 15
        Physics physicsObjPlayer1 = new Physics(ballObj2.getXPosition(), puckObj.getXPosition(),ballObj2.getYPosition() , puckObj.getYPosition(), 15, xPuckSpeed, 15, yPuckSpeed);

        physicsObjPlayer1.deflect(); //deflection method in phyiscs class

        xPuckSpeed = physicsObjPlayer1.xSpeed2; //setting the x speed of the puck to match the speed in physics class after deflection
        yPuckSpeed = physicsObjPlayer1.ySpeed2; //setting the y speed of the puck to match the speed in physics class after deflection
      }
      

      //PLAYER 2
      if(puckObj.collides(ballObj1)){ //if player 1's ball/mallet hits the puck

        //Creating an object of the physics class for player 2, where xpseed1 and yspeed1 are the puck's speeds and ball/mallet speeds is 15
        Physics physicsObjPlayer2 = new Physics(ballObj1.getXPosition(), puckObj.getXPosition(),ballObj1.getYPosition() , puckObj.getYPosition(), 15, xPuckSpeed, 15, yPuckSpeed);

        physicsObjPlayer2.deflect(); //deflection method in phyiscs class

        xPuckSpeed = physicsObjPlayer2.xSpeed2; //setting the x speed of the puck to match the speed in physics class after deflection
        yPuckSpeed = physicsObjPlayer2.ySpeed2; //setting the y speed of the puck to match the speed in physics class after deflection
      }

      puckObj.move(xPuckSpeed, yPuckSpeed); //puck moves depending on the speed given from  the above if statements

      gameObj.pause();
      
    }


    
      
    
    
  }
}
    
          
                                
      
