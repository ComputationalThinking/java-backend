package com.example.project_.markerhub.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project_.common.lang.Result;
import com.example.project_.markerhub.entity.Manager;
import com.example.project_.markerhub.entity.News;
import com.example.project_.markerhub.entity.PageData;
import com.example.project_.markerhub.mapper.NewsMapper;
import com.example.project_.markerhub.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;
//import orggit.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.api.scripting.ScriptUtils.convert;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {
    @Autowired
    NewsService newsService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private BeanPropertyRowMapper<News> NewsMapper = new BeanPropertyRowMapper<>(News.class);

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Object> getMapper(String sql){
        List message = new ArrayList();
        message = jdbcTemplate.query(sql,NewsMapper);
        return message;
    }
   //查询所有
   @Override
   public List<News> findAll() {
       List<News> list = new ArrayList<>();
       return jdbcTemplate.query("select * from news;", new BeanPropertyRowMapper<>(News.class));
   }

   //更新数据
   @Override
   public void update(News news){
       String sql = "UPDATE news set sort=?,title=?,author=?,content=?,time=?,img_boolean=?,img_src=? where id=?";
       jdbcTemplate.update(sql,news.getSort(),news.getTitle(),news.getAuthor(),news.getContent(),news.getTime(),news.getImg_boolean(),news.getImg_src(),news.getId());
   }
   //添加数据
   @Override
   public void insert(News news){
       String sql= "insert into news values (NULL,?,?,?,?,?,?,?)";
       jdbcTemplate.update(sql,news.getTitle(),news.getAuthor(),news.getContent(),news.getTime(),news.getImg_boolean(),news.getImg_src(),news.getSort());
   }
   //删除数据
   @Override
   public void delete(Integer id){
       String sql= "delete from news where id=?";
       jdbcTemplate.update(sql,id);
   }
    public List<News> setList(final List<Map<String, Object>> srcList, Class<News> clazz) {
        List<News> list = new ArrayList<>();
        for (int i=0;i<srcList.size();i++){
            try {
                News t = clazz.newInstance();
                Field[] fields = t.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (!"serialVersionUID".equals(field.getName())) {
                        //设置对象的访问权限，保证对private的属性的访问
                        field.setAccessible(true);
                        //读取配置转换字段名，并从map中取出数据
                        Object v = srcList.get(i).get(field.getName());
                        field.set(t, convert(v, field.getType()));
                    }
                }
                list.add(t);
            } catch (Exception ex) {
                ex.toString();
            }

        };
        return list;
    }

    @Override
   public List<News> conditionSearch(Integer sort,String title){
       List<News> list;
       String sql = "select * from news where title like ? and sort=?";
       Object[] args = {title,sort};
       int[] argTypes = {Types.VARCHAR,Types.INTEGER};
       list = jdbcTemplate.query(sql,args,argTypes,new BeanPropertyRowMapper<>(News.class));
//       list = setList(map,News.class);
       return list;
   }

   @Override
   public News searchById(Integer id){
        News news;
        String sql = "select * from news where id=?";
        Object[] args = {id};
        int[] argTypes = {Types.INTEGER};
        news = jdbcTemplate.queryForObject(sql,args,argTypes,new BeanPropertyRowMapper<>(News.class));
        return news;
   }
    @Override
    public Result getPageList(int pageNum, int pageSize) {
        IPage<News> IPage = new Page<>(pageNum, pageSize);
        IPage<News> page =  newsService.page(IPage);
        int total = (int) page.getTotal();
        List<News> records = page.getRecords();
        PageData<News> objectPageData = new PageData(total, records);
        return Result.success(objectPageData);
    }

    public int StringgetSort(String s){
        int sort = 0;
        switch (s){
            case "实验室资讯":sort = 0;break;
            case "国内信息化教育":sort = 1;break;
            case "国内实时活动资讯":sort = 2;break;
            case "国外资讯":sort = 3;break;
        }
        return sort;
    }

    public List<News> commonList(List<News> list_1,List<News> list_2){
        List<News> list = new ArrayList<>();
        for(int i=0;i<list_1.size();i++){
            for(int j=0;j<list_2.size();j++){
                if(list_1.get(i).getId() == list_2.get(j).getId())
                    list.add(list_1.get(i));
            }
        }
        return list;
    }

    @Override
    public Result getPageListSort(int pageNum, int pageSize,String sort,String title) {
        IPage<News> IPage = new Page<>(pageNum, pageSize);
        IPage<News> page =  newsService.page(IPage);
        int total = (int) page.getTotal();
        List<News> records = page.getRecords();
        List<News> list = conditionSearch(StringgetSort(sort),"%"+title+"%");
        List<News> newrec ;
//        for(int i = 0;i < records.size(); i ++){
//            if(records.get(i).getSort() == StringgetSort(sort))
//                newrec.add(records.get(i));
////            System.out.println(records.get(i));
//        }
        newrec = commonList(records,list);
        PageData<News> objectPageData = new PageData(newrec.size(), newrec);
        return Result.success(objectPageData);
    }

}


