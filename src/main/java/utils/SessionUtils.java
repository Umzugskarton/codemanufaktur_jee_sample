package utils;

import org.hibernate.Session;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.util.Map;

public class SessionUtils {

    public static Session getSession() {
        return (Session) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }

    public static ExternalContext getExternalContext(){
        return FacesContext.getCurrentInstance().getExternalContext();
    }

    public static Map<String, Object> getSessionMap(){
        return getExternalContext().getSessionMap();
    }
}
