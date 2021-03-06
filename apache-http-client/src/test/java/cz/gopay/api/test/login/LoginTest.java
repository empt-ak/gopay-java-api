package cz.gopay.api.test.login;

import cz.gopay.api.test.utils.TestUtils;
import cz.gopay.api.v3.GPClientException;
import cz.gopay.api.v3.IGPConnector;
import junit.framework.Assert;

import org.apache.log4j.Logger;

import cz.gopay.api.v3.impl.apacheclient.HttpClientGPConnector;
import org.junit.Test;

public class LoginTest {

    private static final Logger logger = Logger.getLogger(LoginTest.class);

    @Test
    public void testAuthApacheHttpClient() {
        try {
            IGPConnector connector = HttpClientGPConnector.build(TestUtils.API_URL).getAppToken(TestUtils.CLIENT_ID, TestUtils.CLIENT_SECRET);
            Assert.assertNotNull(connector.getAccessToken());
        } catch (GPClientException ex) {
            TestUtils.handleException(ex, logger);
        }
    }
}
