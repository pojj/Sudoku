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
public class NumberPadButton extends JButton{
    private final int VALUE;
    
    public NumberPadButton(int number){
        this.setPreferredSize(new Dimension(50, 50));
        this.setBackground(Sudoku.LIGHTYELLOW);
        VALUE = number; 
        this.setFont(Sudoku.FONT);
        this.setText(Integer.toString(VALUE));
    }
    
    public int getValue(){
        return VALUE;
    }
    
    public void changeColour(){
        // toggle color from white to blue
        if (this.getBackground().equals(Sudoku.LIGHTYELLOW)){
            this.setBackground(Sudoku.LIGHTBLUE);
        } else {
            this.setBackground(Sudoku.LIGHTYELLOW);
        }
    }
}
