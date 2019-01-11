package com.example.wwq.wx.kit;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;


public class WechatXMLConfig {
	/**
	 * 将xml转换为JSON对象
	 * @param xml xml字符串
	 * @return
	 * @throws Exception
	 */
	public static JSONObject xmltoJson(String xml) throws Exception {
	    JSONObject jsonObject = new JSONObject();
	    Document document = DocumentHelper.parseText(xml);
	    //获取根节点元素对象  
	    Element root = document.getRootElement();
	    iterateNodes(root, jsonObject);
	    return jsonObject;  
	 }
	/**
	 * 遍历元素
	 * @param node 元素
	 * @param json 将元素遍历完成之后放的JSON对象
	 */
	@SuppressWarnings("unchecked")
	public static void iterateNodes(Element node,JSONObject json){ 
	    //获取当前元素的名称
	    String nodeName = node.getName();
	    //判断已遍历的JSON中是否已经有了该元素的名称
	    if(json.containsKey(nodeName)){
	        //该元素在同级下有多个
	        Object Object = json.get(nodeName);
	        JSONArray array = null;
	        if(Object instanceof JSONArray){
	            array = (JSONArray) Object;
	        }else {
	            array = new JSONArray();
	            array.add(Object);
	        }
	        //获取该元素下所有子元素 
	        List<Element> listElement = node.elements();
	        if(listElement.isEmpty()){
	            //该元素无子元素，获取元素的值
	            String nodeValue = node.getTextTrim();
	            array.add(nodeValue);
	            json.put(nodeName, array);
	            return ;
	        }
	        //有子元素
	        JSONObject newJson = new JSONObject();
	        //遍历所有子元素
	        for(Element e:listElement){
	            //递归  
	            iterateNodes(e,newJson);
	        }
	        array.add(newJson);
	        json.put(nodeName, array);
	        return ;
	    }
	    //该元素同级下第一次遍历
	    //获取该元素下所有子元素
	    List<Element> listElement = node.elements();
	    if(listElement.isEmpty()){
	        //该元素无子元素，获取元素的值
	        String nodeValue = node.getTextTrim();
	        json.put(nodeName, nodeValue);
	        return ;
	    }
	    //有子节点，新建一个JSONObject来存储该节点下子节点的值
	    JSONObject object = new JSONObject();
	    //遍历所有一级子节点  
	    for(Element e:listElement){
	        //递归  
	        iterateNodes(e,object);
	    }
	    json.put(nodeName, object);
	    return ;
	}
	
	public static void main(String[] args) {
		String xml = "<xml>\r\n" + 
				"    <ToUserName>\r\n" + 
				"        <![CDATA[gh_6b9aa8a6f1e2]]>\r\n" + 
				"    </ToUserName>\r\n" + 
				"    <FromUserName>\r\n" + 
				"        <![CDATA[o4WmZ0h-4huBUVQUczx2ezaxIL9c]]>\r\n" + 
				"    </FromUserName>\r\n" + 
				"    <CreateTime>1505542211</CreateTime>\r\n" + 
				"    <MsgType>\r\n" + 
				"        <![CDATA[event]]>\r\n" + 
				"    </MsgType>\r\n" + 
				"    <Event>\r\n" + 
				"        <![CDATA[SCAN]]>\r\n" + 
				"    </Event>\r\n" + 
				"    <EventKey>\r\n" + 
				"        <![CDATA[haha]]>\r\n" + 
				"    </EventKey>\r\n" + 
				"    <Ticket>\r\n" + 
				"        <![CDATA[gQHf8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAydmhZenQzeEZlcGkxMDAwMHcwN1EAAgQGu7xZAwQAAAAA]]>\r\n" + 
				"    </Ticket>\r\n" + 
				"</xml>";
		 JSONObject jsonObject;
		try {
			jsonObject = xmltoJson(xml);
			String json = jsonObject.toString();
			System.out.println(json);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	}
}
