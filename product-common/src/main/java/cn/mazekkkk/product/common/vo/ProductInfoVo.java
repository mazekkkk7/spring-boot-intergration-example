/**
 * 
 */
package cn.mazekkkk.product.common.vo;

/**
 * 产品对象
 * 
 * @author sean
 *
 */
@SuppressWarnings("serial")
public class ProductInfoVo implements java.io.Serializable{

	//产品ID
	private Long id;
	//产品名称
	private String name;
	//产品价格
	private Double curPrice;
	//图片URL
	private String imgUrl;
	//产品库存数量
	private Integer invQty;
	
	//查询时临时用到变量
	private String ids;
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCurPrice() {
		return curPrice;
	}

	public void setCurPrice(Double curPrice) {
		this.curPrice = curPrice;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getInvQty() {
		return invQty;
	}

	public void setInvQty(Integer invQty) {
		this.invQty = invQty;
	}
	
	
}
