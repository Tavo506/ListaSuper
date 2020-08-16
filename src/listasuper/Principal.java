/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasuper;

import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Locale.filter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import jxl.read.biff.BiffException;

/**
 *
 * @author tavob
 */
public class Principal extends javax.swing.JFrame {
    
    public static Image menos;
    public static Image mas;
    private boolean excelCargado = false;
    public static ArrayList<String> ListaProductos = new ArrayList<>(); //Lista con los strings de los productos
    ArrayList<Producto> Productos = new ArrayList<>();  //Lista de productos
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            menos = ImageIO.read(getClass().getResource("/Imagenes/menos.png"));
            mas = ImageIO.read(getClass().getResource("/Imagenes/mas.png"));
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        ScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
    }
    

    void busqueda(){
        if(excelCargado){
            String busqueda = textBusqueda.getText();
            int row = 0;
            for(Producto p : Productos){
                if(p.LIKE(busqueda)){
                    //System.out.println(p.getName());
                    p.setRow(row*30);
                    row++;
                    p.setVisible(true);
                }else{
                    p.setVisible(false);
                }
            }
            if(row >= 17){
                ScrollPane.setPreferredSize(new java.awt.Dimension(439, 448));
                Panel.setPreferredSize(new java.awt.Dimension(439, 30*(row)+10));
                ScrollPane.getVerticalScrollBar().setValue(0);
            }else{
                ScrollPane.setPreferredSize(new java.awt.Dimension(439, 448));
                Panel.setPreferredSize(new java.awt.Dimension(439, 440));
        }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonGenerarPedido = new javax.swing.JButton();
        ScrollPane = new javax.swing.JScrollPane();
        Panel = new javax.swing.JPanel();
        BotonCargar = new javax.swing.JButton();
        LabelInstruccion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textBusqueda = new javax.swing.JTextField();
        NombrePedido = new javax.swing.JTextField();
        BarraMenu = new javax.swing.JMenuBar();
        MenuOpciones = new javax.swing.JMenu();
        MenuCargar = new javax.swing.JMenuItem();
        LimpiarPedido = new javax.swing.JMenuItem();
        CargarPedido = new javax.swing.JMenuItem();
        MenuAyuda = new javax.swing.JMenuItem();
        MenuAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generador de Pedidos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonGenerarPedido.setBackground(new java.awt.Color(0, 102, 255));
        BotonGenerarPedido.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        BotonGenerarPedido.setForeground(new java.awt.Color(255, 255, 255));
        BotonGenerarPedido.setText("Generar Pedido");
        BotonGenerarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGenerarPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(BotonGenerarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 516, 439, -1));

        ScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPane.setPreferredSize(new java.awt.Dimension(438, 448));

        Panel.setPreferredSize(new java.awt.Dimension(430, 440));

        BotonCargar.setBackground(new java.awt.Color(0, 153, 0));
        BotonCargar.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        BotonCargar.setText("Cargar Archivo");
        BotonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCargarActionPerformed(evt);
            }
        });

        LabelInstruccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelInstruccion.setText("Para cargar más archivos en Opciones -> Cargar Excel");

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(LabelInstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(BotonCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(LabelInstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        ScrollPane.setViewportView(Panel);

        getContentPane().add(ScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        jLabel1.setText("Nombre del Pedido Generado :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 190, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("🔎");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        textBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBusquedaActionPerformed(evt);
            }
        });
        getContentPane().add(textBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 230, -1));
        getContentPane().add(NombrePedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 230, 30));

        MenuOpciones.setText("Opciones");

        MenuCargar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        MenuCargar.setText("Cargar Excel");
        MenuCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCargarActionPerformed(evt);
            }
        });
        MenuOpciones.add(MenuCargar);

        LimpiarPedido.setText("Limpiar Pedido");
        LimpiarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarPedidoActionPerformed(evt);
            }
        });
        MenuOpciones.add(LimpiarPedido);

        CargarPedido.setText("Cargar Pedido");
        CargarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarPedidoActionPerformed(evt);
            }
        });
        MenuOpciones.add(CargarPedido);

        MenuAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        MenuAyuda.setText("Ayuda");
        MenuAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAyudaActionPerformed(evt);
            }
        });
        MenuOpciones.add(MenuAyuda);

        MenuAcercaDe.setText("Acerca de");
        MenuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAcercaDeActionPerformed(evt);
            }
        });
        MenuOpciones.add(MenuAcercaDe);

        BarraMenu.add(MenuOpciones);

        setJMenuBar(BarraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Abre la ventana de Acerca de
    private void MenuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAcercaDeActionPerformed
        new AcercaDe().setVisible(true);
    }//GEN-LAST:event_MenuAcercaDeActionPerformed

    //Abre la ventana de ayuda
    private void MenuAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAyudaActionPerformed
        new Instrucciones().setVisible(true);
    }//GEN-LAST:event_MenuAyudaActionPerformed

    //Llama la funcion para cargar excel
    private void MenuCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCargarActionPerformed
        cargarExcel();
        
    }//GEN-LAST:event_MenuCargarActionPerformed
    
    //Seleccionar el archivo excel para el pedido
    public void cargarExcel(){
        JFileChooser Buscador = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());    //Abre el buscador de archivos
        
        Buscador.setAcceptAllFileFilterUsed(false);
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Libro Excel", "xls");  //Solo acepta el tipo de archivo .xls
        Buscador.addChoosableFileFilter(filter);    //Agrega el filtro al buscador
        
        File selectedFile = null;   //Inicializa el archivo en null
        
        int returnValue = Buscador.showOpenDialog(null);
        if (returnValue == Buscador.APPROVE_OPTION) {   //Si se selecciona un archivo valido...
            selectedFile = Buscador.getSelectedFile();  //este se guarda
        }
        
        //Limpia las listas de productos ************************
        ListaProductos = new ArrayList<>();
        Productos = new ArrayList<>();
        //*******************************************************
        
        Panel.removeAll();  //Limpia la interfaz
        Panel.repaint();    //Refresca la interfaz
        
        try {
            if(selectedFile != null){   //Si el File no es null...
                LeerExcel.leer(selectedFile);   //Se lee el excel y se carga a la interfaz
                BotonCargar.setVisible(false);  //Desaparese el boton de cargar archivo cuando no hay nada
                LabelInstruccion.setVisible(false); //Desaparece el texto de instruccion para cargar archivos
                excelCargado = true;
            }else{  //Si no se selecciono nada...
                BotonCargar.setVisible(true);   //Muestra el boton de inicio
                LabelInstruccion.setVisible(true);  //Muestra el texto instruccion
                excelCargado = false;
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Carga los pruductos en la interfaz
        int j = 0;
        for(int i = 0; i < ListaProductos.size(); i++){
            Productos.add(new Producto(ListaProductos.get(i), i*30, Panel));
            j = i;
            /*
            ListaLabels.add(new JLabel(ListaProductos.get(i))); //Crea un label con el nombre
            ListaLabels.get(i).setForeground(Color.black);
            ListaLabels.get(i).setSize(150, 150);
            
            ListaTextFields.add(new JTextField());  //Agrega el label al panel
//            ListaTextFields.get(i).setFocusable(true);
            
            
            Panel.add(ListaLabels.get(i));
            Panel.add(ListaTextFields.get(i));
            */
            
        }
        if(j+1 >= 17){
            ScrollPane.setPreferredSize(new java.awt.Dimension(439, 448));
            Panel.setPreferredSize(new java.awt.Dimension(439, 30*(j+1)+10));
            ScrollPane.getVerticalScrollBar().setValue(0);
        }else{
            ScrollPane.setPreferredSize(new java.awt.Dimension(439, 448));
            Panel.setPreferredSize(new java.awt.Dimension(439, 440));
        }
        
        Panel.updateUI();
        
    }
    
    //Genera el txt con el pedido
    private void BotonGenerarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGenerarPedidoActionPerformed
        if(excelCargado){
        
            String pedido = ""; //Se declara un string que sera la lista que se pondra en el txt
            String producto;
            
            for(Producto p : Productos){    //Recorre los productos
                producto = p.getCant();     //Guarda la cantidad de productos
                
                if(!producto.trim().isEmpty()){ //Revisa que haya texto
                    
                    if(isNumeric(producto) && Integer.parseInt(producto) >= 0){  //Revisa que sea numerico y mayor a 0, sino muestra que valor inválido
                            if(Integer.parseInt(producto) > 0){ //Revisa que sea mayor a 0
                                pedido += producto + " : "  + p.getName() + "\n";   //Agrega el producto a pedido
                            }
                    }else{
                        ScrollPane.getVerticalScrollBar().setValue(p.getRow()); //Mueve la pantalla donde está el error
                        p.raiseAlert();     //Marca la casilla en rojo
                        JOptionPane.showMessageDialog(this, "Valor inválido en " + p.getName(), "Alerta", 1);
                        p.cleanAlert();     //Vuelve la casilla blanca
                        return;
                    }
                }
            }
            
            if(pedido.isEmpty()){
                JOptionPane.showMessageDialog(this,
                "No ha elegido ningun producto, \nno hay un pedido que crear",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String nombre = NombrePedido.getText(); //variable que contiene el nombre para el txt
            if(nombre.trim().isEmpty())    //Si el nombre esta en blanco o son solo espacios...
                nombre = "Pedido";                  //...pone el nombre "Pedido" por defecto
            GenerarPedido.crear(pedido, nombre);    //Se crea el txt
            
            String ruta = "la ruta del programa";
            try {
                ruta = new File(".").getCanonicalPath();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //Si el pedido se genero bien se le indica al usuario
            JOptionPane.showMessageDialog(this, 
            "Pedido generado exitosamente en " + ruta +"\n con el nombre \"" + nombre + "\"");
        
        }else{  //Si no hay un excel para crear un pedido se le indica al usuario
            JOptionPane.showMessageDialog(this,
            "No hay ningun excel cargado para generar un pedido",
            "Advertencia",
            JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BotonGenerarPedidoActionPerformed

    //Llama la funcion para cargar excel
    private void BotonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCargarActionPerformed
        cargarExcel();
    }//GEN-LAST:event_BotonCargarActionPerformed

    //Limpia el pedido para hacerlo desde 0
    private void LimpiarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarPedidoActionPerformed
        LimpiarTodo();
    }//GEN-LAST:event_LimpiarPedidoActionPerformed

    private void LimpiarTodo(){
        for(Producto p : Productos){
            p.setCant("");
        }
        Panel.repaint();    //Refresca la interfaz
    }
    
    //Cargar un pedido existente para continuarlo o modificarlo de forma mas sencilla
    private void CargarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarPedidoActionPerformed
        if(!excelCargado){
            JOptionPane.showMessageDialog(this,
            "No hay ningun excel cargado como para cargar un pedido",
            "Advertencia",
            JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        JFileChooser Buscador = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());    //Abre el buscador de archivos
        
        Buscador.setAcceptAllFileFilterUsed(false);
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Pedido Existente .txt", "txt");  //Permite solo txt (Pedidos generados)
        Buscador.addChoosableFileFilter(filter);    //Agrega el filtro al buscador
        
        File selectedFile = null;   //Inicializa el archivo en null
        
        int returnValue = Buscador.showOpenDialog(null);
        if (returnValue == Buscador.APPROVE_OPTION) {   //Si se selecciona un archivo valido...
            selectedFile = Buscador.getSelectedFile();  //este se guarda
        }
        
        try {
            if(selectedFile != null){   //Si el File no es null...
                String textoPedido = leer(selectedFile);
                
                if(!"".equals(textoPedido)){
                    NombrePedido.setText(selectedFile.getName().replace(".txt", ""));
                    String[] productosYCantidad = textoPedido.split(";");
                    LimpiarTodo();
                    for (String p : productosYCantidad) {
                        String producto = p.split(":")[1];
                        String cantidad = p.split(":")[0];
                        System.out.println(p);
                        producto = producto.substring(1, producto.length());
                        cantidad = cantidad.substring(0,cantidad.length()-1);
                        if(ListaProductos.contains(producto)){
                            Productos.get(ListaProductos.indexOf(producto)).setCant(cantidad);
                        }
                    }
                }
                        
            }else{  //Si no se selecciono nada...
                
            }
            
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_CargarPedidoActionPerformed

    private void textBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBusquedaActionPerformed
        busqueda();
    }//GEN-LAST:event_textBusquedaActionPerformed

    //Funcion que lee el pedido existente (txt)
    public static String leer(File archivo){
        
        String texto = "";
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            //System.out.println("Leyendo el contendio del archivo.txt");
            String linea;
            int cont = 0;
            while((linea=br.readLine())!=null){
                if(cont < 4){
                    cont++;
                    continue;
                }
                if("".equals(texto))
                    texto += linea;
                else
                    texto += ";" + linea;
               //System.out.println(linea);
            }
        }

        catch(Exception e){
            e.printStackTrace();
            return "";

        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
               
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
                return "";
            }
        }
        //System.out.println(texto);
        return texto;
    }
    
    //Funcion para verificar que una cadena es numerica
    public static boolean isNumeric(String str) { 
        try {  
            Integer.parseInt(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }  
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JButton BotonCargar;
    private javax.swing.JButton BotonGenerarPedido;
    private javax.swing.JMenuItem CargarPedido;
    private javax.swing.JLabel LabelInstruccion;
    private javax.swing.JMenuItem LimpiarPedido;
    private javax.swing.JMenuItem MenuAcercaDe;
    private javax.swing.JMenuItem MenuAyuda;
    private javax.swing.JMenuItem MenuCargar;
    private javax.swing.JMenu MenuOpciones;
    private javax.swing.JTextField NombrePedido;
    private javax.swing.JPanel Panel;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField textBusqueda;
    // End of variables declaration//GEN-END:variables
}
