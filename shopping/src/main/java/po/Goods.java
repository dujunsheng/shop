package po;

public class Goods {
    private Integer gId;

    private String gName;

    private Float gPrice;

    private String gPicture;

    private Integer gQuantity;

    private Integer cId;

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    public Float getgPrice() {
        return gPrice;
    }

    public void setgPrice(Float gPrice) {
        this.gPrice = gPrice;
    }

    public String getgPicture() {
        return gPicture;
    }

    public void setgPicture(String gPicture) {
        this.gPicture = gPicture == null ? null : gPicture.trim();
    }

    public Integer getgQuantity() {
        return gQuantity;
    }

    public void setgQuantity(Integer gQuantity) {
        this.gQuantity = gQuantity;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }
}