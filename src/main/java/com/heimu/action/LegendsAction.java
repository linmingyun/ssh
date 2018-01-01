package com.heimu.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.heimu.model.Legends;
import com.heimu.service.LegendsService;
import com.opensymphony.xwork2.ActionSupport;

@Component("legendsAction")
@SuppressWarnings("serial")
@Scope("prototype")
public class LegendsAction extends ActionSupport {
	
	private LegendsService legendsService;
	
	private List<Legends> legendsList;
	
	private Map<String, Object> result = new HashMap<String, Object>(); // result变量用于传送Json变量的返回值
	
//    private String page;  
//    private String rows;  

	public String execute() {
		List<Legends> list = this.legendsService.query();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		legendsList = list;
		return "success";
	}
	
	public String lottery() {
		return "success";
	}
	
	public String ssq() {
		List<Legends> list = this.legendsService.query();
//        Map<String, Object> rv = new HashMap<String, Object>();
//        rv.put("total", list.size());
//        rv.put("rows",  list);
//        System.out.println(list.size());
//        try {
//			this.toJson(list, list.size());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
        result.put("total", list.size());//total键 存放总记录数，必须的    
        result.put("rows", list);//rows键 存放每页记录 list 
        return "JSONRESULT";
	}
	
	//转化为Json格式
//	public void toJson(List<Legends> list,int total) throws Exception{
//		HttpServletResponse response = ServletActionContext.getResponse();
//		
//		JSONObject jobj = new JSONObject();//new一个JSON
//		jobj.accumulate("total",total );//total代表一共有多少数据
//		jobj.accumulate("rows", list);//row是代表显示的页的数据
//		
//		response.setCharacterEncoding("GB18030");//指定为utf-8
//		response.getWriter().write(jobj.toString());//转化为JSOn格式
//	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public LegendsService getLegendsService() {
		return legendsService;
	}

	@Resource
	public void setLegendsService(LegendsService legendsService) {
		this.legendsService = legendsService;
	}

	public List<Legends> getLegendsList() {
		return legendsList;
	}

	public void setLegendsList(List<Legends> legendsList) {
		this.legendsList = legendsList;
	}

}
