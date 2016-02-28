/** 

 * @Project : platform-dao-mapper

 * @Title : UserContactVo.java

 * @Package cn.cloudmirror.platform.dao.vo

 * @Description : TODO

 * @author wangjianwei

 * @date 2015-11-2 上午10:35:21

 * @Copyright : 2015 www.cloudmirror.cn Inc. All rights reserved.

 * @version V1.0 

 */
package cn.mazekkkk.product.common.vo;

/**
 * 
 * 会员联系方式 Vo
 * 
 * @ClassName UserContactVo

 * @Description TODO

 * @author wangjianwei

 * @date 2015-11-2


 */
public class UserContactVo {

	private long id;
	
	private String name;
	
	private String phone;
	
	private String email;
	
	private String telphone;
	
	private String status;
	
	private long userId;
	
	private String type;
	
	private String defaulted;
	
	private long contactId;
	
	

	public String getDefaulted() {
		return defaulted;
	}

	public void setDefaulted(String defaulted) {
		this.defaulted = defaulted;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	
	
	
}
