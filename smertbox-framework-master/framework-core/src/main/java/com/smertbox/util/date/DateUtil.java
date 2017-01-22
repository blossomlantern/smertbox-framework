package com.smertbox.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期对象处理公共类。
 */
public class DateUtil {

	public static String defaultPattern = "yyyy-MM-dd";
	public static String defaultTimePattern = "yyyy-MM-dd HH:mm:ss";

	public enum DateUom {
		Year, Month, Day, Hour, Minute, Second
	}
	
	/**
	 * 获得当前时间字符串——"yyyy-MM-dd"
	 */
	public static String currentStrDate() {
		return new SimpleDateFormat(defaultPattern).format(System.currentTimeMillis());
	}
	
	/**
	 * 获得当前时间字符串——"yyyy-MM-dd HH:mm:ss"
	 */
	public static String currentStrTime() {
		return new SimpleDateFormat(defaultTimePattern).format(System.currentTimeMillis());
	}
	
	/**
	 * 获得当前日期——"yyyy-MM-dd"
	 */
	public static Date currentDate() throws ParseException {
		SimpleDateFormat formatter = null;
		formatter = new SimpleDateFormat(defaultPattern);
		return formatter.parse(formatter.format(System.currentTimeMillis()));
	}

	public String currentDate(DateUom uom) throws Exception {
		String currDate = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
		String[] date = currDate.split("-");
		switch (uom) {
		case Year:
			return date[0];
		case Month:
			return date[1];
		case Day:
			return date[2];
		default:
			return currDate;
		}
	}

	/**
	 * 获得表示 当前时间 的字符串 指定格式
	 */
	public static String currentDate(String formatStr) {
		return new SimpleDateFormat(formatStr).format(System.currentTimeMillis());
	}

	/**
	 * 获得表示 当前时间 的字符串 格式:"yyyy-MM-dd HH:mm:ss"
	 */
	public static String currentTime() {
		return new SimpleDateFormat(defaultTimePattern).format(System.currentTimeMillis());
	}

	/**
	 * 获得表示 指定时间 的字符串 格式: "yyyy-MM-dd"
	 */
	public static String format(Date date) {
		String str = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(defaultPattern);
			str = sdf.format(date);
		} catch (Exception ex) {
		}
		return str;
	}

	/**
	 * 格式化日期类型显示
	 */
	public static String format(Date date, String param) {
		String value = date.toString();
		try {
			SimpleDateFormat df = new SimpleDateFormat(param);
			value = df.format(date);
		} catch (Exception e) {
		}
		return value;
	}

	/**
	 * 解析字符串为日期型
	 */
	public static Date getDate(String string) throws ParseException {
		Date date = null;
		SimpleDateFormat formatter = null;
		if (string.indexOf(":") > 0)
			formatter = new SimpleDateFormat(defaultTimePattern);
		else
			formatter = new SimpleDateFormat(defaultPattern);
		try {
			date = formatter.parse(string);
		} catch (Exception e) {
		}
		return date;
	}

	/**
	 * 解析字符串为SQL日期型
	 */
	public static Date getSqlDate(String string) {
		try {
			if (string.indexOf(":") > 0)
				return java.sql.Timestamp.valueOf(string);
			else
				return java.sql.Date.valueOf(string);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 解析日期 格式如下:
	 * 2006303或2006-06-03或2006/06/03或20060306
	 */
	public static String[] formatDate(String date) {
		if (date.equals(""))
			return null;
		String splitter = getSplitter(date);
		if (splitter == null || splitter.trim().length() == 0) {
			if (date.length() == 7) {
				String[] string = new String[3];
				string[0] = date.substring(0, 4);
				string[1] = date.substring(5);
				string[2] = date.substring(6, 7);
				return string;
			} else if (date.length() == 5) {
				String[] string = new String[2];
				string[0] = date.substring(0, 4);
				string[1] = date.substring(5);
			} else if (date.length() == 8) {
				String[] string = new String[3];
				string[0] = date.substring(0, 4);
				string[1] = date.substring(4, 6);
				string[2] = date.substring(6, 8);
			} else if (date.length() == 6) {
				String[] string = new String[2];
				string[0] = date.substring(0, 4);
				string[1] = date.substring(4, 6);
			}
		} else {
			String[] string = date.split(splitter);
			return string;
		}
		return null;
	}

	/**
	 * 获取前几天的日期
	 */
	public static String getTime(int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, -count);
		String date = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
		return date;
	}

	/**
	 * 获取前几天的日期
	 */
	public static Date getBeforeTime(int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, -count);
		return calendar.getTime();
	}

	/**
	 * 获取据当前时间几天的时间
	 */
	public static String getTime(String curDate, int count) {
		String date = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sdf.parse(curDate));
			calendar.add(Calendar.DAY_OF_MONTH, count);
			date = sdf.format(calendar.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 解析时间,取得分割符
	 */
	public static String getSplitter(String string) {
		if (string.indexOf("-") > -1)
			return "-";
		if (string.indexOf("/") > -1)
			return "/";
		return "";
	}

	public static String getIncDate(String dateStr, int days) {
		if (days == 0) {
			return dateStr;
		}
		String splitter = getSplitter(dateStr);
		int year = Integer.parseInt(dateStr.substring(0, 4), 10);
		int month = 0;
		int day = 0;
		if (!splitter.equals("")) {
			month = Integer.parseInt(dateStr.substring(5, 7), 10);
			day = Integer.parseInt(dateStr.substring(8, 10), 10);
		} else {
			month = Integer.parseInt(dateStr.substring(4, 6), 10);
			day = Integer.parseInt(dateStr.substring(6, 8), 10);
		}
		day += days;
		if (days > 0) {
			int daysOfMonth = getMonthDays(year, month);
			while (day > daysOfMonth) {
				day -= daysOfMonth;
				month++;
				if (month > 12) {
					month -= 12;
					year++;
				}
				daysOfMonth = getMonthDays(year, month);
			}
		} else {
			if (day <= 0) {
				int daysOfMonth = getMonthDays(year, month - 1);
				while (day <= 0) {
					day += daysOfMonth;
					month--;
					if (month <= 0) {
						month += 12;
						year--;
					}
					daysOfMonth = getMonthDays(year, month - 1);
				}
			}
		}
		String s_year = leftPad(year + "", 4);
		String s_month = leftPad(month + "", 2);
		String s_day = leftPad(day + "", 2);
		return String.valueOf(s_year + splitter + s_month + splitter + s_day);
	}

	/**
	 * 根据日期差值 得到新的日期
	 */
	public static Date getIncDate(Date date, int increment, DateUom uom) {
		Date result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = sdf.format(date);
		int year = Integer.parseInt(dateStr.substring(0, 4), 10);
		int month = Integer.parseInt(dateStr.substring(4, 6), 10);
		int day = Integer.parseInt(dateStr.substring(6, 8), 10);
		int hour = Integer.parseInt(dateStr.substring(8, 10), 10);
		int minute = Integer.parseInt(dateStr.substring(10, 12), 10);
		int second = Integer.parseInt(dateStr.substring(12, 14), 10);
		switch (uom) {
		case Year:
			year += increment;
			break;
		case Month:
			int dy = increment / 12;
			int dm = increment % 12;
			year += dy;
			month += dm;
			if (month > 12) {
				month -= 12;
				year++;
			}
			break;
		case Day:
			day += increment;
			int daysOfMonth = getMonthDays(year, month);
			while (day > daysOfMonth) {
				day -= daysOfMonth;
				month++;
				if (month > 12) {
					month -= 12;
					year++;

				}
				daysOfMonth = getMonthDays(year, month);
			}
			break;
		case Hour:
			//
			break;
		case Minute:
			//
			break;
		case Second:
			//
			break;
		}
		try {
			String s_year = leftPad(year + "", 4);
			String s_month = leftPad(month + "", 2);
			String s_day = leftPad(day + "", 2);
			String s_hour = leftPad(hour + "", 2);
			String s_minute = leftPad(minute + "", 2);
			String s_second = leftPad(second + "", 2);
			result = sdf.parse(String.valueOf(s_year + s_month + s_day + s_hour + s_minute + s_second));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static String leftPad(String str, int length) {
		if (str.length() >= length)
			return str;
		while (str.length() < length) {
			str = '0' + str;
		}
		return str;
	}

	/**
	 * 得到当前月 格式是2005-9-25 *
	 */
	public static int getMonth(String dateStr) {
		String spliter = getSplitter(dateStr);
		if (spliter.equals("")) {
			String month = dateStr.substring(4, 6);
			return Integer.parseInt(month);
		} else {
			String date[] = dateStr.split(spliter);
			return Integer.parseInt(date[1], 10);
		}
	}

	/**
	 * 得到月的天数 
	 */
	public static int getMonthDays(int year, int month) {
		int days = 1;
		boolean isLeap = (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) ? true : false;
		switch (month) {
		case 1:
			days = 31;
			break;
		case 2:
			if (isLeap)
				days = 29;
			else
				days = 28;
			break;
		case 3:
			days = 31;
			break;
		case 4:
			days = 30;
			break;
		case 5:
			days = 31;
			break;
		case 6:
			days = 30;
			break;
		case 7:
			days = 31;
			break;
		case 8:
			days = 31;
			break;
		case 9:
			days = 30;
			break;
		case 10:
			days = 31;
			break;
		case 11:
			days = 30;
			break;
		case 12:
			days = 31;
		}
		return days;
	}

	/**
	 * 得到当月最后一天的日期 *
	 */
	public static String getMonthLastDay(String date) {
		int days = 1;
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(4, 6));
		boolean isrn = (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) ? true : false;
		switch (month) {
		case 1:
			days = 31;
			break;
		case 2:
			if (isrn)
				days = 29;
			else
				days = 28;
			break;
		case 3:
			days = 31;
			break;
		case 4:
			days = 30;
			break;
		case 5:
			days = 31;
			break;
		case 6:
			days = 30;
			break;
		case 7:
			days = 31;
			break;
		case 8:
			days = 31;
			break;
		case 9:
			days = 30;
			break;
		case 10:
			days = 31;
			break;
		case 11:
			days = 30;
			break;
		case 12:
			days = 31;
		}
		return date + String.valueOf(days);
	}

	/**
	 * 得到月的1`````的天数。
	 */
	public int getMonthDays(String currDate, int year, int month) {
		int days = 1;
		String date[] = currDate.split("-");
		if (Integer.parseInt(date[0]) == year && Integer.parseInt(date[1]) == month) {
			days = Integer.parseInt(date[2]);
		} else {
			days = getMonthDays(year, month);
		}
		return days;
	}

	/**
	 * 得到当前年 格式是2005-9-25 *
	 */
	public static int getCurrentYear(String dateStr) {
		String date[] = dateStr.split("-");
		return Integer.parseInt(date[0], 10);
	}

	/**
	 * 得到当前天数 格式是2005-9-25 *
	 */
	public static int getCurrentDay(String dateStr) {
		String date[] = dateStr.split("-");
		return Integer.parseInt(date[2], 10);
	}

	/**
	 * 得到当季度到现在的天数 格式是2005-9-25 *
	 */
	public int getCurSeasonDays(String dateStr) {
		int days = 0;
		String date[] = dateStr.split("-");
		int day = Integer.parseInt(date[2], 10);
		int yy = Integer.parseInt(date[0], 10);
		boolean isrn = (((yy % 4 == 0) && (yy % 100 != 0)) || (yy % 400 == 0)) ? true : false;
		switch (Integer.parseInt(date[1], 10)) {
		case 1:
			days = day;
			break;
		case 2:
			days = 31 + day;
			break;
		case 3:
			if (isrn)
				days = 31 + 29 + day;
			else
				days = 31 + 28 + day;
			break;
		case 4:
			days = day;
			break;
		case 5:
			days = 30 + day;
			break;
		case 6:
			days = 61 + day;
			break;
		case 7:
			days = day;
			break;
		case 8:
			days = 31 + day;
			break;
		case 9:
			days = 62 + day;
			break;
		case 10:
			days = day;
			break;
		case 11:
			days = 31 + day;
			break;
		case 12:
			days = 61 + day;
			break;
		}
		return days;
	}

	/**
	 * 得到当前为第几季 格式如：20080203,2008-02-03
	 */
	public int getSeason(String date) {
		int month = getMonth(date);
		return (month - 1) / 3 + 1;
	}

	/**
	 * 返回两个日期间隔的天数
	 */
	public static int getBetweenDays(String beginDate, String endDate) {
		int sum = 0;
		int beginYear = getCurrentYear(beginDate);
		int beginMonth = getMonth(beginDate);
		int beginDay = getCurrentDay(beginDate);
		int endYear = getCurrentYear(endDate);
		int endMonth = getMonth(endDate);
		int endDay = getCurrentDay(endDate);
		String startDateStr = String.valueOf(beginYear) + bZero(beginMonth) + "01";

		int sumMonth = (endYear - beginYear + 1) * 12 - (beginMonth) - (12 - endMonth);
		for (int i = 0; i < sumMonth; i++) {
			String dateStr = getDateStr(startDateStr, i);
			sum = sum + getMonthDays(getCurrentYear(dateStr), getMonth(dateStr));
		}

		sum = sum - beginDay + endDay;
		return sum;
	}

	/**
	 * 返回日期经过若干月后的日期 
	 */
	public static String getDateStr(String dateStr, int hkm) {
		String reDateStr = "";
		int yy = Integer.parseInt(dateStr.substring(0, 4), 10);
		int mm = Integer.parseInt(dateStr.substring(4, 6), 10);
		int dd = Integer.parseInt(dateStr.substring(6, 8), 10);
		// int yy1=0,mm1=0,dd1=dd;
		int yy2 = 0, mm2 = 0, dd2 = dd;
		if ((mm + hkm) % 12 == 0) {
			yy2 = yy + (mm + hkm) / 12 - 1;
			mm2 = 12;
		} else {
			if ((mm + hkm) % 12 == 1) {
				yy2 = yy + (mm + hkm) / 12;
				mm2 = 1;
			} else {
				yy2 = yy + (mm + hkm) / 12;
				mm2 = (mm + hkm) % 12;
			}
		}
		reDateStr = String.valueOf(yy2) + "-" + bZero(mm2) + "-" + bZero(dd2);
		return reDateStr;
	}

	/**
	 * 返回两位数据字串 *
	 * 
	 * @param sz
	 * @return String
	 */
	public static String bZero(int sz) {
		return (sz < 10 ? ("0" + String.valueOf(sz)) : String.valueOf(sz));
	}

	/**
	 * @Description 比较两个时间的大小
	 */
	public static int compareTime(String date1, String date2) {
		java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Calendar c1 = java.util.Calendar.getInstance();
		java.util.Calendar c2 = java.util.Calendar.getInstance();
		try {
			c1.setTime(df.parse(date1));
			c2.setTime(df.parse(date2));
		} catch (java.text.ParseException e) {
			System.err.println("格式不正确");
		}
		return c1.compareTo(c2);
	}


	// 返回2个日期之间的秒数
	public static int getTimeDelta(String dateStr1, String dateStr2) {
		Date date1 = parseDateByPattern(dateStr1, "yyyy-MM-dd HH:mm:ss");
		Date date2 = parseDateByPattern(dateStr2, "yyyy-MM-dd HH:mm:ss");
		return getTimeDelta(date1, date2);
	}

	public static Date parseDateByPattern(String dateStr, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int getTimeDelta(Date date1, Date date2) {
		long timeDelta = (date1.getTime() - date2.getTime()) / 1000;// 单位是秒
		int secondsDelta = timeDelta > 0 ? (int) timeDelta : (int) Math.abs(timeDelta);
		return secondsDelta;
	}

	/**
	 * @Description 比较两个日期的大小
	 */
	public static int compare_date(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 为指定时间，增加多少秒
	 * 
	 * @param sDate
	 *            指定时间
	 * @param count
	 *            多少秒
	 * @return
	 * @throws Exception
	 */
	public static String getNewTime(String sDate, int count) throws Exception {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date1 = sim.parse(sDate);
		// 新建一个日历对象
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);// 获取日历对象的时间
		// 增加count秒
		cal.add(Calendar.SECOND, count);
		Date c = cal.getTime();
		return sim.format(c);
	}

	/**
	 * @Description 指定时间，增加多少分钟 
	 */
	public static String addDateMinut(String day, int x) {// 返回的是字符串型的时间，输入的是String
															// day, int x
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 24小时制
		// 引号里面个格式也可以是 HH:mm:ss或者HH:mm等等，很随意的，不过在主函数调用时，要和输入的变
		// 量day格式一致
		Date date = null;
		try {
			date = format.parse(day);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (date == null)
			return "";
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, x);// 24小时制
		date = cal.getTime();
		cal = null;
		return format.format(date);
	}

	public static void main(String[] args) throws Exception {
		/*
		 * String date = DateUtil.currentDate(); String deadline =
		 * DateUtil.currentDate(); int count = DateUtil.compareDate(deadline,
		 * date); System.out.println(count);
		 */
		/*String c = DateUtil.currentTime();
		System.out.println(c);
		
		String date1 = DateUtil.addDateMinut(c, 4);
		String date2 = DateUtil.currentTime();
		System.out.println(date1);
		int result = DateUtil.compareTime(date1, date2);
		if (result == 0)
			System.out.println("date1相等date2");
		else if (result < 0)
			System.out.println("date1小于date2");
		else
			System.out.println("date1大于date2");*/
		
		// System.out.println(DateUtil.compare_date("2014-11-13
		// 17:00:00","2014-11-14 11:17:54"));

	}
}
