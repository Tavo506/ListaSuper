package listasuper;

import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import jxl.read.biff.BiffException;

/**
 * Clase de ayuda para manejar los excels
 * @author Andrés
 */
public class LeerExcel 
{
    /**
     * Metodo para cargar los discos
     * @param file
     * @throws java.io.IOException
     * @throws jxl.read.biff.BiffException
     */
    public static void leer(File file) throws IOException, BiffException{            
        // Obtiene la hoja de excel
        Workbook wb = Workbook.getWorkbook(file);

        // Obtiene la primera hoja
        Sheet sheet = wb.getSheet(0);

        // Itera las filas para leer los productos
        for (int i = 0; i < sheet.getRows(); i++) 
        {
            // Obtiene las propiedades
            String producto = sheet.getCell(0, i).getContents();
            if(!producto.isEmpty())
                Principal.ListaProductos.add(producto);

        }
    }
    
    public static void update(File file, JPanel panel) throws IOException, BiffException{
        // Obtiene la hoja de excel
        Workbook wb = Workbook.getWorkbook(file);

        // Obtiene la primera hoja
        Sheet sheet = wb.getSheet(0);

        // Itera las filas para leer los productos
        for (int i = 0, j = 0; i < sheet.getRows(); i++, j++) 
        {
            // Obtiene las propiedades
            String producto = sheet.getCell(0, i).getContents();
            if(!producto.isEmpty() && !Principal.ListaProductos.contains(producto)){
                try{
                    Principal.ListaProductos.add(j, producto);
                    Principal.Productos.add(j, new Producto(producto, panel));
                }catch(Exception e){
                    Principal.ListaProductos.add(producto);
                    Principal.Productos.add(new Producto(producto, panel));
                }
                j++;
            }
        }
    }
}