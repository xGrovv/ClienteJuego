/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.util.ArrayList;

/**
 *
 * @author Juan Pablo
 */
public class MapaModelo {
    
    private final int nroColumnas;
    private final int nroFilas;
    private byte[][] matriz=null;
    private String mapaModeloString;
    private int posX_Tesoro;
    private int posY_Tesoro;
    
    private ArrayList<Byte> casillasNoValidas = null;
    private int dimensionSubmapa;

    public MapaModelo() {
        this.nroColumnas = 0;
        this.nroFilas = 0;    
    }
    
    public void setValue(byte value, int posX, int PosY){
        matriz[posX][PosY]=value;
    }
    
    public byte getValue(int posX, int PosY){
        return matriz[posX][PosY];
    }

    public int getDimensionSubmapa() {
        return dimensionSubmapa;
    }

    public void setDimensionSubmapa(int dimensionSubmapa) {
        this.dimensionSubmapa = dimensionSubmapa;
    }
    
    

    public MapaModelo(int nroColumnas, int nroFilas) {
        this.nroColumnas = nroColumnas;
        this.nroFilas = nroFilas;
        matriz = new byte[nroColumnas][nroFilas];  
        casillasNoValidas = new ArrayList<>();
        casillasNoValidas.add( new Byte("0") );
        casillasNoValidas.add( new Byte("1") );
        casillasNoValidas.add( new Byte("2") );
        
    }
    
    public void addCasillasValidas(byte casilla){
        if (casillasNoValidas != null) {
            casillasNoValidas.add(casilla);
        }
    };
    
    
    public byte[][] SubMapa( int posx, int posy, int dimension){
        //en posion central posx , posy del jugador se obtiene un submapa
        int xn = posx - dimension/2;
        int yn = posy - dimension/2;
        int xp = posx + dimension/2;
        int yp = posy + dimension/2;   
        int inix = 0;
        int iniy = 0;
        
        if( xn>0 ){
            //fijar x
        }
        if( yn>0 ){
            //fijar y
        }
        if( xp<101 ){
            //fijar x
        }
        if( yp<101 ){
            //fijar y
        }
        
        return getSubMapa( inix,iniy, dimension );
    }
    

    public byte[][] SubMapa( int posx, int posy){
        //en posion central posx , posy del jugador se obtiene un submapa
        int xn = posx - dimensionSubmapa/2;
        int yn = posy - dimensionSubmapa/2;
        int xp = posx + dimensionSubmapa/2;
        int yp = posy + dimensionSubmapa/2;   

        
        return getSubMapa( xn,yn, dimensionSubmapa );
    }    
    
    private byte[][] getSubMapa(int inix, int iniy, int dimension) {
        byte[][] tmp = null;
        for (int i = inix; i < dimension+inix; i++) {
            for (int j = iniy; j < dimension+iniy; j++) {
                tmp[i-inix][j-iniy] = matriz[i][j];
            }
        }
        return tmp;
    }    
    
    public boolean isPosicionValido( int x, int y ){
        
        if( (matriz[x][y]!=0) && (matriz[x][y]!=1 && (matriz[x][y]!=2))  ){
            return true;
        }
        else
           return false;
    }
    
    public boolean isPosiconEnMapa( int x, int y ){
        
        if( (x>=0) && (x<=100) && (y>=0) && (y<=100)){            
                return true;
        }
        else{
            return false;
        }
        
    }


    
    
    
}
