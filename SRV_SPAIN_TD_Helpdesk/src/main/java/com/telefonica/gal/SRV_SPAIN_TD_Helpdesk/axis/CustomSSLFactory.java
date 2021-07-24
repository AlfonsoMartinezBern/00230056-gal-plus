package com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.axis;

import java.io.IOException;
import java.security.KeyStore;
import java.util.Hashtable;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.apache.axis.components.net.JSSESocketFactory;
import org.apache.axis.components.net.SecureSocketFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class CustomSSLFactory extends JSSESocketFactory implements SecureSocketFactory{

    private String KEYSTORE_PWD = "Entelgy_Gal";
    private Resource KEYSTORE_RESOURCE = new ClassPathResource("keystore/gal.keystore");

    public CustomSSLFactory(Hashtable attributes) {
        super(attributes);
    }

    @Override
    protected void initFactory() throws IOException {
        try {
            SSLContext context = getSslContext();
            sslFactory = context.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SSLContext getSslContext() throws Exception {
        try {
            KeyStore keyStore = KeyStore.getInstance("jks");
            keyStore.load(KEYSTORE_RESOURCE.getInputStream(), KEYSTORE_PWD.toCharArray());

            TrustManagerFactory tmf =  TrustManagerFactory.getInstance(
                    TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keyStore);

            final SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
            sslContext.init(null, tmf.getTrustManagers(), null);
            return sslContext;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
}
