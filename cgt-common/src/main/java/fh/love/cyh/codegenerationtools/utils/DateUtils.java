package fh.love.cyh.codegenerationtools.utils;

import fh.love.cyh.codegenerationtools.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils{

    protected final static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"
    };

    /**
     * 获取当前时间
     */
    public Date getNowDate(){
        return new Date();
    }

    /**
     * 日期转字符串
     * @param date
     * @param format
     * @return
     */
    public static String parseDateToStr(Date date, String format){
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 字符串转日期
     * @param time
     * @return
     */
    public static Date parseStrToDate(String time){
        try {
            if (time == null){
                return null;
            }
            return DateUtils.parseDate(time,parsePatterns);
        } catch (ParseException e) {
            logger.error("字符串转Date类型失败,所有模板不匹配--> {} ",time);
        }
        return null;
    }


}
