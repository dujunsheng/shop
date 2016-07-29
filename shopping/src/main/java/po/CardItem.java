package po;

public class CardItem {
	private User user;
	private int card_id;
	private int g_id;
	private Goods good;
	private int g_quantity;
	private int u_id;
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public Goods getGood() {
		return good;
	}
	public void setGood(Goods good) {
		this.good = good;
	}
	public int getG_quantity() {
		return g_quantity;
	}
	public void setG_quantity(int g_quantity) {
		this.g_quantity = g_quantity;
	}
	public CardItem() {
		super();
	}
	
}
