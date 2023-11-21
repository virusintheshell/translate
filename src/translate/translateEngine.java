package translate;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author virus
 */
public class translateEngine {
    private JSONArray jsonarray;
    private fileManager fm;
    
    public translateEngine(){
 
    }
    
    //obtenemos el arregloa 
    public JSONArray translateGetList(){      
        fm = new fileManager();
        fm.readFile();
        jsonarray = (JSONArray)fm.getObject();
        return jsonarray;
    }
    
    //region manejos de los objecto
    public void insertObject(String text, String translate){
        fm = new fileManager();
        
        jsonarray = this.translateGetList();
        //System.out.println("jsonarray = " + jsonarray);
        
        int getLastObject = (int)jsonarray.size(); 
        //System.out.println(getLastObject);
//        
//        JSONObject jsonObject = (JSONObject)jsonarray.get(getLastObject-1);
//        System.out.println("jsonObject = " + jsonObject);
//        
//        int lastID = ((Long)jsonObject.get("id")).intValue();
//        System.out.println("lastID = " + lastID);
//        
//        JSONObject newJsonObject = new JSONObject();
//        newJsonObject.put("id",lastID+1);
//        newJsonObject.put("text",text);
//        newJsonObject.put("translate",translate);
//        System.out.println("newObject ="+newJsonObject);
//        
//        jsonarray.add(newJsonObject);
//        System.out.println("jsonarray = " + jsonarray);
//        
//        var obj = (Object)jsonarray;
//        System.out.println(obj);
//        
//        objFile.saveFile(obj);
        
        
        
    }
    //endregion
}
