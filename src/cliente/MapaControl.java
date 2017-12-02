/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grover
 */
public class MapaControl {
    
    private MapaModelo mapaModelo;
    private String mapaModeloString;
    private int nroColumnas;
    private int nroFilas;
    
    private static final byte ESPACIO_LIBRE = 0;
    
    
    public MapaControl(int nroColumnas, int nroFilas, String mapaModeloString){
        this.nroColumnas=nroColumnas;
        this.nroFilas= nroFilas;
        this.mapaModeloString = mapaModeloString;
        mapaModelo=new MapaModelo(nroColumnas, nroFilas);
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
    
    /*private void SituarObjetivo(){
        Point posLibre = getPosicionLibreRandom();
        posX_Objetivo=posLibre.x;
        posY_Objetivo=posLibre.y;
    }*/
    
    private Point getPosicionLibreRandom(){
        Random rn = new Random();
        while (true){
            int fil=rn.nextInt(100);
            int col=rn.nextInt(100);
            if (mapaModelo.getValue(col, fil)==0)
                return new Point(col,fil);
        }
    }
    
    public byte[][] obtenersubMapa(int dimension, int posX, int posY){
        byte [][] resp=new byte[dimension][dimension];
        for (int fil =0; fil<dimension;fil++ ){
            for (int col =0; col<dimension;col++ ){
                byte gg = mapaModelo.getValue(posX+col, posX+col);
                resp[col][fil]=mapaModelo.getValue(posX+col, posY+fil);
            }
        }
        return resp;
    }
    
    public void setMapaModelo(){
        
        String dir=getClass().getResource("/Recursos/mapa1.txt").getPath();
        String linea;
        FileReader fileR; 
        try {
            fileR = new FileReader(getClass().getResource("/Recursos/mapa1.txt").getPath());
            BufferedReader br = new BufferedReader(fileR);
            int fila=0;
            while((linea = br.readLine())!=null) {
                int columna=0;
                // letra c es camino, letra p es pared. convertiremos estos a 0 caminio y 1 pared
                for (byte letra : linea.getBytes()){
                    if (letra=='c')
                        letra=1;
                    else
                        letra=0;
                    mapaModelo.setValue(letra,fila,columna);
                    columna++;
                }
                for (int i=0; i<=linea.length();i++)
                fila++;
            }   
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MapaControl.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
                Logger.getLogger(MapaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void situarJugador(Jugador jugador, int distancia){
        Point posLibre = getPosicionLibreRandom();
        // if posLibre esta a tiene una lejania minima de "distancia" con la pos del objetivo
        // asignar los valores a jugador
        // de otro modo volver a pedir otra posLibre
        //tips:: no situar al jugador en la imaginario area de vision del objetivo
        
        
    }
    
    /*public void addJugadores(ArrayList<Point> lista){
        mapaModelo.setValue(jugador.getNro(), jugador.getPosX(), jugador.getPosY());
    }*/
    
    public void addJugador(byte nroJugador, int col, int fil){
        mapaModelo.setValue(nroJugador, col, fil);
        
    }
    
    public boolean posicionLibre (int posX, int posY){
        return mapaModelo.getValue(posX, posY)==ESPACIO_LIBRE;
    }
    
    
    
}