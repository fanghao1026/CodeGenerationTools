package fh.love.cyh.codegenerationtools.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 继承Map，自己也就是一个map，put进去的值，也能get出来
 */
public class AjaxResult extends HashMap<String,Object> {
    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    /**
     * 状态类型
     */
    public enum Type
    {
        /** 成功 */
        SUCCESS(0),
        /** 警告 */
        WARN(301),
        /** 错误 */
        ERROR(500);
        private final int value;

        Type(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }

    public AjaxResult() {
    }

    public AjaxResult(Type type,String msg,Object data){
        super.put(CODE_TAG,type.value);
        super.put(MSG_TAG,msg);
        super.put(DATA_TAG,data);
    }

    public static AjaxResult success(){
        return AjaxResult.success("操作成功");
    }

    public static AjaxResult success(String msg){
        return AjaxResult.success(msg,null);
    }

    public static AjaxResult success(Object data){
        return AjaxResult.success("操作成功",data);
    }

    public static AjaxResult success(String msg,Object data){
        return new AjaxResult(Type.SUCCESS,msg,data);
    }

    public static AjaxResult warn(String msg)
    {
        return AjaxResult.warn(msg, null);
    }

    public static AjaxResult warn(String msg, Object data)
    {
        return new AjaxResult(Type.WARN, msg, data);
    }

    public static AjaxResult error()
    {
        return AjaxResult.error("操作失败");
    }

    public static AjaxResult error(String msg)
    {
        return AjaxResult.error(msg, null);
    }

    public static AjaxResult error(String msg, Object data)
    {
        return new AjaxResult(Type.ERROR, msg, data);
    }


}
