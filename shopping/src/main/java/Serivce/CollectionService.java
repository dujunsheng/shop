package Serivce;

import java.util.List;

import collectionDao.CollectionDao;
import po.Collection;
import utils.PageBean;

public class CollectionService {
	private CollectionDao collectionDao = new CollectionDao();
	
	public PageBean<Collection> findByU_id(int u_id, int pc){
		return collectionDao.findByU_id(u_id, pc);
	}
	
	public int addColleciton(Collection collection){
		return collectionDao.addColleciton(collection);
	}
	
	public  int deleteCollection(Collection collection){
		return collectionDao.deleteCollection(collection);
	}
}
