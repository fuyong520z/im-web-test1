package com.fuyong.imwebtest.controller;


import com.alibaba.fastjson.JSONObject;

import com.fuyong.imwebtest.pojo.Invoice;
import com.fuyong.imwebtest.tools.OcrTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Controller
@RequestMapping("/invoice")
public class OcrController {

	@Autowired
	private OcrTools ocrTools;
	
	@RequestMapping("/index")
	public String index(Model m) {
		return "testOcr";
	}

    @RequestMapping("/index1")
    public String index1(Model m) {
        return "TreeIndex";
    }

    @RequestMapping(value="/getMsg", method= RequestMethod.POST)
	@ResponseBody
	public Invoice upload(MultipartHttpServletRequest filesRequest) {
		MultipartFile file = filesRequest.getFile("file");
		try {
			InputStream in = file.getInputStream();
			String ocrResult = ocrTools.getocrByInputStream(in);

			Map resultMap = JSONObject.parseObject(ocrResult,Map.class);
			String invoiceString = JSONObject.toJSONString(resultMap.get("words_result"));
			Invoice invoice = JSONObject.parseObject(invoiceString,Invoice.class);
			return invoice;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
