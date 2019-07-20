package com.nuist.sql;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormat {

	//转换date 至String
		public static String format(Date date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(date);
		}
		//转换String 到 date
		public static Date format_(String date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date_=null;
			try {
				date_=sdf.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return date_;
		}
		//将util的date转换成sql的date"yyyy-MM-dd"
		public static java.sql.Date utilToSql(Date date){
			return new java.sql.Date(date.getTime());
		}

}
