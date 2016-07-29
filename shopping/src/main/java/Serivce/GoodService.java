package Serivce;

import java.util.List;

import goodDao.GoodDao;
import po.Goods;
import utils.Condition;
import utils.PageBean;

public class GoodService {
	private GoodDao goodDao = new GoodDao();
	
	public Goods findByG_id(int g_id){
		return goodDao.findByG_id(g_id);
	}
	
	public PageBean<Goods> findAll(int pc){
		return goodDao.findAll(pc);
	}
	
	public PageBean<Goods> findByC_id(int c_id, int pc){
		return goodDao.findByC_id(c_id, pc);
	}
	
	public int deleteByPrimaryKey(int g_id){
		return goodDao.deleteByPrimaryKey(g_id);
	}
	
	public int insert(Goods good){
		return goodDao.insert(good);
	}
	
	public int insertSelective(Goods good){
		return goodDao.insertSelective(good);
	}
	
	public int updateByPrimaryKeySelective(Goods good){
		return goodDao.updateByPrimaryKeySelective(good);
	}
	
	public Goods findByName(String name){
		return goodDao.findByName(name);
	}
	
	public PageBean<Goods> findByCondition(Condition condition, int pc){
		return goodDao.findByCondition(condition, pc);
	}
}
