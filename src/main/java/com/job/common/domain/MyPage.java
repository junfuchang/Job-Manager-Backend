package com.job.common.domain;

import lombok.Data;

import java.util.List;

@Data
public class MyPage<T> extends com.baomidou.mybatisplus.extension.plugins.pagination.Page{

    /**
     * 字段list用于存储返回的记录
     */
    private List list;

    public List<T> getRecords() {
        return super.getRecords();
    }

    public MyPage(long current, long pageSize) {
        super(current, pageSize);
        this.list = super.getRecords();
    }
}
