package com.entity.model;

import com.entity.HesuanyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 核酸预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HesuanyuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预约编号
     */
    private String hesuanyuyueUuidNumber;


    /**
     * 预约检测时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yuyueTime;


    /**
     * 检测点
     */
    private Integer jiancedianTypes;


    /**
     * 预约备注
     */
    private String yuyueContent;


    /**
     * 核酸预约状态
     */
    private Integer hesuanyuyueTypes;


    /**
     * 实际检测时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shijiTime;


    /**
     * 检测结果
     */
    private Integer jiancejieguoTypes;


    /**
     * 检测文件
     */
    private String hesuanyuyueFile;


    /**
     * 备注
     */
    private String beizhuContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约编号
	 */
    public String getHesuanyuyueUuidNumber() {
        return hesuanyuyueUuidNumber;
    }


    /**
	 * 设置：预约编号
	 */
    public void setHesuanyuyueUuidNumber(String hesuanyuyueUuidNumber) {
        this.hesuanyuyueUuidNumber = hesuanyuyueUuidNumber;
    }
    /**
	 * 获取：预约检测时间
	 */
    public Date getYuyueTime() {
        return yuyueTime;
    }


    /**
	 * 设置：预约检测时间
	 */
    public void setYuyueTime(Date yuyueTime) {
        this.yuyueTime = yuyueTime;
    }
    /**
	 * 获取：检测点
	 */
    public Integer getJiancedianTypes() {
        return jiancedianTypes;
    }


    /**
	 * 设置：检测点
	 */
    public void setJiancedianTypes(Integer jiancedianTypes) {
        this.jiancedianTypes = jiancedianTypes;
    }
    /**
	 * 获取：预约备注
	 */
    public String getYuyueContent() {
        return yuyueContent;
    }


    /**
	 * 设置：预约备注
	 */
    public void setYuyueContent(String yuyueContent) {
        this.yuyueContent = yuyueContent;
    }
    /**
	 * 获取：核酸预约状态
	 */
    public Integer getHesuanyuyueTypes() {
        return hesuanyuyueTypes;
    }


    /**
	 * 设置：核酸预约状态
	 */
    public void setHesuanyuyueTypes(Integer hesuanyuyueTypes) {
        this.hesuanyuyueTypes = hesuanyuyueTypes;
    }
    /**
	 * 获取：实际检测时间
	 */
    public Date getShijiTime() {
        return shijiTime;
    }


    /**
	 * 设置：实际检测时间
	 */
    public void setShijiTime(Date shijiTime) {
        this.shijiTime = shijiTime;
    }
    /**
	 * 获取：检测结果
	 */
    public Integer getJiancejieguoTypes() {
        return jiancejieguoTypes;
    }


    /**
	 * 设置：检测结果
	 */
    public void setJiancejieguoTypes(Integer jiancejieguoTypes) {
        this.jiancejieguoTypes = jiancejieguoTypes;
    }
    /**
	 * 获取：检测文件
	 */
    public String getHesuanyuyueFile() {
        return hesuanyuyueFile;
    }


    /**
	 * 设置：检测文件
	 */
    public void setHesuanyuyueFile(String hesuanyuyueFile) {
        this.hesuanyuyueFile = hesuanyuyueFile;
    }
    /**
	 * 获取：备注
	 */
    public String getBeizhuContent() {
        return beizhuContent;
    }


    /**
	 * 设置：备注
	 */
    public void setBeizhuContent(String beizhuContent) {
        this.beizhuContent = beizhuContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
