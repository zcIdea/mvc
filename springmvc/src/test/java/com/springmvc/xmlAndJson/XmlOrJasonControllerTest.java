package com.springmvc.xmlAndJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class XmlOrJasonControllerTest {

	@Test
	public void testJsonResponse() throws IOException, URISyntaxException {
		String url = "http://localhost:80/springmvc/spring/xmlResponse";

		ClientHttpRequest request = new SimpleClientHttpRequestFactory().createRequest(new URI(url), HttpMethod.GET);
		request.getHeaders().set("Accept", "application/json");
		ClientHttpResponse response = request.execute();
		InputStream is = response.getBody();
		/*byte bytes[] = new byte[(int) response.getHeaders().getContentLength()];
		is.read(bytes);

		String jsonData = new String(bytes);
		System.out.println(jsonData);*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str = "";
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        
        is.close();
		
	}

	@Test
	public void testXmlResponse() throws IOException, URISyntaxException {
		String url = "http://localhost:80/springmvc/spring/xmlResponse";
		// response headers 中包含Transfer-Encoding:chunked，没有content length,
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.set("Accept", "application/xml");

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(requestHeaders);
		String xmlData = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class).getBody();

		System.out.println(xmlData);
	}
	
	/** 
     * 接口调用 GET 
     */  
	@Test
    public void httpURLConectionGET() {  
        try {  
        	String GET_URL = "http://localhost:80/springmvc/spring/xmlResponse"; 
            URL url = new URL(GET_URL);    // 把字符串转换为URL请求地址  
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接  
            connection.connect();// 连接会话  
            // 获取输入流  
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));  
            String line;  
            StringBuilder sb = new StringBuilder();  
            while ((line = br.readLine()) != null) {// 循环读取流  
                sb.append(line);  
            }  
            br.close();// 关闭流  
            connection.disconnect();// 断开连接  
            System.out.println(sb.toString());  
        } catch (Exception e) {  
            e.printStackTrace();  
            System.out.println("失败!");  
        }  
    } 
	
	/**
     * 调用对方接口方法
     * @param path 对方或第三方提供的路径
     * @param data 向对方或第三方发送的数据，大多数情况下给对方发送JSON数据让对方解析
     */
    public static void interfaceUtil(String path,String data) {
        try {
            URL url = new URL(path);
            //打开和url之间的连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            PrintWriter out = null;
            //请求方式
//          conn.setRequestMethod("POST");
//           //设置通用的请求属性
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("accept", "application/json");
            conn.setRequestProperty("accept", "application/xml");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)"); 
            //设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
            //最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
            //post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //获取URLConnection对象对应的输出流
            /*out = new PrintWriter(conn.getOutputStream());
            //发送请求参数即数据
            out.print(data);
            //缓冲数据
            out.flush();*/
            //获取URLConnection对象对应的输入流
            InputStream is = conn.getInputStream();
            //构造一个字符流缓存
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = "";
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
            //关闭流
            is.close();
            //断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
            //固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上disconnect后正常一些。
            conn.disconnect();
            System.out.println("完整结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        interfaceUtil("http://localhost:80/springmvc/spring/stringResponse", "");
    }
    
}