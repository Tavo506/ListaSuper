package listasuper;

import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.io.IOException;
import jxl.read.biff.BiffException;

/**
 * Clase de ayuda para manejar los excels
 * @author Andrés
 */
public class LeerExcel 
{
    private static final String EXCEL_FILE_LOCATION = "Ejemplo.xlsx";
    /**
     * Metodo para cargar los discos
     * @throws Exception
     */
    public static void leer(File file) throws IOException, BiffException
    {
        // Itera el folder de discos
//        File file = new File("Cadena.xls");
        {            
            // Obtiene la hoja de excel
            Workbook wb = Workbook.getWorkbook(file);
            
            // Obtiene la primera hoja
            Sheet sheet = wb.getSheet(0);
            
            // Itera las filas y columnas
            for (int i = 0; i < sheet.getRows(); i++) 
            {
                // Obtiene las propiedades
                String producto = sheet.getCell(0, i).getContents();
                if(!producto.isEmpty())
                    Principal.ListaProductos.add(producto);

                
            }
        }
        
    }
}
