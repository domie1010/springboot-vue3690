package com.dao;

import com.entity.ShequguankongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShequguankongView;

/**
 * 社区管控 Dao 接口
 *
 * @author 
 */
public interface ShequguankongDao extends BaseMapper<ShequguankongEntity> {

   List<ShequguankongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
