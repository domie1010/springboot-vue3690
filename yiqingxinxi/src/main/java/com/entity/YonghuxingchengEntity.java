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
 * 用户行程
 *
 * @author 
 * @email
 */
@TableName("yonghuxingcheng")
public class YonghuxingchengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YonghuxingchengEntity() {

	}

	public YonghuxingchengEntity(T t) {
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
     * 地区
     */
    @TableField(value = "diqu_id")

    private Integer diquId;


    /**
     * 去的时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "qu_time")

    private Date quTime;


    /**
     * 回的时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "hui_time")

    private Date huiTime;


    /**
     * 去的缘由
     */
    @TableField(value = "yuanyou_content")

    private String yuanyouContent;


    /**
     * 添加时间
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
	 * 设置：地区
	 */
    public Integer getDiquId() {
        return diquId;
    }
    /**
	 * 获取：地区
	 */

    public void setDiquId(Integer diquId) {
        this.diquId = diquId;
    }
    /**
	 * 设置：去的时间
	 */
    public Date getQuTime() {
        return quTime;
    }
    /**
	 * 获取：去的时间
	 */

    public void setQuTime(Date quTime) {
        this.quTime = quTime;
    }
    /**
	 * 设置：回的时间
	 */
    public Date getHuiTime() {
        return huiTime;
    }
    /**
	 * 获取：回的时间
	 */

    public void setHuiTime(Date huiTime) {
        this.huiTime = huiTime;
    }
    /**
	 * 设置：去的缘由
	 */
    public String getYuanyouContent() {
        return yuanyouContent;
    }
    /**
	 * 获取：去的缘由
	 */

    public void setYuanyouContent(String yuanyouContent) {
        this.yuanyouContent = yuanyouContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：添加时间
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
        return "Yonghuxingcheng{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", diquId=" + diquId +
            ", quTime=" + quTime +
            ", huiTime=" + huiTime +
            ", yuanyouContent=" + yuanyouContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
