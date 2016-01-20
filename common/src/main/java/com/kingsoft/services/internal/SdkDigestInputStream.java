
package com.kingsoft.services.internal;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/**
 * Base class for KSC Java SDK specific {@link DigestInputStream}.
 */
public class SdkDigestInputStream extends DigestInputStream implements
        MetricAware, Releasable {
    private static final int SKIP_BUF_SIZE = 2*1024;
    public SdkDigestInputStream(InputStream stream, MessageDigest digest) {
        super(stream, digest);
    }

    @Override
    public final boolean isMetricActivated() {
        if (in instanceof MetricAware) {
            MetricAware metricAware = (MetricAware)in;
            return metricAware.isMetricActivated();
        }
        return false;
    }

    @Override
    public final long skip(final long n) throws IOException {
        if (n <= 0)
            return n;
        byte[] b = new byte[(int)Math.min(SKIP_BUF_SIZE, n)];
        long m = n; // remaining number of bytes to read
        while (m > 0) {
            int len = read(b, 0, (int)Math.min(m, b.length));
            if (len == -1)
                return (m == n) ? -1 : (n - m);
            m -= len;
        }
        assert (m == 0);
        return n;
    }

    @Override
    public final void release() {
        // Don't call IOUtils.release(in, null) or else could lead to infinite loop
        SdkIOUtils.closeQuietly(this);
        if (in instanceof Releasable) {
            // This allows any underlying stream that has the close operation
            // disabled to be truly released
            Releasable r = (Releasable)in;
            r.release();
        }
    }
}
