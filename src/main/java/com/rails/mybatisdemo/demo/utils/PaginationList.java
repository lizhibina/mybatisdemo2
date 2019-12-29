package com.rails.mybatisdemo.demo.utils;

import java.util.List;

/**
 * 功能描述:封装分页数据
 *
 * @auther:
 * @date: 2018/7/31 9:54
 */
public class PaginationList implements java.io.Serializable {
    /**
     * 描述: 总记录数据
     */
    private Long total;
    /**
     * 描述:行的集合
     */
    private List<?> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public PaginationList(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }
}
