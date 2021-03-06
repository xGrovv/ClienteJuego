/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import eventos.MapaModeloEvent;
import eventos.MapaModeloListener;
import java.awt.Point;
import java.util.ArrayList;
import java.util.ListIterator;
import vista.mapaDibujo;

/**
 *
 * @author Grover
 */
public class MapaControl {
    
    private MapaModelo mapaModelo;
    private String mapaModeloString;
    private int nroColumnas;
    private int nroFilas;
    private ArrayList listeners;
    public static final byte ESPACIO_LIBRE = 0;
    
    
    public MapaControl(int nroColumnas, int nroFilas, String mapaModeloString){
        this.nroColumnas=nroColumnas;
        this.nroFilas= nroFilas;
        this.mapaModeloString = mapaModeloString;
        mapaModelo=new MapaModelo(nroColumnas, nroFilas);
        listeners = new ArrayList();
        cargarMapaModelo();
        //SituarObjetivo();
    }
    
    public String getMapaModeloString(){
        return mapaModeloString;
    }
    
    public int getNroColumnas(){
        return nroColumnas;
    }
    
    public int getNroFilas(){
        return nroFilas;
    }
    
    private void cargarMapaModelo(){
        byte[] Arreglo = mapaModeloString.getBytes();
        int fil, col;
        fil = col =0;
        for (byte letra : Arreglo){
            if(letra==49)
                letra=1;
            if(letra==48)
                letra=0;
            mapaModelo.setValue(letra, col, fil);
            col++;
            if (col>=100){
                col=0;
                fil++;
            }
        }
    }
    
    public byte[][] obtenersubMapa(int dimension, int posX, int posY){
        byte [][] resp=new byte[dimension][dimension];
        for (int fil =0; fil<dimension;fil++ ){
            for (int col =0; col<dimension;col++ ){
                //si nos pide valores fuera de los limites
                if (((posX+col<0)||(posY+fil<0))||((posX+col>99)||(posY+fil>99)))
                    resp[col][fil]=mapaDibujo.FIN_VAL;
                else
                    resp[col][fil]=mapaModelo.getValue(posX+col, posY+fil);
            }
        }
        return resp;
    }
    
    public void addListener(MapaModeloListener mapaModeloListener){
        listeners.add(mapaModeloListener);
    }
    
    public void cambiarValores(int posX1, int posY1, int posX2, int posY2){
        byte val1=mapaModelo.getValue(posX1, posY1);
        byte val2=mapaModelo.getValue(posX2, posY2);
        mapaModelo.setValue(val2, posX1, posY1);
        mapaModelo.setValue(val1, posX2, posY2);
        
        ListIterator li = listeners.listIterator();
        while (li.hasNext()) {
            MapaModeloListener listener = (MapaModeloListener) li.next();
            MapaModeloEvent evObj = new MapaModeloEvent(new DoublePoint(posX1, posY1, posX2, posY2));
            (listener).onChangeMapaModelo(evObj);
        }
    }
    
    public void cambiarValor(byte val, int posX1, int posY1){
        
        
        mapaModelo.setValue(val, posX1, posY1);
        
        
        ListIterator li = listeners.listIterator();
        while (li.hasNext()) {
            MapaModeloListener listener = (MapaModeloListener) li.next();
            MapaModeloEvent evObj = new MapaModeloEvent(new Point(posX1, posY1));
            (listener).onChangeMapaModeloUnValor(evObj);
        }
    }
    
    public void addJugador(byte nroJugador, int col, int fil){
        mapaModelo.setValue(nroJugador, col, fil);    
    }
    
    public boolean posInvalida(int posX, int posY){
        return (((posX<0)||(posY<0))||((posX>99)||(posY>99)));
    } 
    
    public boolean posicionLibre (int posX, int posY){
        if (posInvalida(posX, posY))
            return false;
        return mapaModelo.getValue(posX, posY)==ESPACIO_LIBRE;
    }
    
}
