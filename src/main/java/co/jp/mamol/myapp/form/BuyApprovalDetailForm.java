package co.jp.mamol.myapp.form;

import co.jp.mamol.myapp.dto.SizaiDto;

public class BuyApprovalDetailForm {
	
	private int sizaiId;
	
	private SizaiDto sizaiDto;

	/**
	 * @return sizaiId
	 */
	public int getSizaiId() {
		return sizaiId;
	}

	/**
	 * @param sizaiId セットする sizaiId
	 */
	public void setSizaiId(int sizaiId) {
		this.sizaiId = sizaiId;
	}

	/**
	 * @return sizaidto
	 */
	public SizaiDto getSizaiDto() {
		return sizaiDto;
	}

	/**
	 * @param sizaidto セットする sizaidto
	 */
	public void setSizaiDto(SizaiDto sizaidto) {
		this.sizaiDto = sizaidto;
	}

}
