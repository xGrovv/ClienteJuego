/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import cliente.MapaControl;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Grover
 */
public class mapaDibujo extends JPanel{
    
    private JPanel panel;
    private Graphics grafica;
    
    private final int DIMENSION_IMAGEN=52;
    private final int DIMENSION=11;
    private byte[][] miniMatriz=null;
    private int posX_ini;
    private int posY_ini;
    MapaControl mapaControl;
    
    private BufferedImage imagePared;
    private BufferedImage imageCesped;
    private BufferedImage imagefin;
    private BufferedImage imageBicho;
    private BufferedImage imageEnemigo;
    private BufferedImage imageBichoBlock;
    private BufferedImage imageEnemigoBlock;
    private final int PARED_VAL=1;
    private final int CESPED_VAL=0;
    public static final int FIN_VAL=2;
    
            
    public  mapaDibujo( MapaControl mapaControl,int posX, int posY){
        this.setBackground(Color.DARK_GRAY);
        this.setBounds(90, 50, 577, 577);
        cargarImagenes();
        this.mapaControl=mapaControl;
        int medio=DIMENSION/2;
        posX_ini=posX-medio;
        posY_ini=posY-medio;
        miniMatriz= mapaControl.obtenersubMapa(DIMENSION, posX_ini, posY_ini);
    }
    
    private void cargarImagenes(){
        try {
            String dirPared= getClass().getResource("/Recursos/pared52b.jpg").getPath();
            String dirCesped= getClass().getResource("/Recursos/cesped52.jpg").getPath();
            String dirFin= getClass().getResource("/Recursos/fin52.jpg").getPath();
            String dirBicho= getClass().getResource("/Recursos/bicho52.jpg").getPath();
            String dirEnemigo= getClass().getResource("/Recursos/enemigo52.jpg").getPath();
            String dirBichoBlock= getClass().getResource("/Recursos/bichoBlock52.jpg").getPath();
            String dirEnemigoBlock= getClass().getResource("/Recursos/enemigoBlock52.jpg").getPath();
            imagePared = ImageIO.read(new File(dirPared));
            imageCesped = ImageIO.read(new File(dirCesped));
            imagefin = ImageIO.read(new File(dirFin));
            imageBicho = ImageIO.read(new File(dirBicho));
            imageBichoBlock = ImageIO.read(new File(dirBichoBlock));
            imageEnemigo = ImageIO.read(new File(dirEnemigo));
        } catch (IOException ex) {
            Logger.getLogger(mapaDibujo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarMinimatriz(int posX, int posY){
        int medio=DIMENSION/2;
        posX_ini=posX-medio;
        posY_ini=posY-medio;
        miniMatriz= mapaControl.obtenersubMapa(DIMENSION, posX_ini, posY_ini);
    }
    
    public boolean posIncluida(int posX, int posY){
        if ((posX>=posX_ini)&&(posX<posX_ini+DIMENSION))
            if ((posY>=posY_ini)&&(posY<posY_ini+DIMENSION))
                return true;
        return false;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        dibujar(g);
    }
    
    public void dibujar(Graphics g){
        int tamanio=DIMENSION_IMAGEN;
        for(int fil=0;fil<miniMatriz.length;fil++){
            for(int col=0;col<miniMatriz.length;col++){
                if (miniMatriz[col][fil]==PARED_VAL)
                    g.drawImage(imagePared, col*tamanio, fil*tamanio, this);
                if (miniMatriz[col][fil]==CESPED_VAL)
                    g.drawImage(imageCesped, col*tamanio, fil*tamanio, this);
                if (miniMatriz[col][fil]==FIN_VAL)
                    g.drawImage(imagefin, col*tamanio, fil*tamanio, this);
                if (miniMatriz[col][fil]>10)
                    if (miniMatriz[col][fil]>100)                    
                        g.drawImage(imageBichoBlock, col*tamanio, fil*tamanio, this);
                    else
                        g.drawImage(imageBicho, col*tamanio, fil*tamanio, this);
            }
        }
    }

    
}
