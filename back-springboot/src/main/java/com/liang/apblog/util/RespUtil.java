package com.liang.apblog.util;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.cwen.util
 * @date 2021/6/16 8:32
 */
public class RespUtil {
    public static MyResp success(Object data) {
        return success("请求成功", data);
    }

    public static MyResp success() {
        return success("请求成功", null);
    }

    public static MyResp fail() {
        return fail("请求失败", null);
    }

    public static MyResp error() {
        return error("服务器出问题啦");
    }

    public static MyResp error(String message) {
        return error(message, null);
    }

    public static MyResp success(String message, Object data) {
        MyResp resp = new MyResp();
        resp.setCode(200)
                .setSuccess(true)
                .setMessage(message)
                .setData(data);
        return resp;
    }

    public static MyResp noAuth() {
        MyResp resp = new MyResp();
        resp.setCode(300)
                .setSuccess(false)
                .setMessage("没有权限访问该接口");
        return resp;
    }

    public static MyResp fail(String message, Object data) {
        MyResp resp = new MyResp();
        resp.setCode(400)
                .setSuccess(false)
                .setMessage(message)
                .setData(data);
        return resp;
    }

    public static MyResp error(String message, Object data) {
        MyResp resp = new MyResp();
        resp.setCode(500)
                .setSuccess(false)
                .setMessage(message)
                .setData(data);
        return resp;
    }


}
