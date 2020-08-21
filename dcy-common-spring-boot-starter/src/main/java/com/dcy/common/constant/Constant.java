package com.dcy.common.constant;

/**
 * @Author：dcy
 * @Description: 全局公共常量
 * @Date: 2019/9/6 13:36
 */
public interface Constant {
    /**
     * token请求头名称
     */
    String TOKEN_HEADER = "Authorization";

    /**
     * The access token issued by the authorization server. This value is REQUIRED.
     */
    String ACCESS_TOKEN = "access_token";

    String BEARER_TYPE = "Bearer ";


    // auth-server 常量
    String SIGNING_KEY = "dcy!#$&*(!FGE";
    String CONTEXT_KEY_USER_ID = "currentUserId";
    String USER_INFO = "user_info";
    String CONTEXT_KEY_USERNAME = "currentUserName";
    String CONTEXT_KEY_URL = "currentURL";
    /**
     * 存储用户权限
     */
    String REDIS_USER_MODULE_LIST_KEY = "user:module:resources:list:";

    /**
     * 租户id参数
     */
    String TENANT_ID_PARAM = "tenant_id";
    String CONTEXT_KEY_TENANT_ID = "currentTenantId";

    /**
     * 数据库公共字段
     */
    String CREATE_BY = "create_by";
    String CREATE_DATE = "create_date";
    String UPDATE_BY = "update_by";
    String UPDATE_DATE = "update_date";
    String DEL_FLAG = "del_flag";
    String REMARK = "remark";
}
