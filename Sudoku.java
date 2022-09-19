/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author william.song
 */
public class Sudoku extends JFrame {
    // Inheritance: Sudoku is a JFrame
    static int[][] SOLUTION ={
        {7,8,5,9,3,1,4,6,2},
        {2,4,3,8,5,6,9,7,1},
        {6,9,1,7,2,4,5,8,3},
        {4,5,7,6,1,2,3,9,8},
        {9,6,8,5,7,3,2,1,4},
        {1,3,2,4,9,8,6,5,7},
        {3,7,9,2,8,5,1,4,6},
        {5,2,4,1,6,7,8,3,9},
        {8,1,6,3,4,9,7,2,5}};

    private final boolean[][] REVEALEDCELLS; // instance variable
    
    private final Button[][] BUTTONS = new Button[9][9]; // instance varible
        
    // IDK if private or not
    private NumberPadButton currButton;
    
    public static final Color LIGHTYELLOW = new Color(255, 255, 220);
    public static final Color LIGHTGREEN = new Color(220, 255, 220);
    public static final Color BLUE = new Color(70, 70, 200);
    public static final Color LIGHTBLUE = new Color(230, 230, 255);
    
    public static final Font FONT = new Font(
        "Comic Sans MS",
        Font.BOLD, // font syle
        27 // font size  
    );
    
    public Sudoku(){
        super("Sudoku"); //sends a title to JFrame constructor
        
        REVEALEDCELLS = new boolean[][]{
        {false,true,false,false,true,false,true,false,false},
        {false,false,false,false,true,false,false,false,true},
        {false,false,false,false,false,true,true,true,false},
        {false,true,true,false,false,true,false,true,false},
        {true,false,false,false,false,false,false,false,true},
        {false,true,false,true,false,false,true,true,false},
        {false,true,true,true,false,false,false,false,false},
        {true,false,false,false,true,false,false,false,false},
        {false,false,true,false,true,false,false,true,false}};
        
//        REVEALEDCELLS = new boolean[][]{
//        {false,true,true,true,true,true,true,true,true},
//        {true,true,true,true,true,true,true,true,true},
//        {true,true,true,true,true,true,true,true,true},
//        {true,true,true,true,true,true,true,true,true},
//        {true,true,true,true,true,true,true,true,true},
//        {true,true,true,true,true,false,true,true,true},
//        {true,true,true,true,true,true,true,true,true},
//        {true,true,true,true,true,true,true,true,true},
//        {true,true,true,true,true,true,true,true,true}};
        
          
          
    }


    /**
     *
     * @param grid
     * @param booleanGrid
     */
    public void printGrid(int[][] grid, int[][] booleanGrid){
        for (int i = 0; i < 9; i++){
            System.out.print("|");
            for (int j = 0; j < 9; j++){
                if (booleanGrid[i][j] == 1){
                    System.out.print(grid[i][j]+ "|");
                } else{
                    System.out.print(" |");
                }
            }
        System.out.println(Arrays.toString(grid));
        }
    }
    

    
    private void createGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        JPanel numberPanel = new JPanel();
        JPanel outerPanel = new JPanel();
        GridLayout grid = new GridLayout(3, 3);
        FlowLayout flow = new FlowLayout(2,50,50);
        mainPanel.setLayout(grid);
        numberPanel.setLayout(grid);
        outerPanel.setLayout(flow);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        ClickHandler ch = new ClickHandler(this);
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(grid);
                for (int k = 0; k < 3; k++){
                    for (int l = 0; l < 3; l++){
                        Button b = new Button(SOLUTION[i*3+k][j*3+l], REVEALEDCELLS[i*3+k][j*3+l]);
                        b.addActionListener(ch);
                        buttonPanel.add(b);
                        BUTTONS[i*3+k][j*3+l] = b;
                    }
                }
                buttonPanel.setBorder(blackline);
                mainPanel.add(buttonPanel);   
                
                // Number pad leeches off button panel's for loop
                NumberPadButton b = new NumberPadButton(i*3 + j + 1);
                b.addActionListener(ch);
                numberPanel.add(b);
            }
        }
                
        mainPanel.setBorder(blackline);
        numberPanel.setBorder(blackline);

        
        outerPanel.add(mainPanel);
        outerPanel.add(numberPanel);
        outerPanel.setBackground(Sudoku.LIGHTGREEN);
        
        this.setVisible(true);
        this.add(outerPanel);
        this.pack();


    }
   
    public NumberPadButton getCurrButton(){
        return currButton;
    }
    
    public void setCurrButton(NumberPadButton b){
        currButton = b;
    }
    
    public void highlightNumber(){
        for (Button[] buttonP: BUTTONS){
            for (Button button: buttonP){
                if (button.getShown() == currButton.getValue()){
                    button.setBackground(LIGHTBLUE);
                } else {
                    button.setBackground(Sudoku.LIGHTYELLOW);
                }           
            }
        }
    }
    
    public boolean isWon(){        
        boolean win = true;
        
        for (Button[] buttonP: BUTTONS){
            for (Button button: buttonP){
                if (!button.isCorrect()){
                  win = false; 
                }
            }
        }
        return win;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sudoku game = new Sudoku();
        game.createGUI();
        
    }

  
    
        
    
}
