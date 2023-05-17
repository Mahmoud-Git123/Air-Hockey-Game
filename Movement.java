public class Movement {

    private Ball ballPlayer1;
    private Ball ballPlayer2;
    private GameArena gameArena;


    public Movement(Ball ball, GameArena gameArena){
        this.ballPlayer1 = ballPlayer1;
        this.ballPlayer2 = ballPlayer2;
        this.gameArena = gameArena;
        
    
    }

    public void player1Move(Ball ballPlayer1, GameArena game){    
        if (ballPlayer1.getXPosition() > (62.5 + 25)){ //setting the x boundries (gap between game rectangle and white rectangle is +62.5 in x direction from the right) of the ball so it doesn't go outside the game rectangle, ball radius is 25.
        if (gameArena.letterPressed('a')){ //if the 'a' key is pressed
            ballPlayer1.move(-6, 0); //ball moves 6 in positive x direction (i.e. to the right)
        }
      }

      if (ballPlayer1.getXPosition() < (450 - 25)){ //setting the x boundires (900[game width/2) of the ball so it doesn't pass middle line, ball radius is 25.
        if (gameArena.letterPressed('d')){ //if the 'd' key is pressed
            ballPlayer1.move(6, 0); //ball moves 6 in negative x direction (i.e. to the left)
        }
      }
    
      if (ballPlayer1.getYPosition() > (87.5 + 25)){ //setting the y boundries ((500[game height]-325[white rectangle height])/2 = 87.5) of the ball so it doesn't go outside the game rectangle, ball radius is 25.
        if (gameArena.letterPressed('w')){ //if the 'w' key is pressed
            ballPlayer1.move(0, -6); //ball moves 6 in negative y direction (i.e upwards)
        }
      }

      if (ballPlayer1.getYPosition() < (412.5 - 25)){ //setting the y boundries (500[game height] - 87.5[gap between game rectangle and white rectangle])  of the ball so it doesn't go outside the game rectangle, ball radius is 25.
        if (gameArena.letterPressed('s')){ //if the 's' key is pressed
            ballPlayer1.move(0, 6); //ball moves 6 in positive y direction (i.e. downwards)
        }
      }
    }

    public void player2Move(Ball ballPlayer2, GameArena game){    
    if (ballPlayer2.getXPosition() < (837.5 - 25)){ //setting the x boundries (900 [game width] - 62.5 [gap between game rectangle and white rectangle]) of the ball so it doesn't go outside the game rectangle, ball radius is 25.
        if (gameArena.rightPressed()){ //if the right arrow button is pressed
            ballPlayer2.move(6, 0); //ball moves 6 in positive x direction (i.e. to the right)
        }
      }

      if (ballPlayer2.getXPosition() > (450 + 25)){ //setting the x boundires ((900[game width/2 = 450)) of the ball so it doesn't pass middle line, ball radius is 25.
        if (gameArena.leftPressed()){ //if the left arrow button is pressed
          ballPlayer2.move(-6, 0); //ball moves 6 in negative x direction (i.e. to the left)
        }
      }
      
      if (ballPlayer2.getYPosition() > (87.5 + 25)){ //setting the y boundries ((500[game height]-325[white rectangle height])/2 = 87.5) of the ball so it doesn't go outside the game rectangle, ball radius is 25.
        if (gameArena.upPressed()){ //if the up arrpuckObjow button is pressed
            ballPlayer2.move(0, -6); //ball moves 6 in negative y direction (i.e upwards)
        }
      }

      if (ballPlayer2.getYPosition() < (412.5 - 25)){ //setting the y boundries (500[game height] - 87.5[gap between game rectangle and white rectangle] = 412.5)  of the ball so it doesn't go outside the game rectangle, ball radius is 25.
        if (gameArena.downPressed()){ //if the down arrow button is pressed
            ballPlayer2.move(0, 6); //ball moves 6 in positive y direction (i.e. downwards)
        }
      }
    }
    
    
}
