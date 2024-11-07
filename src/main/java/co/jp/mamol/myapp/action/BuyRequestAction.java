package co.jp.mamol.myapp.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.BuyRequestForm;
import co.jp.mamol.myapp.service.BuyRequestService;

@Results({
	@Result(name = "knir", location = "/WEB-INF/jsp/requestList.jsp"),
	@Result(name = "init", location = "/requestList/init",type="redirect")
})

public class BuyRequestAction extends BaseAction {
	private BuyRequestForm knirForm = new BuyRequestForm();
	
	@Autowired
	private BuyRequestService knirService;
	
//	初期表示！！！！！！！！！！！！！！！！！！１１
	@Action("/requestList/init")
	public String init() {
//		現在日付の取得とストリング転換
		
		LocalDate today = LocalDate.now();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String todayStr = today.format(dtf);
		
//		前月日付の取得とストリング転換
		LocalDate lastMonth = today.minusMonths(1);
		
		String lastMonthStr = lastMonth.format(dtf);		
		
//		フォームに入力
		knirForm.setStartDate(lastMonthStr);
		knirForm.setEndDate(todayStr);
		String userid = getLoginUser().getId();
		
		List<SizaiDto> sizaiList = knirService.getUserRequsetList(lastMonthStr, todayStr,userid);
		
		if(sizaiList==null || sizaiList.size() == 0) {
			setMessage("指定期間の購入依頼が登録されていません。", false);
		}else {
			knirForm.setSizaiList(sizaiList);
		}
		
		return "knir";
	}

//	日付に基ずく検索
	@Action("/requestList/search")
	public String search() {
		
		String userid = getLoginUser().getId();
		List<SizaiDto> sizaiList = knirService.getUserRequsetList(knirForm.getStartDate(), knirForm.getEndDate(),userid);

		if(sizaiList==null || sizaiList.size() == 0) {
			setMessage("指定期間の購入依頼が登録されていません。", false);
		}else {
			knirForm.setSizaiList(sizaiList);
		}

		return "knir";
	}
	
	//撤回
	@Action("/requestList/delete")
	public String delete() {

		//購入依頼削除
		knirService.deleteRequest(knirForm.getDeleteId());

		return "init";
	}

	/**
	 * @return knirForm
	 */
	public BuyRequestForm getKnirForm() {
		return knirForm;
	}

	/**
	 * @param knirForm セットする knirForm
	 */
	public void setKnirForm(BuyRequestForm knirForm) {
		this.knirForm = knirForm;
	}

	/**
	 * @return knirService
	 */
	public BuyRequestService getKnirService() {
		return knirService;
	}

	/**
	 * @param knirService セットする knirService
	 */
	public void setKnirService(BuyRequestService knirService) {
		this.knirService = knirService;
	}
	
	


}
