
package com.kingsoft.services.internal;

import java.io.Closeable;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Utilities for IO operations.
 */
enum SdkIOUtils {
    ;
    private static final Log defaultLog = LogFactory.getLog(SdkIOUtils.class);

    static void closeQuietly(Closeable is) {
        closeQuietly(is, null);
    }
    /**
     * Closes the given Closeable quietly.
     * @param is the given closeable
     * @param log logger used to log any failure should the close fail
     */
    static void closeQuietly(Closeable is, Log log) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException ex) {
                Log logger = log == null ? defaultLog : log;
                if (logger.isDebugEnabled())
                    logger.debug("Ignore failure in closing the Closeable", ex);
            }
        }
    }
}
