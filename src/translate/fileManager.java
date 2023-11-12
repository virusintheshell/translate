package translate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author virus
 */
public final class fileManager {
    private static String directoryName = System.getProperty("user.dir");
    private static String objectPath = directoryName+"\\src\\JSON\\object.txt";
    private static FileReader fr;
    private static BufferedReader br;
    private Object obj;
    
    public fileManager(){
        
    }
    
    public fileManager(Object obj){
        this.setObjcet(obj);
    }
    
    public void readFile(){
        try{
//            System.out.println("objectPath = " + objectPath);
            fr = new FileReader(new File(objectPath));
//            System.out.println("fr = " + fr);
            br = new BufferedReader(fr);
//            System.out.println("br = " + br);
            
            if(isFileExists(new File(objectPath)))
                System.out.println("El archivo existe");
            
            JSONParser  parser = new JSONParser();
            
            this.setObjcet(parser.parse(fr));
            
            fr.close();
            
        }catch(IOException e){
           var texto = "el archivo no existe: ";
           procesaExcepcion(texto, e);
        }catch (ParseException ex) {
//            Logger.getLogger(translateEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object getObject(){
        return this.obj;
    }
    public Object setObjcet(Object param){
        return this.obj = param;
    }

    //region validation methods
            // Método para verificar si el archivo existe y no es un directorio
            public static boolean isFileExists(File file) {
                return file.exists() && !file.isDirectory();
            }
            // hacer cosas para procesar la excepcion
            public static void procesaExcepcion(String texto,IOException e) {
                System.out.println(texto + ": "+ e);
            }
    //endregion
}
