package org.gisela.dacd.businessunit;

import org.gisela.dacd.businessunit.infrastructure.*;
import java.io.IOException;
import static org.gisela.dacd.businessunit.infrastructure.HttpServer.startHttpServer;
import static org.gisela.dacd.businessunit.infrastructure.SubscribersSetup.initializeSubscribers;

public class Main {

    public static void main(String[] args) throws IOException {
        SQLiteConnector.createNewTable();
        initializeSubscribers();
        startHttpServer();
    }
}
