
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 地区
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/diqu")
public class DiquController {
    private static final Logger logger = LoggerFactory.getLogger(DiquController.class);

    @Autowired
    private DiquService diquService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ShequguanliyuanService shequguanliyuanService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("社区管理员".equals(role))
            params.put("shequguanliyuanId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = diquService.queryPage(params);

        //字典表数据转换
        List<DiquView> list =(List<DiquView>)page.getList();
        for(DiquView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DiquEntity diqu = diquService.selectById(id);
        if(diqu !=null){
            //entity转view
            DiquView view = new DiquView();
            BeanUtils.copyProperties( diqu , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DiquEntity diqu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,diqu:{}",this.getClass().getName(),diqu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<DiquEntity> queryWrapper = new EntityWrapper<DiquEntity>()
            .eq("diqu_uuid_number", diqu.getDiquUuidNumber())
            .eq("diqu_name", diqu.getDiquName())
            .eq("diqu_address", diqu.getDiquAddress())
            .eq("fengxian_types", diqu.getFengxianTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DiquEntity diquEntity = diquService.selectOne(queryWrapper);
        if(diquEntity==null){
            diqu.setCreateTime(new Date());
            diquService.insert(diqu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DiquEntity diqu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,diqu:{}",this.getClass().getName(),diqu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<DiquEntity> queryWrapper = new EntityWrapper<DiquEntity>()
            .notIn("id",diqu.getId())
            .andNew()
            .eq("diqu_uuid_number", diqu.getDiquUuidNumber())
            .eq("diqu_name", diqu.getDiquName())
            .eq("diqu_address", diqu.getDiquAddress())
            .eq("fengxian_types", diqu.getFengxianTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DiquEntity diquEntity = diquService.selectOne(queryWrapper);
        if(diquEntity==null){
            diquService.updateById(diqu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        diquService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<DiquEntity> diquList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            DiquEntity diquEntity = new DiquEntity();
//                            diquEntity.setDiquUuidNumber(data.get(0));                    //地区编号 要改的
//                            diquEntity.setDiquName(data.get(0));                    //地区名称 要改的
//                            diquEntity.setDiquAddress(data.get(0));                    //地区位置 要改的
//                            diquEntity.setFengxianTypes(Integer.valueOf(data.get(0)));   //地区风险等级 要改的
//                            diquEntity.setDiquContent("");//详情和图片
//                            diquEntity.setCreateTime(date);//时间
                            diquList.add(diquEntity);


                            //把要查询是否重复的字段放入map中
                                //地区编号
                                if(seachFields.containsKey("diquUuidNumber")){
                                    List<String> diquUuidNumber = seachFields.get("diquUuidNumber");
                                    diquUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> diquUuidNumber = new ArrayList<>();
                                    diquUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("diquUuidNumber",diquUuidNumber);
                                }
                        }

                        //查询是否重复
                         //地区编号
                        List<DiquEntity> diquEntities_diquUuidNumber = diquService.selectList(new EntityWrapper<DiquEntity>().in("diqu_uuid_number", seachFields.get("diquUuidNumber")));
                        if(diquEntities_diquUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DiquEntity s:diquEntities_diquUuidNumber){
                                repeatFields.add(s.getDiquUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [地区编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        diquService.insertBatch(diquList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
