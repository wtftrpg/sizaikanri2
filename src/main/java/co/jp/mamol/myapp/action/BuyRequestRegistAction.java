package co.jp.mamol.myapp.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.BuyRequestRegistForm;
import co.jp.mamol.myapp.service.BuyRequestService;

@Results({
	@Result(name = "requestRegist", location = "/WEB-INF/jsp/requestRegist.jsp"),
})

public class BuyRequestRegistAction extends BaseAction {
	private BuyRequestRegistForm brrf = new BuyRequestRegistForm();
	
	@Autowired
	private BuyRequestService service;
	
//	初期表示！！！！！！！！！！！！！！！！！！１１
	@Action("/requestRegist/init")
	public String init() {
		
		List<CategoryDto> list= service.getCategory();
		
		brrf.setCategoryList(list);
		
		return "requestRegist";
	
	}
	
	//登録実行
		@Action("/requestRegist/regist")
		public String regist() {
			//購入依頼情報取得
			SizaiDto sizaiDto = brrf.getSizaiDto();


			//入力チェック
			if (sizaiDto.getName() == null || sizaiDto.getName().length() == 0) {
				setMessage("資材名を入力してください。", false);
			} else if (sizaiDto.getNum() == 0) {
				setMessage("数量を入力してください。", false);
			} else {
				//購入依頼者ID設定
				sizaiDto.setRequest_user_id(getLoginUser().getId());
				//購入依頼部署
				sizaiDto.setRequest_dept_id(getLoginUser().getDepid());
				//購入依頼登録
				service.requestRegist(sizaiDto);

				setMessage("登録完了しました。", true);
			}

			//カテゴリ情報取得
			List<CategoryDto> list = service.getCategory();

			brrf.setCategoryList(list);

			return "requestRegist";
		}
	
	


	/**
	 * @return brrf
	 */
	public BuyRequestRegistForm getBrrf() {
		return brrf;
	}

	/**
	 * @param brrf セットする brrf
	 */
	public void setBrrf(BuyRequestRegistForm brrf) {
		this.brrf = brrf;
	}


	
}
	