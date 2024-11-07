package co.jp.mamol.myapp.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.BuyApprovalDetailForm;
import co.jp.mamol.myapp.service.BuyApprovalService;

@Results({
	@Result(name = "approvalDetail", location = "/WEB-INF/jsp/approvalDetail.jsp")
})

public class BuyApprovalDetailAction extends BaseAction {
	
	@Autowired
	BuyApprovalService service;
	
	BuyApprovalDetailForm form = new BuyApprovalDetailForm();
	
	@Action("/approvalDetail/init")
	public String init() {
		
		SizaiDto s = service.getRequest(form.getSizaiId());
		
		form.setSizaiDto(s);
		
		return "approvalDetail";
		
		
	}

	/**
	 * @return form
	 */
	public BuyApprovalDetailForm getForm() {
		return form;
	}

	/**
	 * @param form セットする form
	 */
	public void setForm(BuyApprovalDetailForm form) {
		this.form = form;
	}
	
	

}
