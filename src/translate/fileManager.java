package translate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author virus
 */
public final class fileManager {
    private static String directoryName = System.getProperty("user.dir");
    private String objectPath;
    private static FileReader fr;
    private static BufferedReader br;
    private static BufferedWriter bw = null;
    private static PrintWriter pw = null;
    private static FileWriter fw = null;
    private Object obj;
    
    public fileManager(){
        this.objectPath = getPath();
        
    }
    
    public fileManager(Object obj){
        this.setObjcet(obj); 
        this.objectPath = getPath();
    }
    
    public void readFile(){
        
        try{
//            System.out.println("objectPath = " + objectPath);
            fr = new FileReader(new File(objectPath));
//            System.out.println("fr = " + fr);
            br = new BufferedReader(fr);
//            System.out.println("br = " + br);
            
            if(isFileExists(new File(this.objectPath)))
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
    
    //metodo que guarda el archivo
    public void saveFile(Object obj){
        System.out.println("obj = " + obj);
        
        String aux = String.valueOf(obj);
        System.out.println("aux = " + aux);
        try{
            pw = new PrintWriter(this.objectPath);
            pw.close();
            
            fw = new FileWriter(this.objectPath);
            bw = new BufferedWriter(fw);
            bw.write(aux);
            bw.close();
         
        }catch(IOException e){
           var texto = "error al guardar el archivo";
           procesaExcepcion(texto, e);
        }
    }
    
    //metodo que obtiene la ruta 
    public String getPath(){
         //Comprobamos el sistema operativo para traer el path
        String SysOp = System.getProperty("os.name");
        System.out.println("SysOp = " + SysOp.substring(0,7));
        
        //validamosla ruta para el sistemas
        if(SysOp.substring(0,7).equals("Windows")){
            this.objectPath =  directoryName+"\\src\\JSON\\object.txt";
        }else if(SysOp.substring(0,5).equals("Linux")){
            this.objectPath =  directoryName+"/src/JSON/object.txt";
        }else{
            System.out.println("error al encontra el archivo");
        }
        return this.objectPath;
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
