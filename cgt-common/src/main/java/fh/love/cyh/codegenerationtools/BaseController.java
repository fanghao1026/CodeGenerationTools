package fh.love.cyh.codegenerationtools;

import fh.love.cyh.codegenerationtools.domain.Page;
import fh.love.cyh.codegenerationtools.domain.PageDomain;
import fh.love.cyh.codegenerationtools.domain.TableDataDomain;
import fh.love.cyh.codegenerationtools.entity.AjaxResult;
import fh.love.cyh.codegenerationtools.local.LocalVariable;
import fh.love.cyh.codegenerationtools.support.TableSupport;
import fh.love.cyh.codegenerationtools.utils.DateUtils;
import fh.love.cyh.codegenerationtools.utils.ServletUtils;
import fh.love.cyh.codegenerationtools.utils.SqlUtils;
import fh.love.cyh.codegenerationtools.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;


public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 日期字符串转Date类型
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(DateUtils.parseStrToDate(text));
            }

        });
    }

    /**
     * 设置请求的分页数据
     */
    public void startPage(){
        PageDomain pageDomain = TableSupport.getPageDomainByRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.anyIsNotNull(pageNum,pageSize)){
            String saveSql = SqlUtils.preventUnsafeSql(pageDomain.getOrderbySQL());
            LocalVariable.setLocalPage(new Page(pageNum,pageSize,saveSql));
        }
    }

    public TableDataDomain getDataTable(List<?> list){
        TableDataDomain tableDataDomain = new TableDataDomain();
        tableDataDomain.setRows(list);
        tableDataDomain.setTotal(list.size());
        tableDataDomain.setCode(0);
        return tableDataDomain;
    }

    /**
     * 获取request
     */
    public HttpServletRequest getRequest()
    {
        return ServletUtils.getRequest();
    }

    /**
     * 获取response
     */
    public HttpServletResponse getResponse()
    {
        return ServletUtils.getResponse();
    }

    /**
     * 获取session
     */
    public HttpSession getSession()
    {
        return getRequest().getSession();
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? success() : error();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected AjaxResult toAjax(boolean result)
    {
        return result ? success() : error();
    }

    /**
     * 返回成功
     */
    public AjaxResult success()
    {
        return AjaxResult.success();
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error()
    {
        return AjaxResult.error();
    }

    /**
     * 返回成功消息
     */
    public AjaxResult success(String message)
    {
        return AjaxResult.success(message);
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error(String message)
    {
        return AjaxResult.error(message);
    }

    /**
     * 返回错误码消息
     */
    public AjaxResult error(AjaxResult.Type type, String message)
    {
        return new AjaxResult(type, message,null);
    }

    /**
     * 页面跳转
     */
    public String redirect(String url)
    {
        return StringUtils.format("redirect:{}", url);
    }
}
