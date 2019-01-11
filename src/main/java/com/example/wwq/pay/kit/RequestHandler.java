package com.example.wwq.pay.kit;



import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class RequestHandler {

	@SuppressWarnings("rawtypes")
	private SortedMap<?, ?> parameters = new TreeMap();
	private String charset = "UTF-8";

	public String getParameter(String parameter) {
		String s = (String) this.parameters.get(parameter);
		return s == null ? "" : s;
	}

	public String UrlEncode(String src) throws UnsupportedEncodingException {
		return URLEncoder.encode(src, this.charset).replace("+", "%20");
	}

	@SuppressWarnings("rawtypes")
	public String genPackage(SortedMap<String, Object> packageParams)
			throws UnsupportedEncodingException {
		String sign = createSign(packageParams);

		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			sb.append(k + "=" + UrlEncode(v) + "&");
		}

		String packageValue = new StringBuilder("sign=").append(sign)
				.toString();

		return packageValue;
	}

	@SuppressWarnings("rawtypes")
	public String createSign(SortedMap<String, Object> packageParams) {
		this.parameters = packageParams;
		System.out.println("parameters------:" + parameters);
		// map转string成，用&连接n
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if ((v != null) && (!"".equals(v)) && (!"sign".equals(k))
					&& (!"key".equals(k))) {
				sb.append(k + "=" + v + "&");
			}
		}
		// 添加签名用的key
		sb.append("key=" + IWxPayConfig.WX_WXPUBLIC_PARTNER_KEY);
		System.out.println("md5 sb:" + sb);
		// md5加密并调用toUpperCase()把小写字母转成大写
		String sign = MD5Util.MD5Encode(sb.toString(), this.charset)
				.toUpperCase();
		System.out.println("packge签名:" + sign);
		return sign;
	}

	@SuppressWarnings("rawtypes")
	public String publicCreateSign(SortedMap<String, Object> packageParams) {
		this.parameters = packageParams;
		System.out.println("parameters------:" + parameters);
		// map转string成，用&连接n
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if ((v != null) && (!"".equals(v)) && (!"sign".equals(k))
					&& (!"key".equals(k))) {
				sb.append(k + "=" + v + "&");
			}
		}
		// 添加签名用的key
		sb.append("key="
				+ IWxPayConfig.WX_WXPUBLIC_PARTNER_KEY);
		System.out.println("md5 sb:" + sb);
		// md5加密并调用toUpperCase()把小写字母转成大写
		String sign = MD5Util.MD5Encode(sb.toString(), this.charset)
				.toUpperCase();
		System.out.println("packge签名:" + sign);
		return sign;
	}

	@SuppressWarnings("rawtypes")
	public String parseXML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		Set es = this.parameters.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if ((v != null) && (!"".equals(v)) && (!"appkey".equals(k))) {
				sb.append("<" + k + ">" + getParameter(k) + "</" + k + ">\n");
			}
		}
		sb.append("</xml>");
		return sb.toString();
	}
}