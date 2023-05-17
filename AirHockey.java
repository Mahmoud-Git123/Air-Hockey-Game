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
    
    gameObj.addText(mainText); //adding text
    
    gameObj.addBall(ballObj1); //adding ball 1
    gameObj.addBall(ballObj2); //adding ball 2
    
    gameObj.addBall(centerObj1); //adding center circle (white) 1
    gameObj.addBall(centerObj2); //adding center circle (blue) 2
    
    gameObj.addBall(puckObj); //adding puck
    
    gameObj.addLine(lineObj); //adding line
    
    gameObj.addText(player1ScoreText);
    gameObj.addText(player2ScoreText);

    /*MOVEMENT*/


    while (true){
      
      //PLAYER 1
      movement.player1Move(ballObj1, gameObj);
      //PLAYER 2
      movement.player2Move(ballObj2, gameObj);

      /*COLLISIONS*/

      //PLAYER 2
      if (puckObj.collides(ballObj2)){ //if player 2's ball/mallett hits the puck

        //Creating an object of the physics class for player 1, where xpseed 1 and yspeed 1 are the puck's speeds and ball/mallet speeds is 15
        Physics physicsObjPlayer2 = new Physics(ballObj2.getXPosition(), puckObj.getXPosition(),ballObj2.getYPosition() , puckObj.getYPosition(), 15, xPuckSpeed, 15, yPuckSpeed);

        physicsObjPlayer2.deflect(); //deflection method in phyiscs class

        xPuckSpeed = physicsObjPlayer2.xSpeed2; //setting the x speed of the puck to match the speed in physics class after deflection
        yPuckSpeed = physicsObjPlayer2.ySpeed2; //setting the y speed of the puck to match the speed in physics class after deflection
      }
      

      //PLAYER 1
      if (puckObj.collides(ballObj1)){ //if player 1's ball/mallet hits the puck

        //Creating an object of the physics class for player 2, where xpseed1 and yspeed1 are the puck's speeds and ball/mallet speeds is 15
        Physics physicsObjPlayer1 = new Physics(ballObj1.getXPosition(), puckObj.getXPosition(),ballObj1.getYPosition() , puckObj.getYPosition(), 15, xPuckSpeed, 15, yPuckSpeed);

        physicsObjPlayer1.deflect(); //deflection method in phyiscs class

        xPuckSpeed = physicsObjPlayer1.xSpeed2; //setting the x speed of the puck to match the speed in physics class after deflection
        yPuckSpeed = physicsObjPlayer1.ySpeed2; //setting the y speed of the puck to match the speed in physics class after deflection
      }

      //Setting puck boundries
      if (puckObj.getXPosition() < 70 || puckObj.getXPosition() > 830){
        xPuckSpeed = xPuckSpeed*-1; //reverses speed causing puck to bounce and go in opposite direction
      }      

      if (puckObj.getYPosition() > 405 || puckObj.getYPosition() < 95){
        yPuckSpeed = yPuckSpeed*-1; //reverses speed causing puck to bounce and go in opposite direction
      }
      
      xPuckSpeed = xPuckSpeed*0.988; //adding friction
      yPuckSpeed = yPuckSpeed*0.988; //adding friction

      puckObj.move(xPuckSpeed, yPuckSpeed); //puck moves depending on the speed given from  the above if statements

      /*GOALS */

      //PLAYER 1
      if (puckObj.getYPosition() > 175 && puckObj.getYPosition() < 325 && puckObj.getXPosition() > 827.5 && puckObj.getXPosition() < 837.5){ //boundies of player 2's goal

        //PUCK/MALLETS REMOVING
        gameObj.removeBall(puckObj); //removes puck

        gameObj.removeBall(ballObj1); //removes player 1's ball/mallet
        gameObj.removeBall(ballObj2); //removes player 2's ball/mallet


        //TEXT
        mainText.setText("Player 1 wins the round!"); //changing text to show player 1 scoring
        mainText.setColour("GREEN");
        int x = Integer.valueOf(player1ScoreText.getText()) + 1;  //converting goal value to an integer and adding one to it
        player1ScoreText.setText(String.valueOf(x)); //setting the score text to the new value
        
        //PUCK/MALLETS ADDING
        xPuckSpeed = 0;
        yPuckSpeed =0;
        puckObj.setXPosition(485); //(900/2) + 35 (center circle radius) = 485
        puckObj.setYPosition(250); //500/2 = 250

        ballObj1.setXPosition(175); //resets the position of player 1's  ball/mallet
        ballObj1.setYPosition(250); //resets the postion of player 1's ball/mallet

        ballObj2.setXPosition(725); //resets the position of player 2's  ball/mallet
        ballObj2.setYPosition(250); //resets the postion of player 2's ball/mallet

        gameObj.addBall(puckObj); //adding back the puck
        gameObj.addBall(ballObj1); //adding back player 1
        gameObj.addBall(ballObj2); //adding back player 2


      }

      //PLAYER 2
      if (puckObj.getYPosition() > 175 && puckObj.getYPosition() < 325 && puckObj.getXPosition() > 62.5 && puckObj.getXPosition() < 72.5){ //boundries of player 1's goal

        //PUCK/MALLETS REMOVING
        gameObj.removeBall(puckObj); //removes puck

        gameObj.removeBall(ballObj1); //removes player 1's ball/mallet
        gameObj.removeBall(ballObj2); //removes player 2's ball/mallet


        //TEXT
        mainText.setText("Player 2 wins the round!"); //changing text to show player 2 scoring
        mainText.setColour("YELLOW");
        int x = Integer.valueOf(player2ScoreText.getText()) + 1;  //converting value to an integer and adding one to it
        player2ScoreText.setText(String.valueOf(x)); //setting the score text to the new value
        
        //PUCK/MALLETS ADDING
        xPuckSpeed = 0;
        yPuckSpeed =0;
        puckObj.setXPosition(415); //(900/2) - 35 (center circle radius) = 380
        puckObj.setYPosition(250); //500/2 = 250

        ballObj1.setXPosition(175); //resets the position of player 1's  ball/mallet
        ballObj1.setYPosition(250); //resets the postion of player 1's ball/mallet

        ballObj2.setXPosition(725); //resets the position of player 2's  ball/mallet
        ballObj2.setYPosition(250); //resets the postion of player 2's ball/mallet

        gameObj.addBall(puckObj); //adding back the puck
        gameObj.addBall(ballObj1); //adding back player 1
        gameObj.addBall(ballObj2); //adding back player 2


      }

      

      gameObj.pause();
      
    }


    
      
    
    
  }
}
    
          
                                
      
