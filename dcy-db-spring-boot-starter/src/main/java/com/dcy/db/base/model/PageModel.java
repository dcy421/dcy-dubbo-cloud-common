package com.dcy.db.base.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author：dcy
 * @Description: 分页类
 * @Date: 2020-02-14 09:08
 */
@Getter
@Setter
public class PageModel {

    /**
     * 当前页面
     */
    @TableField(exist = false)
    private int current = 1;

    /**
     * 每页多少条
     */
    @TableField(exist = false)
    private int size = 30;

    /**
     * 排序字段
     */
    @TableField(exist = false)
    private String sort;

    /**
     * 排序类型
     */
    @TableField(exist = false)
    private String order;

}
