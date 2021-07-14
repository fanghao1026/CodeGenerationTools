package fh.love.cyh.codegenerationtools.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletUtils {

    //取得ThreadLocal变量里的RequestAttributes,类型转换为ServletRequestAttributes
    public static ServletRequestAttributes getServletRequestAttributes(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) requestAttributes;
    }

    //取得这个线程的request请求
    public static HttpServletRequest getRequest() {
        return getServletRequestAttributes().getRequest();
    }

    public static HttpServletResponse getResponse()
    {
        return getServletRequestAttributes().getResponse();
    }

    public static HttpSession getSession(){
        return getRequest().getSession();
    }

    public static int getParameterToInt(String param){
        return Convert.toInt(getRequest().getParameter(param),null);
    }

    public static String getParameterToStr(String param){
        return Convert.toStr(getRequest().getParameter(param),"asc");
    }
}
