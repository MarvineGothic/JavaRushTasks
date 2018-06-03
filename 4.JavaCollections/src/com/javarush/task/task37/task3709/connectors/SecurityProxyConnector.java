package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    private SecurityChecker securityChecker;
    private SimpleConnector simpleConnector;

    public SecurityProxyConnector(String string) {
        this.securityChecker = new SecurityCheckerImpl();
        this.simpleConnector = new SimpleConnector(string);
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck()) simpleConnector.connect();
    }
}
