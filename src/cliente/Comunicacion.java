/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author Juan Pablo
 */
public class Comunicacion {
    
    //private ClienteSocket = null;
    //String recibir;
    //String enviar;
    
    
    public Comunicacion(){
    }       

    public String Registrar(String nick) {
        return "[reg]"+nick;
    }
    
    public String PedirMapa() {
        return "[map]";
    }

    public String pedirPosicion() {
        return "[pos]";
    }
    
    public String jugar() {
        return "[jugar]";
    }
    
   public String date(long date) {
       
        return "[dateconnection]>"+String.valueOf(date);
    }
    
    
    
    
    
    
    
    
    
    
}
