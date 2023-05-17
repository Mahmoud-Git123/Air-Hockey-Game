public class Collisions{

  private double xPuckSpeed;
  private double yPuckSpeed;
  private GameArena gameArena;
  private Ball ballPlayer1;
  private Ball ballPlayer2;
  private Ball puck;
  private Physics physics;

  public Collisions(double xPuckSpeed, double yPuckSpeed, Ball puck, Ball ballPlayer1, Ball ballPlayer2, GameArena gameArena){
    this.xPuckSpeed = xPuckSpeed;
    this.yPuckSpeed = yPuckSpeed;
    this.ballPlayer1 = ballPlayer1;
    this.ballPlayer2 = ballPlayer2;
    this.puck = puck;
  }

  public void collides(Ball puck, Ball player1Ball, Ball player2Ball, GameArena gameArena){
  
    //PLAYER 1
    if (puck.collides(player1Ball)){ //if player 1's ball/mallet hits the puck

      //Creating an object of the physics class for player 2, where xpseed1 and yspeed1 are the puck's speeds and ball/mallet speeds is 15
      Physics physicsObjPlayer1 = new Physics(player1Ball.getXPosition(), puck.getXPosition(),player1Ball.getYPosition() , puck.getYPosition(), 15, xPuckSpeed, 15, yPuckSpeed);

      physicsObjPlayer1.deflect(); //deflection method in phyiscs class

      xPuckSpeed = physicsObjPlayer1.xSpeed2; //setting the x speed of the puck to match the speed in physics class after deflection
      yPuckSpeed = physicsObjPlayer1.ySpeed2; //setting the y speed of the puck to match the speed in physics class after deflection
    }

    //PLAYER 2
    if (puck.collides(player2Ball)){ //if player 2's ball/mallett hits the puck

      //Creating an object of the physics class for player 1, where xpseed 1 and yspeed 1 are the puck's speeds and ball/mallet speeds is 15
      Physics physicsObjPlayer2 = new Physics(player2Ball.getXPosition(), puck.getXPosition(), player2Ball.getYPosition() , puck.getYPosition(), 15, xPuckSpeed, 15, yPuckSpeed);

      physicsObjPlayer2.deflect(); //deflection method in phyiscs class

      xPuckSpeed = physicsObjPlayer2.xSpeed2; //setting the x speed of the puck to match the speed in physics class after deflection
      yPuckSpeed = physicsObjPlayer2.ySpeed2; //setting the y speed of the puck to match the speed in physics class after deflection
    }


    //Setting puck boundries
    if (puck.getXPosition() < 70 || puck.getXPosition() > 830){
      xPuckSpeed = xPuckSpeed*-1; //reverses speed causing puck to bounce and go in opposite direction
    }    
      
    if (puck.getYPosition() > 405 || puck.getYPosition() < 95){
      yPuckSpeed = yPuckSpeed*-1; //reverses speed causing puck to bounce and go in opposite direction
    }

    xPuckSpeed = xPuckSpeed*0.988; //adding friction
    yPuckSpeed = yPuckSpeed*0.988; //adding friction

    puck.move(xPuckSpeed, yPuckSpeed); //puck moves depending on the speed given from  the above if statements

  }

  /*GOAL SCORING */

  public void player1Scores(Ball puck, Ball player1Ball, Text mainText, Text player1ScoreText, GameArena gameArena){

    //PLAYER 1
    if (puck.getYPosition() > 175 && puck.getYPosition() < 325 && puck.getXPosition() > 827.5 && puck.getXPosition() < 837.5){ //boundies of player 2's goal

        //TEXT
        mainText.setText("Player 1 wins the round!"); //changing text to show player 1 scoring
        mainText.setColour("GREEN");
        int x = Integer.valueOf(player1ScoreText.getText()) + 1;  //converting goal value to an integer and adding one to it
        player1ScoreText.setText(String.valueOf(x)); //setting the score text to the new value

        gameArena.pause();

        //PUCK/MALLETS RESETTING
        puck.setXPosition(485); //(900/2) + 35 (center circle radius) = 485
        puck.setYPosition(250); //500/2 = 250

        ballPlayer1.setXPosition(175); //resets the position of player 1's  ball/mallet
        ballPlayer1.setYPosition(250); //resets the postion of player 1's ball/mallet

        ballPlayer2.setXPosition(725); //resets the position of player 2's  ball/mallet
        ballPlayer2.setYPosition(250); //resets the postion of player 2's ball/mallet

        xPuckSpeed = 0;
        yPuckSpeed = 0;

    }

  }

  public void player2Scores(Ball puck, Ball player2Ball, Text mainText, Text player2ScoreText, GameArena gameArena){

      //PLAYER 2
      if (puck.getYPosition() > 175 && puck.getYPosition() < 325 && puck.getXPosition() > 62.5 && puck.getXPosition() < 72.5){ //boundries of player 1's goal

          //TEXT
          mainText.setText("Player 2 wins the round!"); //changing text to show player 2 scoring
          mainText.setColour("YELLOW");
          int x = Integer.valueOf(player2ScoreText.getText()) + 1;  //converting value to an integer and adding one to it
          player2ScoreText.setText(String.valueOf(x)); //setting the score text to the new value
          
          gameArena.pause();

          //PUCK/MALLETS RESETTING
          puck.setXPosition(415); //(900/2) - 35 (center circle radius) = 380
          puck.setYPosition(250); //500/2 = 250

          ballPlayer1.setXPosition(175); //resets the position of player 1's  ball/mallet
          ballPlayer1.setYPosition(250); //resets the postion of player 1's ball/mallet

          ballPlayer2.setXPosition(725); //resets the position of player 2's  ball/mallet
          ballPlayer2.setYPosition(250); //resets the postion of player 2's ball/mallet

          xPuckSpeed = 0;
          yPuckSpeed = 0;

      }
  }

  //Setter methods to change puck's X and Y speed
  public void setPuckXSpeed(double xPuckSpeed){
    this.xPuckSpeed = xPuckSpeed;
  }

  public void setPuckYSpeed(double yPuckSpeed){
    this.yPuckSpeed = yPuckSpeed;
  }
  

}     
     