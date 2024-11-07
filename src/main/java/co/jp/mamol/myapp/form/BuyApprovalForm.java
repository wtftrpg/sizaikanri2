package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.SizaiDto;

public class BuyApprovalForm {
	
	public String startDate;
	
	public String endDate;
	
	public List<SizaiDto> list;
	
	public int sizaiId;

	/**
	 * @return startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate セットする startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate セットする endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return list
	 */
	public List<SizaiDto> getList() {
		return list;
	}

	/**
	 * @param list セットする list
	 */
	public void setList(List<SizaiDto> list) {
		this.list = list;
	}

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
	
	

}
