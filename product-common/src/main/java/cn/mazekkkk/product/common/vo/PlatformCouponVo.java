package cn.mazekkkk.product.common.vo;

import java.io.Serializable;
import java.util.Date;

public class PlatformCouponVo implements Serializable {
    private Long id;
    private String code;

    private Long activityId;

    private Date validBeginTime;

    private Date validEndTime;
	//有效时长
    private Integer validTime;
    
    private String couponType;

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
	//活动类型
	private String type;
    
	//优惠券名称
	private String couponsName; 
	//优惠券代码
	private String counponsCode;
	
	//终端机ID
	private Long  machineId;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPcId() {
        return pcId;
    }

    public void setPcId(Long pcId) {
        this.pcId = pcId;
    }

    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }


    public Date getValidBeginTime() {
        return validBeginTime;
    }

    public void setValidBeginTime(Date validBeginTime) {
        this.validBeginTime = validBeginTime;
    }

    public Date getValidEndTime() {
        return validEndTime;
    }

    public void setValidEndTime(Date validEndTime) {
        this.validEndTime = validEndTime;
    }


    public Integer getValidTime() {
        return validTime;
    }

    public void setValidTime(Integer validTime) {
        this.validTime = validTime;
    }

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public Long getMachineId() {
		return machineId;
	}

	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}
    
    
}