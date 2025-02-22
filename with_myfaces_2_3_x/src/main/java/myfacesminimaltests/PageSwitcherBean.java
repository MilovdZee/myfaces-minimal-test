package com.minimaltests.myfacesminimaltests;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@Log4j2
@ManagedBean
@SessionScoped
public class PageSwitcherBean implements Serializable {
    @SneakyThrows
    public String toPage1() {
        log.info("toPage1");
        Thread.sleep(1000);
        return "page1";
    }

    @SneakyThrows
    public String toPage2() {
        log.info("toPage2");
        Thread.sleep(1000);
        return "page2";
    }
}
