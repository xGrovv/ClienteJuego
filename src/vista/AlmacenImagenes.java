/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Image;

/**
 *
 * @author Juan Pablo
 */
public class AlmacenImagenes {
    
    Image[] lista = null;
    int esperadas = 0;
    int cargadas = 0; 

    public AlmacenImagenes() {
        lista = new Image[12];
    }        
    
    public void cargar( Image[] list){
        esperadas = list.length;
        lista = new Image[esperadas];
        for (int i = 0; i < esperadas; i++) {
            lista[i] = list[i];
            imagenCargada();
            
        }
    }
    public boolean imagenCargada(){
        cargadas++;
        if ( cargadas == esperadas) {
            return true;
        }
        return false;
    }
    
    public Image get(int id){
        return lista[id];
    }
}
