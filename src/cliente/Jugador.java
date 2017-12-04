/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.util.logging.Logger;

/**
 *
 * @author Juan Pablo
 */
public class Jugador {
    //private static Logger log = Logger.getLogger(Jugador.class.getName());
    
    private String nickname;
    private int posX;
    private int posY;
    private byte nro;
    private long dateconnection;
    private String estado;
    
   
    public Jugador(String n,byte nro) {
       this.nickname = n;
       this.nro = nro;
       this.posX = 0;
       this.posY = 0;
       this.dateconnection = 0;
       estado = "sinPartida";
    }

    public long getDateconnection() {
        return dateconnection;
    }

    public void setDateconnection(long dateconnection) {
        this.dateconnection = dateconnection;
    }
    
        
    void situar(int x, int y){
        this.posX = x;
        this.posY = y;
    }
    
    void mover(boolean arriba, boolean abajo, boolean izquierda, boolean derecha){
        if (arriba) {
            posX-=1;
        }
        if (abajo) {
            posX+=1;
        }
        if (izquierda) {
            posY-=1;            
        }
        if (derecha) {
            posY+=1;
        }
    }
    


    public int getPosX() {
        return posX;
    }

    public void setPosX(int posicionX) {
        this.posX = posicionX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posicionY) {
        this.posY = posicionY;
    }
    
    public void setNro(byte nro) {
        this.nro = nro;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public byte getNro() {
        return nro;
    }

    public String getNickname() {
        return nickname;
    }
    
}
