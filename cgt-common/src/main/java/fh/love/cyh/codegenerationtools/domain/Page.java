package fh.love.cyh.codegenerationtools.domain;

public class Page {
    private Integer pageNum; //第几页

    private Integer pageSize; //页大小

    private String orderBySQL;

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

    public String getOrderBySQL() {
        return orderBySQL;
    }

    public void setOrderBySQL(String orderBySQL) {
        this.orderBySQL = orderBySQL;
    }

    public Page(Integer pageNum, Integer pageSize, String orderBySQL) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.orderBySQL = orderBySQL;
    }
}
