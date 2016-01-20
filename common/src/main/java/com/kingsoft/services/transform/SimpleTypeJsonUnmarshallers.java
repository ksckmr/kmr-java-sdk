package com.kingsoft.services.transform;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import com.kingsoft.services.exception.KSCClientException;
import com.kingsoft.services.util.DateUtils;

public class SimpleTypeJsonUnmarshallers {
    /**
     * Unmarshaller for String values.
     */
    public static class StringJsonUnmarshaller implements Unmarshaller<String, JsonUnmarshallerContext> {
        public String unmarshall(JsonUnmarshallerContext unmarshallerContext) throws Exception {
            return unmarshallerContext.readText();
        }

        private static final StringJsonUnmarshaller instance = new StringJsonUnmarshaller();

        public static StringJsonUnmarshaller getInstance() {
            return instance;
        }
    }

    /**
     * Unmarshaller for Double values.
     */
    public static class DoubleJsonUnmarshaller implements Unmarshaller<Double, JsonUnmarshallerContext> {
        public Double unmarshall(JsonUnmarshallerContext unmarshallerContext) throws Exception {
            String doubleString = unmarshallerContext.readText();
            return (doubleString == null) ? null : Double.parseDouble(doubleString);
        }

        private static final DoubleJsonUnmarshaller instance = new DoubleJsonUnmarshaller();

        public static DoubleJsonUnmarshaller getInstance() {
            return instance;
        }
    }

    /**
     * Unmarshaller for Integer values.
     */
    public static class IntegerJsonUnmarshaller implements Unmarshaller<Integer, JsonUnmarshallerContext> {
        public Integer unmarshall(JsonUnmarshallerContext unmarshallerContext) throws Exception {
            String intString = unmarshallerContext.readText();
            return (intString == null) ? null : Integer.parseInt(intString);
        }

        private static final IntegerJsonUnmarshaller instance = new IntegerJsonUnmarshaller();

        public static IntegerJsonUnmarshaller getInstance() {
            return instance;
        }
    }

    public static class BigIntegerJsonUnmarshaller implements Unmarshaller<BigInteger, JsonUnmarshallerContext> {
        public BigInteger unmarshall(JsonUnmarshallerContext unmarshallerContext) throws Exception {
            String intString = unmarshallerContext.readText();
            return (intString == null) ? null : new BigInteger(intString);
        }

        private static final BigIntegerJsonUnmarshaller instance = new BigIntegerJsonUnmarshaller();

        public static BigIntegerJsonUnmarshaller getInstance() {
            return instance;
        }
    }

    public static class BigDecimalJsonUnmarshaller implements Unmarshaller<BigDecimal, JsonUnmarshallerContext> {
        public BigDecimal unmarshall(JsonUnmarshallerContext unmarshallerContext) throws Exception {
            String s = unmarshallerContext.readText();
            return (s == null) ? null : new BigDecimal(s);
        }

        private static final BigDecimalJsonUnmarshaller instance = new BigDecimalJsonUnmarshaller();

        public static BigDecimalJsonUnmarshaller getInstance() {
            return instance;
        }
    }

    /**
     * Unmarshaller for Boolean values.
     */
    public static class BooleanJsonUnmarshaller implements Unmarshaller<Boolean, JsonUnmarshallerContext> {
        public Boolean unmarshall(JsonUnmarshallerContext unmarshallerContext) throws Exception {
            String booleanString = unmarshallerContext.readText();
            return (booleanString == null) ? null : Boolean.parseBoolean(booleanString);
        }

        private static final BooleanJsonUnmarshaller instance = new BooleanJsonUnmarshaller();

        public static BooleanJsonUnmarshaller getInstance() {
            return instance;
        }
    }

    /**
     * Unmarshaller for Float values.
     */
    public static class FloatJsonUnmarshaller implements Unmarshaller<Float, JsonUnmarshallerContext> {
        public Float unmarshall(JsonUnmarshallerContext unmarshallerContext) throws Exception {
            String floatString = unmarshallerContext.readText();
            return (floatString == null) ? null : Float.valueOf(floatString);
        }

        private static final FloatJsonUnmarshaller instance = new FloatJsonUnmarshaller();

        public static FloatJsonUnmarshaller getInstance() {
            return instance;
        }
    }

    /**
     * Unmarshaller for Long values.
     */
    public static class LongJsonUnmarshaller implements Unmarshaller<Long, JsonUnmarshallerContext> {
        public Long unmarshall(JsonUnmarshallerContext unmarshallerContext) throws Exception {
            String longString = unmarshallerContext.readText();
            return (longString == null) ? null : Long.parseLong(longString);
        }

        private static final LongJsonUnmarshaller instance = new LongJsonUnmarshaller();

        public static LongJsonUnmarshaller getInstance() {
            return instance;
        }
    }

    /**
     * Unmarshaller for Byte values.
     */
    public static class ByteJsonUnmarshaller implements Unmarshaller<Byte, JsonUnmarshallerContext> {
        public Byte unmarshall(JsonUnmarshallerContext unmarshallerContext) throws Exception {
            String byteString = unmarshallerContext.readText();
            return (byteString == null) ? null : Byte.valueOf(byteString);
        }

        private static final ByteJsonUnmarshaller instance = new ByteJsonUnmarshaller();

        public static ByteJsonUnmarshaller getInstance() {
            return instance;
        }
    }

    /**
     * Unmarshaller for Date values - JSON dates come in as epoch seconds.
     */
    public static class DateJsonUnmarshaller implements Unmarshaller<Date, JsonUnmarshallerContext> {
        public Date unmarshall(JsonUnmarshallerContext unmarshallerContext)
                throws Exception {
            return DateUtils.parseServiceSpecificDate(unmarshallerContext
                    .readText());
        }

        private static final DateJsonUnmarshaller instance = new DateJsonUnmarshaller();

        public static DateJsonUnmarshaller getInstance() {
            return instance;
        }
    }


    /**
     * Unmarshaller for Character values.
     */
    public static class CharacterJsonUnmarshaller implements Unmarshaller<Character, JsonUnmarshallerContext> {
        public Character unmarshall(JsonUnmarshallerContext unmarshallerContext) throws Exception {
            String charString = unmarshallerContext.readText();

            if (charString == null) return null;

            charString = charString.trim();
            if (charString.isEmpty() || charString.length() > 1)
                throw new KSCClientException("'" + charString
                        + "' cannot be converted to Character");
            return Character.valueOf(charString.charAt(0));
        }

        private static final CharacterJsonUnmarshaller instance = new CharacterJsonUnmarshaller();

        public static CharacterJsonUnmarshaller getInstance() {
            return instance;
        }
    }

    /**
     * Unmarshaller for Short values.
     */
    public static class ShortJsonUnmarshaller implements Unmarshaller<Short, JsonUnmarshallerContext> {
        public Short unmarshall(JsonUnmarshallerContext unmarshallerContext) throws Exception {
            String shortString = unmarshallerContext.readText();
            return (shortString == null) ? null : Short.valueOf(shortString);
        }

        private static final ShortJsonUnmarshaller instance = new ShortJsonUnmarshaller();

        public static ShortJsonUnmarshaller getInstance() {
            return instance;
        }
    }
}
