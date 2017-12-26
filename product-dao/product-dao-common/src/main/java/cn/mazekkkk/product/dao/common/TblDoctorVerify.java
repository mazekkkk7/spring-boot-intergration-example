package cn.mazekkkk.product.dao.common;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author maze
 */
public class TblDoctorVerify implements Serializable {
    @NotNull(message = "id不能为空")
    private Integer id;

    private Integer doctorId;

    private String name;

    private String idCard;

    private String hospitalCode;

    private String hospitalName;

    private String deptCode;

    private String deptName;

    private String special;

    private Byte vocation;

    private Byte headStatus;

    private String headRemark;

    private Byte specialStatus;

    private String specialRemark;

    private Byte authStatus;

    private String authRemark;

    private String levelCode;

    private String levelName;

    private Byte titleStatus;

    private String titleRemark;

    private String biography;

    private String academicAchievements;

    private Byte biographyStatus;

    private String biographyRemark;

    private Byte academicStatus;

    private String academicRemark;

    private Byte detailStatus;

    private String detailRemark;

    private Date createTime;

    private Date updateTime;

    public TblDoctorVerify() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode == null ? null : hospitalCode.trim();
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName == null ? null : hospitalName.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special == null ? null : special.trim();
    }

    public Byte getVocation() {
        return vocation;
    }

    public void setVocation(Byte vocation) {
        this.vocation = vocation;
    }

    public Byte getHeadStatus() {
        return headStatus;
    }

    public void setHeadStatus(Byte headStatus) {
        this.headStatus = headStatus;
    }

    public String getHeadRemark() {
        return headRemark;
    }

    public void setHeadRemark(String headRemark) {
        this.headRemark = headRemark == null ? null : headRemark.trim();
    }

    public Byte getSpecialStatus() {
        return specialStatus;
    }

    public void setSpecialStatus(Byte specialStatus) {
        this.specialStatus = specialStatus;
    }

    public String getSpecialRemark() {
        return specialRemark;
    }

    public void setSpecialRemark(String specialRemark) {
        this.specialRemark = specialRemark == null ? null : specialRemark.trim();
    }

    public Byte getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(Byte authStatus) {
        this.authStatus = authStatus;
    }

    public String getAuthRemark() {
        return authRemark;
    }

    public void setAuthRemark(String authRemark) {
        this.authRemark = authRemark == null ? null : authRemark.trim();
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode == null ? null : levelCode.trim();
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public Byte getTitleStatus() {
        return titleStatus;
    }

    public void setTitleStatus(Byte titleStatus) {
        this.titleStatus = titleStatus;
    }

    public String getTitleRemark() {
        return titleRemark;
    }

    public void setTitleRemark(String titleRemark) {
        this.titleRemark = titleRemark == null ? null : titleRemark.trim();
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography == null ? null : biography.trim();
    }

    public String getAcademicAchievements() {
        return academicAchievements;
    }

    public void setAcademicAchievements(String academicAchievements) {
        this.academicAchievements = academicAchievements == null ? null : academicAchievements.trim();
    }

    public Byte getBiographyStatus() {
        return biographyStatus;
    }

    public void setBiographyStatus(Byte biographyStatus) {
        this.biographyStatus = biographyStatus;
    }

    public String getBiographyRemark() {
        return biographyRemark;
    }

    public void setBiographyRemark(String biographyRemark) {
        this.biographyRemark = biographyRemark == null ? null : biographyRemark.trim();
    }

    public Byte getAcademicStatus() {
        return academicStatus;
    }

    public void setAcademicStatus(Byte academicStatus) {
        this.academicStatus = academicStatus;
    }

    public String getAcademicRemark() {
        return academicRemark;
    }

    public void setAcademicRemark(String academicRemark) {
        this.academicRemark = academicRemark == null ? null : academicRemark.trim();
    }

    public Byte getDetailStatus() {
        return detailStatus;
    }

    public void setDetailStatus(Byte detailStatus) {
        this.detailStatus = detailStatus;
    }

    public String getDetailRemark() {
        return detailRemark;
    }

    public void setDetailRemark(String detailRemark) {
        this.detailRemark = detailRemark == null ? null : detailRemark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}