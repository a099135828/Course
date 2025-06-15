package com.example.course.dto;

import lombok.Data;
import java.util.List;

@Data
public class PageResult<T> {

    /**
     * 当前页数据列表
     */
    private List<T> records;

    /**
     * 总记录数
     */
    private long total;

    public PageResult(List<T> records, long total) {
        this.records = records;
        this.total = total;
    }
}