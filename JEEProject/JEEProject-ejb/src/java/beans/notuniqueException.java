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
public class notuniqueException extends Exception{
    public notuniqueException(){
        super();
    }
    
    public notuniqueException(String detailMessage){
        super(detailMessage);
    }
    
    public notuniqueException(String detailMessage, Throwable throwable){
        super(detailMessage, throwable);
    }
    
    public notuniqueException(Throwable throwable){
        super(throwable);
    }
}
