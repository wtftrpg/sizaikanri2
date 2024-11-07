package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public class BuyRequestRegistForm {
	private SizaiDto sizaiDto;
	private List<CategoryDto> categoryList;
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

	
}


	