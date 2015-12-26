/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.text.DecimalFormat;

/**
 *
 * @author fenrig
 */
public class numberFormatClass {
    DecimalFormat df = new DecimalFormat("#,###.00");
    DecimalFormat percf = new DecimalFormat("#.##");
    
    public String formatCurrency(double cur){
        return df.format(cur);
    }
    
    public String formatPercentage(double perc){
        if(perc < 1){
            perc = perc * 100;
        }
        return percf.format(perc) + "%";
    }
}
