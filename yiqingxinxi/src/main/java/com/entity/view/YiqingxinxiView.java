package com.entity.view;

import com.entity.YiqingxinxiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 疫情信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yiqingxinxi")
public class YiqingxinxiView extends YiqingxinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 疫情信息类型的值
		*/
		private String yiqingxinxiValue;



	public YiqingxinxiView() {

	}

	public YiqingxinxiView(YiqingxinxiEntity yiqingxinxiEntity) {
		try {
			BeanUtils.copyProperties(this, yiqingxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 疫情信息类型的值
			*/
			public String getYiqingxinxiValue() {
				return yiqingxinxiValue;
			}
			/**
			* 设置： 疫情信息类型的值
			*/
			public void setYiqingxinxiValue(String yiqingxinxiValue) {
				this.yiqingxinxiValue = yiqingxinxiValue;
			}














}
