package co.jp.mamol.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.mamol.myapp.dto.SizaiDto;

public interface BuyApprovalDao {
//DA2001部門別購入依頼一覧
	public List<SizaiDto> getDeptRequsetList(@Param("startDate")String startdate,@Param("endDate")String endDate,@Param("deptId") String deptId);
//DA2002購入依頼一件取得
	public SizaiDto getRequestById(@Param("id")int sizaiId);
//DA2003承認実行
	public boolean approval(@Param("id")int sizaiId);
//DA2004却下実行
	public boolean regect(@Param("id")int sizaiId);
	
}
