package com.fuyong.imwebtest.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/sensitivewords")
public class SensitiveWordsController {
    private static final Logger logger = LoggerFactory.getLogger(SensitiveWordsController.class);
    // 需要改成自身应用的appSecret
    private final String appSecret = "a5ad5acfd659";

    @RequestMapping(value = "/Filtering",method = {RequestMethod.GET})
    @ResponseBody
    public JSONObject filtering(HttpServletRequest request) throws JSONException {
        JSONObject result = new JSONObject();
        try {
            // 获取请求体
            byte[] body = readBody(request);
       /*     if (body == null) {
                logger.warn("request wrong, empty body!");
                result.put("code", 1);
                return result;
            }*/

            // 获取部分request header，并打印
            String ContentType = request.getContentType();
            String AppKey = request.getHeader("AppKey");
            String CurTime = request.getHeader("CurTime");
            String MD5 = request.getHeader("MD5");
            String CheckSum = request.getHeader("CheckSum");
            /**本地验证参数生成***/
            result.put("code", 0);
            return result;
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
            result.put("code", 1);
            return result;
        }
    }

    private byte[] readBody(HttpServletRequest request) throws IOException {
        if (request.getContentLength() > 0) {
            byte[] body = new byte[request.getContentLength()];
            IOUtils.readFully(request.getInputStream(), body);
            return body;
        } else
            return null;
    }
}
