package com.fuyong.imwebtest.tools;


import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URLEncoder;
import java.util.Base64;

@Component
public class OcrTools {
	/**
	 * 识别图片
	 * @param filePath 图片路径
	 * @return 识别结果
	 */
	public static String getocrByInputStream(InputStream in){
		byte[] fileByte = getFileBytes(in);// 获取图片字节数组
		String base64UrlencodedImg = base64Urlencode(fileByte);// 编码
		return sendOcr(base64UrlencodedImg);// 发送给百度进行文字识别
	}
	
	/**
	 * 传入base64 + UrlEncode 编码后的图片
	 * 得到图片解析结果字符串（百度返回的Json）
	 * @param base64UrlencodedImg
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String sendOcr(String base64UrlencodedImg){
		CloseableHttpClient httpclient = HttpClients.createMinimal();
		HttpPost post = new HttpPost("https://aip.baidubce.com/rest/2.0/ocr/v1/vat_invoice?access_token=24.49ab84db299d9eb3bcf66b09d93938e4.2592000.1570783892.282335-17228314");
		Header header = new BasicHeader("Content-Type","application/x-www-form-urlencoded");
		post.setHeader(header);
		try {
			HttpEntity entity = new StringEntity("image=" + base64UrlencodedImg);
			post.setEntity(entity);
			CloseableHttpResponse response = httpclient.execute(post);
			InputStream in = response.getEntity().getContent();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();  
	        byte[] b = new byte[1000];  
	        int n;  
	        while ((n = in.read(b)) != -1) {  
	            bos.write(b, 0, n);  
	        }
	        in.close();
	        bos.close();  
	        byte[] buffer = bos.toByteArray(); 
			
			return new String(buffer,"utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 图片转字节数组
	 * @param filePath 图片本地路径
	 * @return 图片字节数组
	 */
	private static byte[] getFileBytes(InputStream in){  
        byte[] buffer = null;  
        try {  
           // File file = new File(filePath);  
           // FileInputStream fis = new FileInputStream(file);  
            ByteArrayOutputStream bos = new ByteArrayOutputStream();  
            byte[] b = new byte[1000];  
            int n;  
            while ((n = in.read(b)) != -1) {  
                bos.write(b, 0, n);  
            }  
            in.close();  
            bos.close();  
            buffer = bos.toByteArray();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return buffer;
    }
	
	/**
	 * 对字节数组进行base64编码与url编码
	 * @param b
	 * @return
	 */
	private static String base64Urlencode(byte[] b) {
		byte[] base64Img = Base64.getEncoder().encode(b);
		try {
			String base64UrlencodedImg = URLEncoder.encode(new String(base64Img), "utf-8");
			return base64UrlencodedImg;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * InputStream 转String
	 * @param is
	 * @return
	 */
	public String convertStreamToString(InputStream is) {   
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));   
		StringBuilder sb = new StringBuilder();   
		String line = null;   
		try {   
			while ((line = reader.readLine()) != null) {   
				sb.append(line + "/n");   
			}   
		} catch (IOException e) {   
			e.printStackTrace();   
		} finally {   
			try {   
				is.close();   
		    } catch (IOException e) {   
	             e.printStackTrace();   
		    }   
		}   
		return sb.toString();   		 
	}   
}
