package com.dcy.basedb.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author：dcy
 * @Description: 公共实体类
 * @Date: 2019/9/6 13:55
 */
@Getter
@Setter
public class BaseModel extends PageModel implements Serializable {
    /**
     * 创建者
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private String createDate;

    /**
     * 更新者
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updateDate;

    /**
     * 删除标识
     * 不查询此字段
     */
    @TableLogic
    @TableField(select = false)
    private Integer delFlag;

    /**
     * 备注
     */
    private String remark;
}
