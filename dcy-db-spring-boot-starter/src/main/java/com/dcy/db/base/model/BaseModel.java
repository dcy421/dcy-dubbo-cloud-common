package com.dcy.db.base.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author：dcy
 * @Description: 公共实体类
 * @Date: 2019/9/6 13:55
 */
@Getter
@Setter
public class BaseModel extends PageModel implements Serializable {

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建者",hidden = true)
    private String createBy;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间",hidden = true)
    private LocalDateTime createDate;

    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "更新者",hidden = true)
    private String updateBy;

    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "更新时间",hidden = true)
    private LocalDateTime updateDate;

    /**
     * 删除标识
     * 不查询此字段
     */
    @TableLogic
    @TableField(select = false)
    @ApiModelProperty(value = "删除标识",hidden = true)
    private Integer delFlag;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
}
