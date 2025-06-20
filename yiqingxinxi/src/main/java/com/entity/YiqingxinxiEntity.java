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
 * 疫情信息
 *
 * @author 
 * @email
 */
@TableName("yiqingxinxi")
public class YiqingxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YiqingxinxiEntity() {

	}

	public YiqingxinxiEntity(T t) {
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
     * 疫情信息名称
     */
    @TableField(value = "yiqingxinxi_name")

    private String yiqingxinxiName;


    /**
     * 疫情信息类型
     */
    @TableField(value = "yiqingxinxi_types")

    private Integer yiqingxinxiTypes;


    /**
     * 疫情信息内容
     */
    @TableField(value = "yiqingxinxi_content")

    private String yiqingxinxiContent;


    /**
     * 疫情信息发布时间
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
	 * 设置：疫情信息名称
	 */
    public String getYiqingxinxiName() {
        return yiqingxinxiName;
    }
    /**
	 * 获取：疫情信息名称
	 */

    public void setYiqingxinxiName(String yiqingxinxiName) {
        this.yiqingxinxiName = yiqingxinxiName;
    }
    /**
	 * 设置：疫情信息类型
	 */
    public Integer getYiqingxinxiTypes() {
        return yiqingxinxiTypes;
    }
    /**
	 * 获取：疫情信息类型
	 */

    public void setYiqingxinxiTypes(Integer yiqingxinxiTypes) {
        this.yiqingxinxiTypes = yiqingxinxiTypes;
    }
    /**
	 * 设置：疫情信息内容
	 */
    public String getYiqingxinxiContent() {
        return yiqingxinxiContent;
    }
    /**
	 * 获取：疫情信息内容
	 */

    public void setYiqingxinxiContent(String yiqingxinxiContent) {
        this.yiqingxinxiContent = yiqingxinxiContent;
    }
    /**
	 * 设置：疫情信息发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：疫情信息发布时间
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
        return "Yiqingxinxi{" +
            "id=" + id +
            ", yiqingxinxiName=" + yiqingxinxiName +
            ", yiqingxinxiTypes=" + yiqingxinxiTypes +
            ", yiqingxinxiContent=" + yiqingxinxiContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
