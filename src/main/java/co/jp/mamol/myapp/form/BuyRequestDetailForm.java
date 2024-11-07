package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public class BuyRequestDetailForm {
	private int id;
	private List<CategoryDto> categoryList;
	private SizaiDto sizaiDto;
	private boolean flag;

	
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return categoryList
	 */
	public List<CategoryDto> getCategoryList() {
		return categoryList;
	}
	/**
	 * @param categoryList セットする categoryList
	 */
	public void setCategoryList(List<CategoryDto> categoryList) {
		this.categoryList = categoryList;
	}
	/**
	 * @return sizaiDto
	 */
	public SizaiDto getSizaiDto() {
		return sizaiDto;
	}
	/**
	 * @param sizaiDto セットする sizaiDto
	 */
	public void setSizaiDto(SizaiDto sizaiDto) {
		this.sizaiDto = sizaiDto;
	}
	/**
	 * @return flag
	 */
	public boolean isFlag() {
		return flag;
	}
	/**
	 * @param flag セットする flag
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}