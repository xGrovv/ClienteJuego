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
public class mapaDibujo extends JPanel {
    
    private JPanel panel;
    private Graphics grafica;
    
    private int dimension=9;
    private byte[][] miniMatriz=null;
    private int posX_ini;
    private int posY_ini;
    MapaControl mapaControl;
    
    private BufferedImage imagePared;
    private BufferedImage imageBicho;
    private BufferedImage imageEnemigo;
    private BufferedImage imageEnemigoDesc;
    
            
    public  mapaDibujo( MapaControl mapaControl,int posX, int posY){
        this.setBackground(Color.DARK_GRAY);
        this.setBounds(90, 50, 577, 577);
        cargarImagenes();
        this.mapaControl=mapaControl;
        int medio=dimension/2;
        posX_ini=posX-medio;
        posY_ini=posY-medio;
        miniMatriz= mapaControl.obtenersubMapa(dimension, posX, posY);
        
    }
    
    private void cargarImagenes(){
        try {
            String dirPared= getClass().getResource("/Recursos/pared.png").getPath();
            String dirBicho= getClass().getResource("/Recursos/bicho.png").getPath();
            String dirEnemigo= getClass().getResource("/Recursos/enemigo.png").getPath();
            imagePared = ImageIO.read(new File(dirPared));
            //imageBicho = ImageIO.read(new File(dirBicho));
            //imageEnemigo = ImageIO.read(new File(dirEnemigo));
        } catch (IOException ex) {
            Logger.getLogger(mapaDibujo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        dibujar(g);
        System.out.println("eeeee");
    }
    
    public void dibujar(Graphics g){
        
        int tamanio=64;
        for(int fil=0;fil<miniMatriz.length;fil++){
            for(int col=0;col<miniMatriz.length;col++){
                if (miniMatriz[col][fil]==0) // debe ser uno = pared,,....// 0 = calle
                    g.drawImage(imagePared, col*tamanio, fil*tamanio, this);
            }
        }
    }
    
    
}
