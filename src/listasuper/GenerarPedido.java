package listasuper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class GenerarPedido {

    public static void crear(String pedido, String nombre){
        try {
            String ruta;
            if(nombre.isEmpty())
                ruta = "Pedido.txt";
            else
                ruta = nombre + ".txt";
            String contenido = pedido;

            File file = new File(ruta);

            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
