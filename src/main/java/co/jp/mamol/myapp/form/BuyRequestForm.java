package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.SizaiDto;

public class BuyRequestForm {
	private String startDate;
	private String endDate;
	private List<SizaiDto> sizaiList;
	private int deleteId;

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
	 * @return sizaiList
	 */
	public List<SizaiDto> getSizaiList() {
		return sizaiList;
	}

	/**
	 * @param sizaiList セットする sizaiList
	 */
	public void setSizaiList(List<SizaiDto> sizaiList) {
		this.sizaiList = sizaiList;
	}

	/**
	 * @return deleteid
	 */
	public int getDeleteId() {
		return deleteId;
	}

	/**
	 * @param deleteid セットする deleteid
	 */
	public void setDeleteId(int deleteid) {
		this.deleteId = deleteid;
	}
	
	
}
