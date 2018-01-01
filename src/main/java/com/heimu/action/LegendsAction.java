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
	
	private Map<String, Object> result = new HashMap<String, Object>(); // result�������ڴ���Json�����ķ���ֵ
	
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
        result.put("total", list.size());//total�� ����ܼ�¼���������    
        result.put("rows", list);//rows�� ���ÿҳ��¼ list 
        return "JSONRESULT";
	}
	
	//ת��ΪJson��ʽ
//	public void toJson(List<Legends> list,int total) throws Exception{
//		HttpServletResponse response = ServletActionContext.getResponse();
//		
//		JSONObject jobj = new JSONObject();//newһ��JSON
//		jobj.accumulate("total",total );//total����һ���ж�������
//		jobj.accumulate("rows", list);//row�Ǵ�����ʾ��ҳ������
//		
//		response.setCharacterEncoding("GB18030");//ָ��Ϊutf-8
//		response.getWriter().write(jobj.toString());//ת��ΪJSOn��ʽ
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
