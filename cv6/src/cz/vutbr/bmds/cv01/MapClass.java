package cz.vutbr.bmds.cv01;

import java.util.HashMap;

public class MapClass {
    private HashMap<Integer,String> field = new HashMap<>();

    public void store(Integer id, String value) throws ArrayStoreException{

            if(field.containsKey(id)) {
                throw new ArrayStoreException("Key is already present");
            }
            else{
                    field.put(id, value);
            }
    }

    public String getValue(Integer id) throws NoSuchFieldException{
        if(!field.containsKey(id)){
            throw new NoSuchFieldException("No pair found");
        }
        else{
            return field.get(id);
        }

    }

    public void deleteKey(Integer id) throws  NoSuchFieldException{
        if(!field.containsKey(id)){
            throw new NoSuchFieldException("No pair found");
        }
        else{
            field.remove(id);
        }

    }

    public int getSize(){
        return field.size();
    }

    public void print(){
       for (var entry : field.entrySet()) {
           System.out.println(entry.getKey() + "->" + entry.getValue());
       }
    }


}
