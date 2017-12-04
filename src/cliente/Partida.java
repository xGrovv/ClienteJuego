/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Juan Pablo
 */
public class Partida {
    private Jugador jugador =  null;
    private MapaModelo mapa = null;
    private boolean finalPartida = false;
    private String estado;

    public Partida() {
       //jugador = new Jugador(nick);
    }
    
    void situarJugador(){
      //elegir lugar ramdom o obtenerlo de mapa
      int x = getNumeroRandom(1, 100);
      int y = getNumeroRandom(1, 100);
        while ( !mapa.isPosicionValida(x, y)) {            
            x = getNumeroRandom(1, 100);
            y = getNumeroRandom(1, 100);
        }
        jugador.situar(x, y);
  
    }
        
    private int getNumeroRandom(int min, int max){
       return ThreadLocalRandom.current().nextInt(min, max);
    }
    
    boolean esPosicionValida(int pf, int pc){
        
        return true;
    }
    
    void crearPartida(){
        
    }
    
    void finalizarPartida(){
        
    }
    
    boolean moverJugador(){
        return true; 
    }
    
    boolean validarMovida(){
        return true;
    }
    
    boolean verificarFinJuego(){
        return true;
    }
    
    byte[][] obtenerSubMapa(int px, int py){
        
        return new byte[5][5];
    } 
    

    
    
    
}
