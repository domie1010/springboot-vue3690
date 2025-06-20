
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
 * 核酸预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/hesuanyuyue")
public class HesuanyuyueController {
    private static final Logger logger = LoggerFactory.getLogger(HesuanyuyueController.class);

    @Autowired
    private HesuanyuyueService hesuanyuyueService;


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
        PageUtils page = hesuanyuyueService.queryPage(params);

        //字典表数据转换
        List<HesuanyuyueView> list =(List<HesuanyuyueView>)page.getList();
        for(HesuanyuyueView c:list){
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
        HesuanyuyueEntity hesuanyuyue = hesuanyuyueService.selectById(id);
        if(hesuanyuyue !=null){
            //entity转view
            HesuanyuyueView view = new HesuanyuyueView();
            BeanUtils.copyProperties( hesuanyuyue , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(hesuanyuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R save(@RequestBody HesuanyuyueEntity hesuanyuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,hesuanyuyue:{}",this.getClass().getName(),hesuanyuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role)){
            hesuanyuyue.setHesuanyuyueTypes(1);
            hesuanyuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }

        Wrapper<HesuanyuyueEntity> queryWrapper = new EntityWrapper<HesuanyuyueEntity>()
            .eq("yonghu_id", hesuanyuyue.getYonghuId())
            .eq("hesuanyuyue_uuid_number", hesuanyuyue.getHesuanyuyueUuidNumber())
            .eq("jiancedian_types", hesuanyuyue.getJiancedianTypes())
            .eq("hesuanyuyue_types", hesuanyuyue.getHesuanyuyueTypes())
            .eq("jiancejieguo_types", hesuanyuyue.getJiancejieguoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HesuanyuyueEntity hesuanyuyueEntity = hesuanyuyueService.selectOne(queryWrapper);
        if(hesuanyuyueEntity==null){
            hesuanyuyue.setInsertTime(new Date());
            hesuanyuyue.setCreateTime(new Date());
            hesuanyuyueService.insert(hesuanyuyue);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HesuanyuyueEntity hesuanyuyue, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,hesuanyuyue:{}",this.getClass().getName(),hesuanyuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            hesuanyuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<HesuanyuyueEntity> queryWrapper = new EntityWrapper<HesuanyuyueEntity>()
            .notIn("id",hesuanyuyue.getId())
            .andNew()
            .eq("yonghu_id", hesuanyuyue.getYonghuId())
            .eq("hesuanyuyue_uuid_number", hesuanyuyue.getHesuanyuyueUuidNumber())
            .eq("jiancedian_types", hesuanyuyue.getJiancedianTypes())
            .eq("hesuanyuyue_types", hesuanyuyue.getHesuanyuyueTypes())
            .eq("jiancejieguo_types", hesuanyuyue.getJiancejieguoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HesuanyuyueEntity hesuanyuyueEntity = hesuanyuyueService.selectOne(queryWrapper);
        if("".equals(hesuanyuyue.getHesuanyuyueFile()) || "null".equals(hesuanyuyue.getHesuanyuyueFile())){
                hesuanyuyue.setHesuanyuyueFile(null);
        }
        if(hesuanyuyueEntity==null){
            hesuanyuyueService.updateById(hesuanyuyue);//根据id更新
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
        hesuanyuyueService.deleteBatchIds(Arrays.asList(ids));
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
            List<HesuanyuyueEntity> hesuanyuyueList = new ArrayList<>();//上传的东西
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
                            HesuanyuyueEntity hesuanyuyueEntity = new HesuanyuyueEntity();
//                            hesuanyuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            hesuanyuyueEntity.setHesuanyuyueUuidNumber(data.get(0));                    //预约编号 要改的
//                            hesuanyuyueEntity.setYuyueTime(sdf.parse(data.get(0)));          //预约检测时间 要改的
//                            hesuanyuyueEntity.setJiancedianTypes(Integer.valueOf(data.get(0)));   //检测点 要改的
//                            hesuanyuyueEntity.setYuyueContent("");//详情和图片
//                            hesuanyuyueEntity.setHesuanyuyueTypes(Integer.valueOf(data.get(0)));   //核酸预约状态 要改的
//                            hesuanyuyueEntity.setShijiTime(sdf.parse(data.get(0)));          //实际检测时间 要改的
//                            hesuanyuyueEntity.setJiancejieguoTypes(Integer.valueOf(data.get(0)));   //检测结果 要改的
//                            hesuanyuyueEntity.setHesuanyuyueFile(data.get(0));                    //检测文件 要改的
//                            hesuanyuyueEntity.setBeizhuContent("");//详情和图片
//                            hesuanyuyueEntity.setInsertTime(date);//时间
//                            hesuanyuyueEntity.setCreateTime(date);//时间
                            hesuanyuyueList.add(hesuanyuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //预约编号
                                if(seachFields.containsKey("hesuanyuyueUuidNumber")){
                                    List<String> hesuanyuyueUuidNumber = seachFields.get("hesuanyuyueUuidNumber");
                                    hesuanyuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> hesuanyuyueUuidNumber = new ArrayList<>();
                                    hesuanyuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("hesuanyuyueUuidNumber",hesuanyuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //预约编号
                        List<HesuanyuyueEntity> hesuanyuyueEntities_hesuanyuyueUuidNumber = hesuanyuyueService.selectList(new EntityWrapper<HesuanyuyueEntity>().in("hesuanyuyue_uuid_number", seachFields.get("hesuanyuyueUuidNumber")));
                        if(hesuanyuyueEntities_hesuanyuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HesuanyuyueEntity s:hesuanyuyueEntities_hesuanyuyueUuidNumber){
                                repeatFields.add(s.getHesuanyuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [预约编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        hesuanyuyueService.insertBatch(hesuanyuyueList);
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
