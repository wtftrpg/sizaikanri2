package co.jp.mamol.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.mamol.myapp.dao.BuyApprovalDao;
import co.jp.mamol.myapp.dto.SizaiDto;

@Service
public class BuyApprovalService {
	@Autowired
	private BuyApprovalDao buyapprovaldao;
	
//BL2001部門別購入依頼一覧取得
	public List<SizaiDto> getDeptRequsetList(String startDate,String endDate,String userid){	
		startDate = startDate + " " + "00:00:00";
		endDate = endDate + " " + "23:59:59";
		
		List<SizaiDto> list = buyapprovaldao.getDeptRequsetList(startDate, endDate, userid);
		
		return list;

	}

//BL2002購入依頼一件取得
	public SizaiDto getRequest(int sizaiId) {
		
		SizaiDto s = buyapprovaldao.getRequestById(sizaiId);
		
		return s;
	}
	
	
	
//BL2003承認実行
	
	public boolean approval(int id) {
		
		boolean app = buyapprovaldao.approval(id);
		return app;
	}
	
	
	
//BL2004却下実行
	public boolean regect(int id) {
		
		boolean re = buyapprovaldao.regect(id);
		return re;
	}

}
