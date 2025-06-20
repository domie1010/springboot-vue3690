package com.entity.view;

import com.entity.DiquEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 地区
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("diqu")
public class DiquView extends DiquEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 地区风险等级的值
		*/
		private String fengxianValue;



	public DiquView() {

	}

	public DiquView(DiquEntity diquEntity) {
		try {
			BeanUtils.copyProperties(this, diquEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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














}
