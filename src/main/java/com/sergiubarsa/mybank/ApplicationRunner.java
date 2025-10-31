package com.sergiubarsa.mybank;

import com.sergiubarsa.mybank.context.ApplicationConfiguration;
import com.sergiubarsa.mybank.web.MyBankServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationRunner {

    void main() throws LifecycleException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(getPort());
        tomcat.getConnector();

        Context ctx = tomcat.addContext("", null);

        Wrapper servlet = Tomcat.addServlet(ctx, "myDispatcherServlet", new DispatcherServlet(getCtx()));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        tomcat.start();
    }

    AnnotationConfigWebApplicationContext getCtx() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(ApplicationConfiguration.class);

        return ctx;
    }

    private static int getPort() {
        String port = System.getProperty("server.port");
        if (port == null) {
            return 8080;
        }

        return Integer.parseInt(port);
    }
}
