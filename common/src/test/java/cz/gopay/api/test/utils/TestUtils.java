/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.gopay.api.test.utils;

import cz.gopay.api.v3.GPClientException;
import cz.gopay.api.v3.model.ErrorElement;
import java.util.List;
import junit.framework.Assert;
import org.apache.log4j.Logger;

/**
 *
 * @author František Sichinger
 */
public class TestUtils {

    public static final String API_URL = "https://gw.sandbox.gopay.com/api";
    public static final String CLIENT_ID = "1744960415";
    public static final String CLIENT_SECRET = "h9wyRz2s";
    public static final Long GOID = 8339303643L;

    public static void handleException(GPClientException e, Logger logger) {
        List<ErrorElement> errorMessages = e.getErrorMessages();
        StringBuilder builder = new StringBuilder();
        builder.append("E: ");
        for (ErrorElement element : errorMessages) {
            builder.append(element.getErrorName()).append(", ");
        }
        logger.fatal(builder.toString());
        Assert.fail(builder.toString());
    }
}
