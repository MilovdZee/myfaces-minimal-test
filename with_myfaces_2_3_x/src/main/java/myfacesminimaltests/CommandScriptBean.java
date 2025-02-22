package com.minimaltests.myfacesminimaltests;

import lombok.extern.log4j.Log4j2;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Map;

@Log4j2
@ManagedBean
@SessionScoped
public class CommandScriptBean implements Serializable {
    public String getButtonName() {
        log.info("getButtonName");

        return "button";
    }

    public void commandScript() {
        log.info("CommandScriptBean");

        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        Map<String, String> requestParameterMap = ec.getRequestParameterMap();
        log.info("Passed value: 'test'='{}'", requestParameterMap.get("test"));
    }
}
