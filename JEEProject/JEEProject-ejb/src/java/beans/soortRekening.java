/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author fenrig
 */
public enum soortRekening {
    GeenLeningGeselecteerd("Kies een lening type"),VariabeleLening("Variabele Lening"), VasteLening("Vaste Lening");
    
    private final String text;
    
    private soortRekening(final String text){
        this.text = text;
    }
    
    @Override
    public String toString(){
        return this.text;
    }
}
