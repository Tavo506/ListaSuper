package listasuper;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Producto {
    JLabel labelNombre;
    JTextField textCantidad;
    JButton decButton, incButton;
    int x;
    
    public Producto(String nombre, int Nx, JPanel panel){

        
        labelNombre = new JLabel(nombre);
        labelNombre.setForeground(Color.black);
        labelNombre.setFont(new Font("Arial", Font.PLAIN, 14));
        labelNombre.setSize(300, 50);
        
        
        textCantidad = new JTextField();
        textCantidad.setSize(36, 30);
        
        
        decButton = new JButton();
        decButton.setSize(30, 30);
        decButton.setFocusable(false);
        decButton.addActionListener((ActionEvent e) -> {  
            int num = getIntCant();
            if(num <= 0)
                num = 0;
            else
                num--;
            setCant(Integer.toString(num));
        });
        
        incButton = new JButton();
        incButton.setSize(30, 30);
        incButton.setFocusable(false);
        incButton.addActionListener((ActionEvent e) -> {  
            int num = getIntCant();
            if(num < 0)
                num = 0;
            num++;
            setCant(Integer.toString(num));
        });
        
        decButton.setIcon(new ImageIcon(Principal.menos));
        incButton.setIcon(new ImageIcon(Principal.mas));

        
        setRow(Nx);
        
        panel.add(labelNombre);
        panel.add(decButton);
        panel.add(textCantidad);
        panel.add(incButton);
        
    }
    
    public void setRow(int Nx){
        labelNombre.setLocation(10, Nx);
        
        decButton.setLocation(310, Nx+10);
        textCantidad.setLocation(342, Nx+10);
        incButton.setLocation(380, Nx+10);
        
        x = Nx;
    }
    
    public String getCant(){
        return textCantidad.getText();
    }
    
    public int getIntCant(){
        int num;
        try{
            num = Integer.parseInt(textCantidad.getText());
        }catch(NumberFormatException ex){
            num = 0;
        }
        return num;
    }
    
    public void setCant(String cant){
        textCantidad.setText(cant);
    }
    
    public String getName(){
        return labelNombre.getText();
    }
    
    public void setVisible(boolean state){
        labelNombre.setVisible(state);
        textCantidad.setVisible(state);
        decButton.setVisible(state);
        incButton.setVisible(state);
    }
    
}
