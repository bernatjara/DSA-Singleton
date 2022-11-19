package edu.upc.dsa;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.ResourceBundle;
public class I18NManager {
    static final Logger logger = Logger.getLogger(I18NManager.class.getName());
    private static I18NManager i18n;
    HashMap<String,ResourceBundle> data;

    //Singleton
    public static I18NManager getInstance(){
        if(i18n == null){
            i18n = new I18NManager();
        }
        return i18n;
    }

    private I18NManager(){
        this.data=new HashMap<String,ResourceBundle>();
    }

    public void clear(){this.data.clear();}

    public String getText(String idioma,String l){
        logger.info("Lengua: "+ idioma +"linia: "+l);
        ResourceBundle rs = this.data.get(idioma);
        if(rs == null){
            logger.warn("No existe el .properties del ResourceBundle: "+idioma);
            rs = ResourceBundle.getBundle(idioma);
            this.data.put(idioma,rs);
            logger.info("Nuevo bundle añadido");
        }
        else logger.info("Este bundle ya existe");
        return rs.getString(l);
    }

}
