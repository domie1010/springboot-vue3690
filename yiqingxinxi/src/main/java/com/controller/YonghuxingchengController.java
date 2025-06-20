
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
 * 用户行程
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yonghuxingcheng")
public class YonghuxingchengController {
    private static final Logger logger = LoggerFactory.getLogger(YonghuxingchengController.class);

    @Autowired
    private YonghuxingchengService yonghuxingchengService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private DiquService diquService;
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
        PageUtils page = yonghuxingchengService.queryPage(params);

        //字典表数据转换
        List<YonghuxingchengView> list =(List<YonghuxingchengView>)page.getList();
        for(YonghuxingchengView c:list){
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
        YonghuxingchengEntity yonghuxingcheng = yonghuxingchengService.selectById(id);
        if(yonghuxingcheng !=null){
            //entity转view
            YonghuxingchengView view = new YonghuxingchengView();
            BeanUtils.copyProperties( yonghuxingcheng , view );//把实体数据重构到view中

                //级联表
                DiquEntity diqu = diquService.selectById(yonghuxingcheng.getDiquId());
                if(diqu != null){
                    BeanUtils.copyProperties( diqu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setDiquId(diqu.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(yonghuxingcheng.getYonghuId());
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
    public R save(@RequestBody YonghuxingchengEntity yonghuxingcheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yonghuxingcheng:{}",this.getClass().getName(),yonghuxingcheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            yonghuxingcheng.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<YonghuxingchengEntity> queryWrapper = new EntityWrapper<YonghuxingchengEntity>()
            .eq("yonghu_id", yonghuxingcheng.getYonghuId())
            .eq("diqu_id", yonghuxingcheng.getDiquId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YonghuxingchengEntity yonghuxingchengEntity = yonghuxingchengService.selectOne(queryWrapper);
        if(yonghuxingchengEntity==null){
            yonghuxingcheng.setInsertTime(new Date());
            yonghuxingcheng.setCreateTime(new Date());
            yonghuxingchengService.insert(yonghuxingcheng);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YonghuxingchengEntity yonghuxingcheng, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yonghuxingcheng:{}",this.getClass().getName(),yonghuxingcheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            yonghuxingcheng.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<YonghuxingchengEntity> queryWrapper = new EntityWrapper<YonghuxingchengEntity>()
            .notIn("id",yonghuxingcheng.getId())
            .andNew()
            .eq("yonghu_id", yonghuxingcheng.getYonghuId())
            .eq("diqu_id", yonghuxingcheng.getDiquId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YonghuxingchengEntity yonghuxingchengEntity = yonghuxingchengService.selectOne(queryWrapper);
        if(yonghuxingchengEntity==null){
            yonghuxingchengService.updateById(yonghuxingcheng);//根据id更新
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
        yonghuxingchengService.deleteBatchIds(Arrays.asList(ids));
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
            List<YonghuxingchengEntity> yonghuxingchengList = new ArrayList<>();//上传的东西
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
                            YonghuxingchengEntity yonghuxingchengEntity = new YonghuxingchengEntity();
//                            yonghuxingchengEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            yonghuxingchengEntity.setDiquId(Integer.valueOf(data.get(0)));   //地区 要改的
//                            yonghuxingchengEntity.setQuTime(sdf.parse(data.get(0)));          //去的时间 要改的
//                            yonghuxingchengEntity.setHuiTime(sdf.parse(data.get(0)));          //回的时间 要改的
//                            yonghuxingchengEntity.setYuanyouContent("");//详情和图片
//                            yonghuxingchengEntity.setInsertTime(date);//时间
//                            yonghuxingchengEntity.setCreateTime(date);//时间
                            yonghuxingchengList.add(yonghuxingchengEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yonghuxingchengService.insertBatch(yonghuxingchengList);
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
