package fh.love.cyh.codegenerationtools.domain;

import org.apache.commons.lang3.StringUtils;

/**
 * 分页数据
 */
public class PageDomain {

    private Integer pageNum; //第几页

    private Integer pageSize; //页大小

    private String orderByColumn; //以某列排序

    private String isAsc = "asc"; //默认升序

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderByColumn() {
        return orderByColumn;
    }

    public void setOrderByColumn(String orderByColumn) {
        this.orderByColumn = orderByColumn;
    }

    public String getIsAsc() {
        return isAsc;
    }

    public void setIsAsc(String isAsc) {
        this.isAsc = isAsc;
    }

    public String getOrderbySQL(){
        if (StringUtils.isEmpty(orderByColumn)){
            return "";
        }
        return " "+"order by"+" "+orderByColumn+" "+isAsc;
    }
}
