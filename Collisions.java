public class Collisions{

  private double xPuckSpeed;
  private double yPuckSpeed;
  private Ball ballPlayer1;
  private Ball ballPlayer2;
  private Ball puck;
  private Physics physics;


  public Collisions(double xPuckSpeed, double yPuckSpeed, Ball ball, Physics physics, GameArena gameArena){
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
}     
     