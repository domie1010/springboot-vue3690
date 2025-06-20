package com.entity.vo;

import com.entity.DiquEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 地区
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("diqu")
public class DiquVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 地区编号
     */

    @TableField(value = "diqu_uuid_number")
    private String diquUuidNumber;


    /**
     * 地区名称
     */

    @TableField(value = "diqu_name")
    private String diquName;


    /**
     * 地区位置
     */

    @TableField(value = "diqu_address")
    private String diquAddress;


    /**
     * 地区风险等级
     */

    @TableField(value = "fengxian_types")
    private Integer fengxianTypes;


    /**
     * 地区详情
     */

    @TableField(value = "diqu_content")
    private String diquContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：地区编号
	 */
    public String getDiquUuidNumber() {
        return diquUuidNumber;
    }


    /**
	 * 获取：地区编号
	 */

    public void setDiquUuidNumber(String diquUuidNumber) {
        this.diquUuidNumber = diquUuidNumber;
    }
    /**
	 * 设置：地区名称
	 */
    public String getDiquName() {
        return diquName;
    }


    /**
	 * 获取：地区名称
	 */

    public void setDiquName(String diquName) {
        this.diquName = diquName;
    }
    /**
	 * 设置：地区位置
	 */
    public String getDiquAddress() {
        return diquAddress;
    }


    /**
	 * 获取：地区位置
	 */

    public void setDiquAddress(String diquAddress) {
        this.diquAddress = diquAddress;
    }
    /**
	 * 设置：地区风险等级
	 */
    public Integer getFengxianTypes() {
        return fengxianTypes;
    }


    /**
	 * 获取：地区风险等级
	 */

    public void setFengxianTypes(Integer fengxianTypes) {
        this.fengxianTypes = fengxianTypes;
    }
    /**
	 * 设置：地区详情
	 */
    public String getDiquContent() {
        return diquContent;
    }


    /**
	 * 获取：地区详情
	 */

    public void setDiquContent(String diquContent) {
        this.diquContent = diquContent;
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

}
