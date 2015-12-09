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
public class validationException extends Exception{
    public validationException(){
        super();
    }
    
    public validationException(String detailMessage){
        super(detailMessage);
    }
    
    public validationException(String detailMessage, Throwable throwable){
        super(detailMessage, throwable);
    }
    
    public validationException(Throwable throwable){
        super(throwable);
    }
}
