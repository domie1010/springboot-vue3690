package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 核酸预约
 *
 * @author 
 * @email
 */
@TableName("hesuanyuyue")
public class HesuanyuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HesuanyuyueEntity() {

	}

	public HesuanyuyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预约编号
     */
    @TableField(value = "hesuanyuyue_uuid_number")

    private String hesuanyuyueUuidNumber;


    /**
     * 预约检测时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "yuyue_time")

    private Date yuyueTime;


    /**
     * 检测点
     */
    @TableField(value = "jiancedian_types")

    private Integer jiancedianTypes;


    /**
     * 预约备注
     */
    @TableField(value = "yuyue_content")

    private String yuyueContent;


    /**
     * 核酸预约状态
     */
    @TableField(value = "hesuanyuyue_types")

    private Integer hesuanyuyueTypes;


    /**
     * 实际检测时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "shiji_time")

    private Date shijiTime;


    /**
     * 检测结果
     */
    @TableField(value = "jiancejieguo_types")

    private Integer jiancejieguoTypes;


    /**
     * 检测文件
     */
    @TableField(value = "hesuanyuyue_file")

    private String hesuanyuyueFile;


    /**
     * 备注
     */
    @TableField(value = "beizhu_content")

    private String beizhuContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预约编号
	 */
    public String getHesuanyuyueUuidNumber() {
        return hesuanyuyueUuidNumber;
    }
    /**
	 * 获取：预约编号
	 */

    public void setHesuanyuyueUuidNumber(String hesuanyuyueUuidNumber) {
        this.hesuanyuyueUuidNumber = hesuanyuyueUuidNumber;
    }
    /**
	 * 设置：预约检测时间
	 */
    public Date getYuyueTime() {
        return yuyueTime;
    }
    /**
	 * 获取：预约检测时间
	 */

    public void setYuyueTime(Date yuyueTime) {
        this.yuyueTime = yuyueTime;
    }
    /**
	 * 设置：检测点
	 */
    public Integer getJiancedianTypes() {
        return jiancedianTypes;
    }
    /**
	 * 获取：检测点
	 */

    public void setJiancedianTypes(Integer jiancedianTypes) {
        this.jiancedianTypes = jiancedianTypes;
    }
    /**
	 * 设置：预约备注
	 */
    public String getYuyueContent() {
        return yuyueContent;
    }
    /**
	 * 获取：预约备注
	 */

    public void setYuyueContent(String yuyueContent) {
        this.yuyueContent = yuyueContent;
    }
    /**
	 * 设置：核酸预约状态
	 */
    public Integer getHesuanyuyueTypes() {
        return hesuanyuyueTypes;
    }
    /**
	 * 获取：核酸预约状态
	 */

    public void setHesuanyuyueTypes(Integer hesuanyuyueTypes) {
        this.hesuanyuyueTypes = hesuanyuyueTypes;
    }
    /**
	 * 设置：实际检测时间
	 */
    public Date getShijiTime() {
        return shijiTime;
    }
    /**
	 * 获取：实际检测时间
	 */

    public void setShijiTime(Date shijiTime) {
        this.shijiTime = shijiTime;
    }
    /**
	 * 设置：检测结果
	 */
    public Integer getJiancejieguoTypes() {
        return jiancejieguoTypes;
    }
    /**
	 * 获取：检测结果
	 */

    public void setJiancejieguoTypes(Integer jiancejieguoTypes) {
        this.jiancejieguoTypes = jiancejieguoTypes;
    }
    /**
	 * 设置：检测文件
	 */
    public String getHesuanyuyueFile() {
        return hesuanyuyueFile;
    }
    /**
	 * 获取：检测文件
	 */

    public void setHesuanyuyueFile(String hesuanyuyueFile) {
        this.hesuanyuyueFile = hesuanyuyueFile;
    }
    /**
	 * 设置：备注
	 */
    public String getBeizhuContent() {
        return beizhuContent;
    }
    /**
	 * 获取：备注
	 */

    public void setBeizhuContent(String beizhuContent) {
        this.beizhuContent = beizhuContent;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Hesuanyuyue{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", hesuanyuyueUuidNumber=" + hesuanyuyueUuidNumber +
            ", yuyueTime=" + yuyueTime +
            ", jiancedianTypes=" + jiancedianTypes +
            ", yuyueContent=" + yuyueContent +
            ", hesuanyuyueTypes=" + hesuanyuyueTypes +
            ", shijiTime=" + shijiTime +
            ", jiancejieguoTypes=" + jiancejieguoTypes +
            ", hesuanyuyueFile=" + hesuanyuyueFile +
            ", beizhuContent=" + beizhuContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
