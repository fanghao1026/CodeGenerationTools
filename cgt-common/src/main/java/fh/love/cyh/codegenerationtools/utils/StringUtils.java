package fh.love.cyh.codegenerationtools.utils;

public class StringUtils {
    public static boolean isNotEmpty(Object[] arr){
        if (arr == null){
            return false;
        }
        return arr.length == 0 ? false:true;
    }
    public static boolean anyIsNotNull(Object... strs){
        boolean flag = true;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null){
                return false;
            }
        }
        return flag;
    }

    public static String format(String model,String rep){
        return model.substring(0,model.indexOf(rep)) + rep + model.substring(model.indexOf(rep)+2);
    }


}
