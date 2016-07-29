package Serivce;

import java.util.List;

import carditemDao.CardItemDao;
import po.CardItem;
import utils.PageBean;

public class CardItemService {
	private CardItemDao cardItemDao = new CardItemDao();
	
	public PageBean<CardItem> findByU_id(int u_id, int pc){
		return cardItemDao.findByU_id(u_id , pc);
	}
	
	public int deleteCardItem(int c_id){
		return cardItemDao.deleteCardItem(c_id);
	}
	
	public int addCardItem(CardItem cardItem){
		return cardItemDao.addCardItem(cardItem);
	}
	
	public int updateCardItemQuantity(CardItem cardItem){
		return cardItemDao.updateCardItemQuantity(cardItem);
	}

}
