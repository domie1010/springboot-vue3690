package com.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 地区疫情每日管理
 *
 * @author 
 * @email
 */
@TableName("diquyiqingmeiriguanli")
public class DiquyiqingmeiriguanliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DiquyiqingmeiriguanliEntity() {

	}

	public DiquyiqingmeiriguanliEntity(T t) {
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
     * 今日确诊人数
     */
    @TableField(value = "jinriquezhen_number")

    private Integer jinriquezhenNumber;


    /**
     * 累计确诊人数
     */
    @TableField(value = "leijiquezhen_number")

    private Integer leijiquezhenNumber;


    /**
     * 今日治愈人数
     */
    @TableField(value = "jinrizhiyu_number")

    private Integer jinrizhiyuNumber;


    /**
     * 累计治愈人数
     */
    @TableField(value = "leijizhiyu_number")

    private Integer leijizhiyuNumber;


    /**
     * 今日死亡人数
     */
    @TableField(value = "jinrisiwang_number")

    private Integer jinrisiwangNumber;


    /**
     * 累计死亡人数
     */
    @TableField(value = "leijisiwang_number")

    private Integer leijisiwangNumber;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "suoshu_time")

    private Date suoshuTime;


    /**
     * 记录时间
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
	 * 设置：今日确诊人数
	 */
    public Integer getJinriquezhenNumber() {
        return jinriquezhenNumber;
    }
    /**
	 * 获取：今日确诊人数
	 */

    public void setJinriquezhenNumber(Integer jinriquezhenNumber) {
        this.jinriquezhenNumber = jinriquezhenNumber;
    }
    /**
	 * 设置：累计确诊人数
	 */
    public Integer getLeijiquezhenNumber() {
        return leijiquezhenNumber;
    }
    /**
	 * 获取：累计确诊人数
	 */

    public void setLeijiquezhenNumber(Integer leijiquezhenNumber) {
        this.leijiquezhenNumber = leijiquezhenNumber;
    }
    /**
	 * 设置：今日治愈人数
	 */
    public Integer getJinrizhiyuNumber() {
        return jinrizhiyuNumber;
    }
    /**
	 * 获取：今日治愈人数
	 */

    public void setJinrizhiyuNumber(Integer jinrizhiyuNumber) {
        this.jinrizhiyuNumber = jinrizhiyuNumber;
    }
    /**
	 * 设置：累计治愈人数
	 */
    public Integer getLeijizhiyuNumber() {
        return leijizhiyuNumber;
    }
    /**
	 * 获取：累计治愈人数
	 */

    public void setLeijizhiyuNumber(Integer leijizhiyuNumber) {
        this.leijizhiyuNumber = leijizhiyuNumber;
    }
    /**
	 * 设置：今日死亡人数
	 */
    public Integer getJinrisiwangNumber() {
        return jinrisiwangNumber;
    }
    /**
	 * 获取：今日死亡人数
	 */

    public void setJinrisiwangNumber(Integer jinrisiwangNumber) {
        this.jinrisiwangNumber = jinrisiwangNumber;
    }
    /**
	 * 设置：累计死亡人数
	 */
    public Integer getLeijisiwangNumber() {
        return leijisiwangNumber;
    }
    /**
	 * 获取：累计死亡人数
	 */

    public void setLeijisiwangNumber(Integer leijisiwangNumber) {
        this.leijisiwangNumber = leijisiwangNumber;
    }
    /**
	 * 设置：所属日期
	 */
    public Date getSuoshuTime() {
        return suoshuTime;
    }
    /**
	 * 获取：所属日期
	 */

    public void setSuoshuTime(Date suoshuTime) {
        this.suoshuTime = suoshuTime;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：记录时间
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
        return "Diquyiqingmeiriguanli{" +
            "id=" + id +
            ", jinriquezhenNumber=" + jinriquezhenNumber +
            ", leijiquezhenNumber=" + leijiquezhenNumber +
            ", jinrizhiyuNumber=" + jinrizhiyuNumber +
            ", leijizhiyuNumber=" + leijizhiyuNumber +
            ", jinrisiwangNumber=" + jinrisiwangNumber +
            ", leijisiwangNumber=" + leijisiwangNumber +
            ", suoshuTime=" + suoshuTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
