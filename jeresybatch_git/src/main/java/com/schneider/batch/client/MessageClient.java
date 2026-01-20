package com.schneider.batch.client;

import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.spi.Connector;
import org.glassfish.jersey.client.spi.ConnectorProvider;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Configuration;

public final class MessageClient {

    private static final MessageClient INSTANCE = new MessageClient();

    public final Client client;

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(ServerSideConnector.class);

    public MessageClient() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.property(ClientProperties.READ_TIMEOUT, 2000);
        clientConfig.property(ClientProperties.CONNECT_TIMEOUT, 500);

        PoolingClientConnectionManager connectionManager = new PoolingClientConnectionManager();
        connectionManager.setMaxTotal(100);
        connectionManager.setDefaultMaxPerRoute(20);

         // uncomment these two lines and comment out line 40 to use HTTP Client instead
        //clientConfig.property(ApacheClientProperties.CONNECTION_MANAGER, connectionManager);
       // ApacheConnector connector = new ApacheConnector(clientConfig);


        ConnectorProvider provider = new ConnectorProvider() {
            @Override
            public Connector getConnector(Client client, Configuration configuration) {

                return ServerConnectorProvider.ServerConnectorFactory.build();
            }
        };

         clientConfig.connectorProvider(provider);
        client = ClientBuilder.newClient(clientConfig);
        client.register(JacksonFeature.class);
    }

    /*public static List<Product> get() {
        long start = System.currentTimeMillis();

        try {
            return INSTANCE.client.target("http://localhost:8080/jeresybatch/rest").path("/products")
                    .request(MediaType.APPLICATION_JSON).get(new GenericType<List<Product>>(){});

        } finally {
            LOG.info("Time elapsed (get): " + (System.currentTimeMillis() - start) + "ms");

        }
    }*/

   /* public static void put(String name, List<Product> messages) {
        Response response = INSTANCE.client.target("http://localhost:8080/myapp").path("messages/" + name)
                .request(MediaType.APPLICATION_JSON).put(Entity.entity(messages, MediaType.APPLICATION_JSON));
        if (response.getStatus() != 200) {
            throw new RuntimeException("Response was " + response.getStatus());
        }
    }
*/
   /* public static void main(String[] args) {
        new MessageClient();
        System.out.println(MessageClient.get());
    }*/
}