package fh.love.cyh.codegenerationtools.exception;

import fh.love.cyh.codegenerationtools.utils.MessageUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 基础异常
 */
public class BaseException extends RuntimeException{
    /**
     * 所属模块
     */
    private String module;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    /**
     * 错误消息
     */
    private String defaultMessage;

    public BaseException(String module, String code, Object[] args, String defaultMessage) {
        this.module = module;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    public BaseException(String code, Object[] args, String defaultMessage) {
        this(null,code,args,defaultMessage);
    }

    public BaseException(Object[] args, String defaultMessage) {
        this(null,null,args,defaultMessage);
    }

    public BaseException(String defaultMessage) {
        this(null,null,null,defaultMessage);
    }

    @Override
    public String getMessage() {
        String message = null;
        if (!StringUtils.isEmpty(code))
        {
            message = MessageUtils.message(code, args);
        }
        if (message == null)
        {
            message = defaultMessage;
        }
        return message;
    }
}
