package com.minimaltests.myfacesminimaltests;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.Map;

@Log4j2
@Named
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
