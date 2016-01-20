package com.kingsoft.services.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * Utilities for IO operations.
 */
public enum IOUtils {
    ;
    private static final int BUFFER_SIZE = 1024 * 4;
    private static final Log defaultLog = LogFactory.getLog(IOUtils.class);

    /**
     * Reads and returns the rest of the given input stream as a byte array.
     * Caller is responsible for closing the given input stream.
     */
    public static byte[] toByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            byte[] b = new byte[BUFFER_SIZE];
            int n = 0;
            while ((n = is.read(b)) != -1) {
                output.write(b, 0, n);
            }
            return output.toByteArray();
        } finally {
            output.close();
        }
    }

    /**
     * Reads and returns the rest of the given input stream as a string.
     * Caller is responsible for closing the given input stream.
     */
    public static String toString(InputStream is) throws IOException {
        return new String(toByteArray(is), StringUtils.UTF8);
    }

    /**
     * Closes the given Closeable quietly.
     * @param is the given closeable
     * @param log logger used to log any failure should the close fail
     */
    public static void closeQuietly(Closeable is, Log log) {
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


    /**
     * Copies all bytes from the given input stream to the given output stream.
     * Caller is responsible for closing the streams.
     * 
     * @throws IOException
     *             if there is any IO exception during read or write.
     */
    public static long copy(InputStream in, OutputStream out)
            throws IOException {
        byte[] buf = new byte[BUFFER_SIZE];
        long count = 0;
        int n = 0;
        while ((n = in.read(buf)) > -1) {
            out.write(buf, 0, n);
            count += n;
        }
        return count;
    }
}
