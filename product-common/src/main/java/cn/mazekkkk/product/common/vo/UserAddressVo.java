/**
 * 
 */
package cn.mazekkkk.product.common.vo;

/**
 * 用户地址
 * 
 * @author sean
 *
 */
@SuppressWarnings("serial")
public class UserAddressVo implements java.io.Serializable{

	//会员ID
	private Long userId;
	//收货人
	private String linkName;
	//收货手机号
	private String linkPhone;
	//email 
	private String linkEmail;
	//
	private String linkStreet;
	//小区
	private String community;
	//邮编
	private String postCode;
	//默认收货地址
	private String defaulted;
	//国家
	private String country;
	
	//省份
	private String province;
	
	//城市
	private String city;
	
	//城区
	private String district;
	
	private String type;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	public String getLinkEmail() {
		return linkEmail;
	}
	public void setLinkEmail(String linkEmail) {
		this.linkEmail = linkEmail;
	}
	public String getLinkStreet() {
		return linkStreet;
	}
	public void setLinkStreet(String linkStreet) {
		this.linkStreet = linkStreet;
	}
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getDefaulted() {
		return defaulted;
	}
	public void setDefaulted(String defaulted) {
		this.defaulted = defaulted;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
