package fh.love.cyh.codegenerationtools.support;

import fh.love.cyh.codegenerationtools.constant.Constants;
import fh.love.cyh.codegenerationtools.domain.Page;
import fh.love.cyh.codegenerationtools.domain.PageDomain;
import fh.love.cyh.codegenerationtools.utils.ServletUtils;

public class TableSupport {
    public static PageDomain getPageDomainByRequest(){
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(Constants.PAGE_NUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(Constants.PAGE_SIZE));
        pageDomain.setIsAsc(ServletUtils.getParameterToStr(Constants.IS_ASC));
        pageDomain.setOrderByColumn(ServletUtils.getParameterToStr(Constants.ORDER_BY_COLUMN));
        return pageDomain;
    }

    public static Page convert(){
        PageDomain domain = getPageDomainByRequest();
        return new Page(domain.getPageNum(),domain.getPageSize(),domain.getOrderbySQL());
    }
}
