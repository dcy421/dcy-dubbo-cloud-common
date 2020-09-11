package com.dcy.db.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dcy.common.model.ResponseData;
import com.dcy.db.base.service.BaseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Author：dcy
 * @Description: 公共controller
 * @Date: 2019/9/6 13:19
 */
public abstract class BaseController<Entity> {

    protected abstract <T extends BaseService<Entity>> T getService();

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "entity", value = "查询对象", dataType = "Entity", paramType = "query")
    })
    @GetMapping(value = "/page")
    public ResponseData<IPage<Entity>> page(Entity entity) {
        return ResponseData.success(getService().pageList(entity));
    }

    @ApiOperation(value = "获取全部信息", notes = "获取全部信息")
    @GetMapping(value = "/all")
    public ResponseData<List<Entity>> all() {
        return ResponseData.success(getService().list());
    }


    @ApiOperation(value = "根据对象id，查询详细信息", notes = "根据对象id，查询详细信息")
    @GetMapping(value = "/getDetailById")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "实体类Id", dataType = "String", paramType = "query")
    })
    public ResponseData<Entity> getEntityById(@RequestParam String id) {
        return ResponseData.success(getService().getById(id));
    }

    @ApiOperation(value = "添加", notes = "添加")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "Entity", name = "entity", value = "对象参数", required = true)
    })
    @PostMapping(value = "/save")
    public ResponseData<Boolean> save(@RequestBody Entity entity) {
        return ResponseData.success(getService().save(entity));
    }

    @ApiOperation(value = "修改", notes = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "Entity", name = "entity", value = "对象参数", required = true)
    })
    @PostMapping(value = "/update")
    public ResponseData<Boolean> update(@RequestBody Entity entity) {
        return ResponseData.success(getService().updateById(entity));
    }

    @ApiOperation(value = "删除", notes = "删除")
    @PostMapping(value = "/delete")
    public ResponseData<Boolean> delete(@RequestParam Serializable id) {
        return ResponseData.success(getService().removeById(id));
    }

    @ApiOperation(value = "根据list删除", notes = "根据list删除")
    @PostMapping(value = "/deleteBatch")
    public ResponseData<Boolean> deleteBatch(@RequestBody Collection<? extends Serializable> idList) {
        return ResponseData.success(getService().removeByIds(idList));
    }
}
