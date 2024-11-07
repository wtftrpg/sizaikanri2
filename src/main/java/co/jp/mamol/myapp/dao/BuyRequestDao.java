package co.jp.mamol.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public interface BuyRequestDao {
	
//	資材登録
	public void requestRegist(SizaiDto sizaiDto);
//	カテゴリ情報取得
	public List<CategoryDto> getCategory();
//	ユーザー別の資材管理情報取得
	public List<SizaiDto> getUserRequsetList(@Param("startDate") String startDate, @Param("endDate")String endDate,@Param("userId") String id);
//	idによる一件の資材情報
	public SizaiDto getRequestById(@Param("id") int id);
//	購入依頼変更
	public boolean modifyRequest(SizaiDto sizaiDto);
//	購入依頼削除
	public boolean deleteById(@Param("id") int id);
}
