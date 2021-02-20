package com.zzu.hezhifeng.common.utils;

/**
 * 分页操作
 */
public class Pagination {
    /**
     * 第几页
     */
    int page;

    /**
     * 限制数量
     */
    int limit;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
