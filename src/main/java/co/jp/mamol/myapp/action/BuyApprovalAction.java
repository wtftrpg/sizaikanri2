package co.jp.mamol.myapp.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.BuyApprovalForm;
import co.jp.mamol.myapp.service.BuyApprovalService;

@Results({
		@Result(name = "approval", location = "/WEB-INF/jsp/approvalList.jsp"),
		@Result(name = "init", location = "/approvalList/init", type = "redirect")
})

public class BuyApprovalAction extends BaseAction {
	private BuyApprovalForm form = new BuyApprovalForm();

	@Autowired
	private BuyApprovalService service;

	//初期表示
	@Action("/approvalList/init")
	public String init() {
		//		現在日付の取得とストリング転換

		LocalDate today = LocalDate.now();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String todayStr = today.format(dtf);

		//		前月日付の取得とストリング転換
		LocalDate lastMonth = today.minusMonths(1);

		String lastMonthStr = lastMonth.format(dtf);

		//		フォームに入力
		form.setStartDate(lastMonthStr);
		form.setEndDate(todayStr);
		String deptid = getLoginUser().getDepid();

		List<SizaiDto> sizaiList = service.getDeptRequsetList(lastMonthStr, todayStr, deptid);

		if (sizaiList == null || sizaiList.size() == 0) {
			setMessage("指定期間の購入依頼が登録されていません。", false);
		} else {
			form.setList(sizaiList);
		}

		return "approval";
	}

	//購入依頼検索
	@Action("/approvalList/search")
	public String search() {
		String deptid = getLoginUser().getDepid();

		List<SizaiDto> list = service.getDeptRequsetList(form.getStartDate(), form.getEndDate(), deptid);

		if (list == null || list.size() == 0) {
			setMessage("指定期間の購入依頼が登録されていません。", false);
		} else {
			form.setList(list);
		}
		return "approval";

	}

	//承認
	@Action("/approvalList/approval")
	public String approval() {

		service.approval(form.getSizaiId());

		return "init";
	}

	//却下
	@Action("/approvalList/regect")
	public String regect() {

		service.regect(form.getSizaiId());
		return "init";
	}

	/**
	 * @return form
	 */
	public BuyApprovalForm getForm() {
		return form;
	}

	/**
	 * @param form セットする form
	 */
	public void setForm(BuyApprovalForm form) {
		this.form = form;
	}

}
