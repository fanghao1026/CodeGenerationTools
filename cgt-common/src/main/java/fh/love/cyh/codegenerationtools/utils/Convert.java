package fh.love.cyh.codegenerationtools.utils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Convert {
    protected final static Logger logger = LoggerFactory.getLogger(Convert.class);

    public static Integer toInt(Object value,Integer defaultValue){

        if (value == null){
            return defaultValue;
        }

        if (value instanceof Integer){
            return (Integer) value;
        }

        if (value instanceof Number){
            return ((Number) value).intValue();
        }
        if (value instanceof String){
            if (StringUtils.isEmpty(value.toString())){
                return defaultValue;
            }
            try{
                return Integer.parseInt(value.toString().trim());
            }catch (Exception e){
                logger.error("字符串格式错误，无法转成int值 ：{}",value.toString());
            }
        }

        return null;
    }

    public static String toStr(Object value,String defaultValue){
        if (value == null){
            return defaultValue;
        }
        if (value instanceof String){
            return value.toString();
        }
        if (value instanceof Integer){
            return String.valueOf(((Integer) value).intValue());
        }
        return null;
    }


}
