package com.kingsoft.services.util;

import com.kingsoft.services.exception.KSCClientException;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.math.BigDecimal;

public class DateUtils {

	private static final int KSC_DATE_MILLI_SECOND_PRECISION = 3;

	private static DateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private static final DateTimeFormatter dateFormatter = DateTimeFormat
			.forPattern("yyyyMMdd").withZoneUTC();

	private static final DateTimeFormatter timeFormatter = DateTimeFormat
			.forPattern("yyyyMMdd'T'HHmmss'Z'").withZoneUTC();

	public static String formatTimestamp(long timeMilli) {
		return timeFormatter.print(timeMilli);
	}

	public static String formatDateStamp(long timeMilli) {
		return dateFormatter.print(timeMilli);
	}

	public static String format(Date date) {
		return dateFormat.format(date);
	}

	public static Date parse(String value) throws ParseException {
		return dateFormat.parse(value);
	}

	public static String getTimeNow() {
		return format(Calendar.getInstance().getTime());
	}

	public static Date parseServiceSpecificDate(String dateString) {
		if (dateString == null)
		    return null;
		try {
		    BigDecimal dateValue = new BigDecimal(dateString);
		    return new Date(dateValue.scaleByPowerOfTen(
			    KSC_DATE_MILLI_SECOND_PRECISION).longValue());
		} catch (NumberFormatException nfe) {
		    throw new KSCClientException("Unable to parse date : "
			    + dateString, nfe);
		}
	}

	public static String formatServiceSpecificDate(Date date) {
        if (date == null)
            return null;
        BigDecimal dateValue = BigDecimal.valueOf(date.getTime());
        return dateValue.scaleByPowerOfTen(0 - KSC_DATE_MILLI_SECOND_PRECISION)
                .toPlainString();
    }



}
