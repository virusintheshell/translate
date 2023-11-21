package translate;

/**
 *
 * @author virus
 */
public class Translate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var file = new fileManager();
        var object = new translateEngine();
       
        file.readFile();
        file.saveFile(file.getObject());

    }
    
}
