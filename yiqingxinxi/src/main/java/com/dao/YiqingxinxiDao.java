package com.dao;

import com.entity.YiqingxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YiqingxinxiView;

/**
 * 疫情信息 Dao 接口
 *
 * @author 
 */
public interface YiqingxinxiDao extends BaseMapper<YiqingxinxiEntity> {

   List<YiqingxinxiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
