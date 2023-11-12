package translate;

import org.json.simple.JSONArray;

/**
 *
 * @author virus
 */
public class translateEngine {
    private JSONArray jsonarray;
    private fileManager fm;
    
    public translateEngine(){
        
    }
    
    public JSONArray translateGetList(){      
        fm.readFile();
        
//        jsonarray = (JSONArray)objFile.readFile();
        jsonarray = (JSONArray)fm.getObject();
        return jsonarray;
    }
    
}
