package com.sergiubarsa.mybank;

import com.sergiubarsa.mybank.web.MyBankServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class ApplicationRunner {

    void main() throws LifecycleException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(getPort());
        tomcat.getConnector();

        Context ctx = tomcat.addContext("", null);
        Wrapper servlet = Tomcat.addServlet(ctx, "myBankServlet", new MyBankServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        tomcat.start();
    }

    private static int getPort() {
        String port = System.getProperty("server.port");
        if (port == null) {
            return 8080;
        }

        return Integer.parseInt(port);
    }
}
