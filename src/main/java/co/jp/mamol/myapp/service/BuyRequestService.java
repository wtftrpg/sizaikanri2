package co.jp.mamol.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.mamol.myapp.dao.BuyRequestDao;
import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

@Service
public class BuyRequestService {
	@Autowired
	private BuyRequestDao knirdao;

//BL1001購入依頼登録
	public void requestRegist(SizaiDto sizaiDto) {
		knirdao.requestRegist(sizaiDto);
		}
//BL1002カテゴリ取得	
	public List<CategoryDto> getCategory(){
		
		return knirdao.getCategory();
	}

//BL1003ユーザー別資材一覧取得	
	public List<SizaiDto> getUserRequsetList(String startDate,String endDate,String userid){
		
		startDate = startDate + " " + "00:00:00";
		endDate = endDate + " " + "23:59:59";
		List<SizaiDto> sizaiList=null;
		
		sizaiList = knirdao.getUserRequsetList(startDate,endDate,userid);
		
		return sizaiList;	
	}
	

//BL1004購入依頼一件を取得	
	public SizaiDto getRequest(int id) {
		SizaiDto s=knirdao.getRequestById(id);
		return s;
		
	}
	
//BL1005購入依頼変更
	public boolean modifyRequest(SizaiDto s) {
		boolean b =	knirdao.modifyRequest(s);
		return b;
	}

//BL1006購入依頼撤回
	public boolean deleteRequest(int id) {
		boolean b = knirdao.deleteById(id);
		return b;
	}
	
}
