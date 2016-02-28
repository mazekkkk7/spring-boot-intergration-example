/**
 * 
 */
package cn.mazekkkk.product.common.vo;

/**
 * 会员 优惠券信息
 * 
 * @author sean
 *
 */
@SuppressWarnings("serial")
public class UserCouponsVo implements java.io.Serializable{
	
	//会员ID
	private Long userId;
	//优惠券ID
	private Long couponsId;
	//优惠券名称
	private String couponsName; 
	//优惠券代码
	private String counponsCode;
	//订单折扣率
	private String orderDisc;
	//优惠劵价值
	private String discAmount;
	//活动名称
	private String name;
	//活动描述
	private String description;
	//平台ID
	private Long pcId;
	//优惠券描述
	private String couponDisc;
	//优惠券开始时间
	private String beginTime;
    //优惠券结束时间
	private String endTime;
	//有效时长
	private String validTime;
	//活动ID
	private Long activityId; 
	//活动类型
	private Byte type;
	
	//终端机ID
	private Long machineId;
	
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public Byte getType() {
		return type;
	}
	public void setType(Byte type) {
		this.type = type;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCouponsId() {
		return couponsId;
	}
	public void setCouponsId(Long couponsId) {
		this.couponsId = couponsId;
	}
	public String getCouponsName() {
		return couponsName;
	}
	public void setCouponsName(String couponsName) {
		this.couponsName = couponsName;
	}
	public String getCounponsCode() {
		return counponsCode;
	}
	public void setCounponsCode(String counponsCode) {
		this.counponsCode = counponsCode;
	}
	public String getOrderDisc() {
		return orderDisc;
	}
	public void setOrderDisc(String orderDisc) {
		this.orderDisc = orderDisc;
	}
	public String getDiscAmount() {
		return discAmount;
	}
	public void setDiscAmount(String discAmount) {
		this.discAmount = discAmount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getPcId() {
		return pcId;
	}
	public void setPcId(Long pcId) {
		this.pcId = pcId;
	}
	public String getCouponDisc() {
		return couponDisc;
	}
	public void setCouponDisc(String couponDisc) {
		this.couponDisc = couponDisc;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getValidTime() {
		return validTime;
	}
	public void setValidTime(String validTime) {
		this.validTime = validTime;
	}
	public Long getMachineId() {
		return machineId;
	}
	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}
	
	
}
