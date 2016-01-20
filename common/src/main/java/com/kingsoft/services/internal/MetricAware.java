
package com.kingsoft.services.internal;

/**
 * Used to check if any metrics gathering activity is already turned on in one
 * of the underlying wrapped objects.
 */
public interface MetricAware {
    /**
     * Returns true if this object or one of it's inner wrapped objects has
     * metrics gathering activity turned on; false otherwise.
     */
    public boolean isMetricActivated();
}
