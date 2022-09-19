/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author william.song
 */
public class ClickHandler implements ActionListener{
    //MouseListener is an interface which just provides
    //the structure but all methods are abstract
    private final Sudoku game;
    
    public ClickHandler(Sudoku game){
        // why do you need this?
        this.game = game;
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        // reminder cuz i forgot once evt.getSource() returns object
        // "(Button)" casts to the specific button getting clicked
        
        
        if (evt.getSource() instanceof Button){
            Button b = (Button) evt.getSource();
            // If a NumPadButton has been selected set a button to the numpad value
            // else do nothing
            if (game.getCurrButton() != null){
                b.setShown(game.getCurrButton().getValue());
            }
        }
        else{
            NumberPadButton b = (NumberPadButton) evt.getSource();
            
            // If a NumPadButton has been selected change last pressed button back to white
            if (game.getCurrButton() != null){               
                game.getCurrButton().changeColour();
            }
            game.setCurrButton(b);
            // change pressed button to blue
            b.changeColour();
            
            // change colour of all matching numbers
            game.highlightNumber();
        }
        
        System.out.println(game.isWon());

        
        
    }
    
}
