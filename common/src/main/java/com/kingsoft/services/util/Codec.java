
package com.kingsoft.services.util;

/**
 * Codec SPI
 */
interface Codec {
    public byte[] encode(byte[] src);
    public byte[] decode(byte[] src, final int length); 
}