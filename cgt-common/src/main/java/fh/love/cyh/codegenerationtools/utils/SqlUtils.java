package fh.love.cyh.codegenerationtools.utils;

import fh.love.cyh.codegenerationtools.exception.BaseException;
import org.apache.commons.lang3.StringUtils;

public class SqlUtils {
    public static String SQL_PATTERN = "[a-zA-Z0-9_\\ \\,\\.]+";

    public static String preventUnsafeSql(String sql){
        if (StringUtils.isNotEmpty(sql) && !sql.matches(SQL_PATTERN)){
            throw new BaseException("SQL存在问题，有注入危险！！！");
        }
        return sql;
    }
}
