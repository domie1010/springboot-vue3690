package com.entity.view;

import com.entity.HesuanyuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 核酸预约
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("hesuanyuyue")
public class HesuanyuyueView extends HesuanyuyueEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 检测点的值
		*/
		private String jiancedianValue;
		/**
		* 核酸预约状态的值
		*/
		private String hesuanyuyueValue;
		/**
		* 检测结果的值
		*/
		private String jiancejieguoValue;



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

	public HesuanyuyueView() {

	}

	public HesuanyuyueView(HesuanyuyueEntity hesuanyuyueEntity) {
		try {
			BeanUtils.copyProperties(this, hesuanyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 检测点的值
			*/
			public String getJiancedianValue() {
				return jiancedianValue;
			}
			/**
			* 设置： 检测点的值
			*/
			public void setJiancedianValue(String jiancedianValue) {
				this.jiancedianValue = jiancedianValue;
			}
			/**
			* 获取： 核酸预约状态的值
			*/
			public String getHesuanyuyueValue() {
				return hesuanyuyueValue;
			}
			/**
			* 设置： 核酸预约状态的值
			*/
			public void setHesuanyuyueValue(String hesuanyuyueValue) {
				this.hesuanyuyueValue = hesuanyuyueValue;
			}
			/**
			* 获取： 检测结果的值
			*/
			public String getJiancejieguoValue() {
				return jiancejieguoValue;
			}
			/**
			* 设置： 检测结果的值
			*/
			public void setJiancejieguoValue(String jiancejieguoValue) {
				this.jiancejieguoValue = jiancejieguoValue;
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
