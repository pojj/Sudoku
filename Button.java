/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author william.song
 */
public class Button extends JButton{
    private final int CORRECT;
    private final boolean REVEALED;
    private int shown;
    
    public Button(int num, boolean displayed){
        this.setPreferredSize(new Dimension(50, 50));
        this.setBackground(Sudoku.LIGHTYELLOW);
        CORRECT = num;
        REVEALED = displayed;
        
        if (REVEALED){
            this.setFont(Sudoku.FONT);
            this.setText(Integer.toString(CORRECT));
        }
        else{
            this.setFont(Sudoku.FONT);
        }
    }
    
    public void setShown(int value){
        if (!REVEALED){
            shown = value;
            this.setText(Integer.toString(shown));
            this.setBackground(Sudoku.LIGHTBLUE);
            this.setForeground(Sudoku.BLUE);
        }
    }
    
    public int getShown(){
        // return number that is displayed on button
        if (REVEALED){
            return CORRECT;
        }else{
            return shown;
        }
    }   
    
    public boolean isCorrect(){
        return this.getText().equals(Integer.toString(CORRECT));
    }
    
    
}
