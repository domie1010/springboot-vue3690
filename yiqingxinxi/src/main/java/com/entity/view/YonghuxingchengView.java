package com.entity.view;

import com.entity.YonghuxingchengEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户行程
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yonghuxingcheng")
public class YonghuxingchengView extends YonghuxingchengEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 diqu
			/**
			* 地区编号
			*/
			private String diquUuidNumber;
			/**
			* 地区名称
			*/
			private String diquName;
			/**
			* 地区位置
			*/
			private String diquAddress;
			/**
			* 地区风险等级
			*/
			private Integer fengxianTypes;
				/**
				* 地区风险等级的值
				*/
				private String fengxianValue;
			/**
			* 地区详情
			*/
			private String diquContent;

		//级联表 yonghu
			/**
			* 用户编号
			*/
			private String yonghuUuidNumber;
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public YonghuxingchengView() {

	}

	public YonghuxingchengView(YonghuxingchengEntity yonghuxingchengEntity) {
		try {
			BeanUtils.copyProperties(this, yonghuxingchengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}














				//级联表的get和set diqu

					/**
					* 获取： 地区编号
					*/
					public String getDiquUuidNumber() {
						return diquUuidNumber;
					}
					/**
					* 设置： 地区编号
					*/
					public void setDiquUuidNumber(String diquUuidNumber) {
						this.diquUuidNumber = diquUuidNumber;
					}

					/**
					* 获取： 地区名称
					*/
					public String getDiquName() {
						return diquName;
					}
					/**
					* 设置： 地区名称
					*/
					public void setDiquName(String diquName) {
						this.diquName = diquName;
					}

					/**
					* 获取： 地区位置
					*/
					public String getDiquAddress() {
						return diquAddress;
					}
					/**
					* 设置： 地区位置
					*/
					public void setDiquAddress(String diquAddress) {
						this.diquAddress = diquAddress;
					}

					/**
					* 获取： 地区风险等级
					*/
					public Integer getFengxianTypes() {
						return fengxianTypes;
					}
					/**
					* 设置： 地区风险等级
					*/
					public void setFengxianTypes(Integer fengxianTypes) {
						this.fengxianTypes = fengxianTypes;
					}


						/**
						* 获取： 地区风险等级的值
						*/
						public String getFengxianValue() {
							return fengxianValue;
						}
						/**
						* 设置： 地区风险等级的值
						*/
						public void setFengxianValue(String fengxianValue) {
							this.fengxianValue = fengxianValue;
						}

					/**
					* 获取： 地区详情
					*/
					public String getDiquContent() {
						return diquContent;
					}
					/**
					* 设置： 地区详情
					*/
					public void setDiquContent(String diquContent) {
						this.diquContent = diquContent;
					}

















				//级联表的get和set yonghu

					/**
					* 获取： 用户编号
					*/
					public String getYonghuUuidNumber() {
						return yonghuUuidNumber;
					}
					/**
					* 设置： 用户编号
					*/
					public void setYonghuUuidNumber(String yonghuUuidNumber) {
						this.yonghuUuidNumber = yonghuUuidNumber;
					}

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}










}
