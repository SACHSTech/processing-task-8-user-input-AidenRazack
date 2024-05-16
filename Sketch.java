import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;

public class Sketch extends PApplet {

   /**
   * A. Razack
   * A program that combines the use of miltuple keyboard and mouse inputs 
   */

  ArrayList<Integer> squareX = new ArrayList<Integer>(); 
  ArrayList<Integer> squareY = new ArrayList<Integer>(); 
  char lastKeyPressed;
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;
  PImage imgRect;
  float imgX = 150;
  float imgY = 150;
  float imgWidth = 100;
  float imgLength = 100;

  public void settings() {
    size(800, 800);
  }

  public void setup() {
    background(32);
    imgRect = loadImage("360_F_459326746_Sbe7u3BYDy3rDmMk1MP9IMUkkgTHRNss.png");
  }

  public void draw() {

    // draw a face that changes to green when mouse is clicked
    float faceX = mouseX;
    float faceY = mouseY;
    background(32); 
    if (mousePressed) {
      fill(102, 255, 102);
    } else {
      fill(255, 204, 153);
    }
    drawSlimeyFace(faceX, faceY);

    // Draw all the squares
    for (int i = 0; i < squareX.size(); i++) {
      fill(255);
      rect(squareX.get(i) - 5, squareY.get(i) - 5, 10, 10);
    }

    // Display last pressed key in the top left corner
    fill(255);
    textSize(16);
    text("Last Key Pressed: " + key, 10, 20);

    // Draw the image that will move if the arrow keys are pressed
    if (upPressed) {
      imgY--;
    }
    if (downPressed) {
      imgY++;
    }
    if (leftPressed) {
      imgX--;
    }
    if (rightPressed) {
      imgX++;
    }
  
    image(imgRect, imgX, imgY, imgWidth, imgLength);
  }

  // Method to draw a slimey face that turns upside down is a key is pressed
  private void drawSlimeyFace(float x, float y) {
    if (keyPressed) {

      ellipse(x, y, width/8, height/8);
      fill(255); 
      ellipse(x - width/50, y + height/50, width/40, height/40); 
      ellipse(x + width/50, y + height/50, width/40, height/40); 
      fill(0); 
      ellipse(x - width/50, y + height/50, width/80, height/80);
      ellipse(x + width/50, y + height/50, width/80, height/80); 
      fill(255, 102, 102);
      triangle(x, y + height/80, x - width/80, y - height/80, x + width/80, y - height/80);
      arc(x, y - height/50, width/16, height/20, PI, TWO_PI); 
    } else {

      ellipse(x, y, width/8, height/8);
      fill(255); 
      ellipse(x - width/50, y - height/50, width/40, height/40); 
      ellipse(x + width/50, y - height/50, width/40, height/40); 
      fill(0); 
      ellipse(x - width/50, y - height/50, width/80, height/80);
      ellipse(x + width/50, y - height/50, width/80, height/80); 
      fill(255, 102, 102);
      triangle(x, y - height/80, x - width/80, y + height/80, x + width/80, y + height/80);
      arc(x, y + height/60, width/16, height/20, 0, PI); 
    }
  }

  // Function to draw a small square at the mouse position when clicked
  public void mouseReleased() {
    squareX.add(mouseX);
    squareY.add(mouseY);
  }

  // Function that will check if an arrow key is pressed
  public void keyPressed() {
    if (keyCode == UP) {
      upPressed = true;
    }
    else if (keyCode == DOWN) {
      downPressed = true;
    }
    else if (keyCode == LEFT) {
      leftPressed = true;
    }
    else if (keyCode == RIGHT) {
      rightPressed = true;
    }
    
    // Condition to clear squares if 'r' key is pressed clear all the squares
    else if (key == 'r' || key == 'R') {
      squareX.clear();
      squareY.clear();
    }
  }
  
  // Function that will check if an arrow key is released
  public void keyReleased() {
    if (keyCode == UP) {
      upPressed = false;
    }
    else if (keyCode == DOWN) {
      downPressed = false;
    }
    else if (keyCode == LEFT) {
      leftPressed = false;
    }
    else if (keyCode == RIGHT) {
      rightPressed = false;
    }
  }
}