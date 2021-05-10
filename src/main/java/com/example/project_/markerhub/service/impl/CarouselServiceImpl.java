package com.example.project_.markerhub.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.project_.common.lang.Result;
import com.example.project_.markerhub.entity.Carousel;
import com.example.project_.markerhub.entity.Achieve;
import com.example.project_.markerhub.entity.Manager;
import com.example.project_.markerhub.entity.Member;
import com.example.project_.markerhub.entity.PageData;
import com.example.project_.markerhub.mapper.CarouselMapper;
import com.example.project_.markerhub.service.CarouselService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.api.scripting.ScriptUtils.convert;

@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {

    @Autowired
    CarouselService carouselService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private BeanPropertyRowMapper<Carousel> CarouselMapper = new BeanPropertyRowMapper<>(Carousel.class);
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Object> getMapper(String sql){
        List message = new ArrayList();
        message = jdbcTemplate.query(sql,CarouselMapper);
        return message;
    }
    //查询全部
    @Override
    public List<Carousel> findALL(){
        return jdbcTemplate.query("select * from carousel",new BeanPropertyRowMapper<>(Carousel.class));
    }
    //添加
    @Override
    public void insert(Carousel carousel){
        String sql = "insert into carousel values(null,?,?,?)";
        jdbcTemplate.update(sql,carousel.getPic(),carousel.getContent(),carousel.getPage());
    }
    //删除
    @Override
    public void delete(Integer id){
        String sql = "delete from carousel where id= ?";
        jdbcTemplate.update(sql,id);
    }
    //更新
    @Override
    public void update(Carousel carousel){
        String sql = "update carousel set pic = ?,page = ?,content = ? where id = ?";
        jdbcTemplate.update(sql,carousel.getPic(),carousel.getPage(),carousel.getContent(),carousel.getId());
    }
    
    public List<Carousel> setList(final List<Map<String, Object>> srcList, Class<Carousel> clazz) {
        List<Carousel> list = new ArrayList<>();
        for (int i=0;i<srcList.size();i++){
            try {
                Carousel t = clazz.newInstance();
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
    public Carousel searchById(Integer id){
        Carousel carousel;
        String sql = "select * from carousel where id=?";
        Object[] args = {id};
        int [] argTypes = {Types.INTEGER};
        carousel = jdbcTemplate.queryForObject(sql,args,argTypes,new BeanPropertyRowMapper<>(Carousel.class));
        return carousel;
    }

    @Override
    public List<Carousel> findByCondition(Integer key){
        List<Carousel> list1;
        String sql="SELECT * FROM carousel WHERE page = ?";
        Object[] args={key};
        int[] argTypes={Types.INTEGER};
        return jdbcTemplate.query(sql,args,argTypes,CarouselMapper);
    }
    @Override
    public Result getPageList(int pageNum, int pageSize) {
        IPage<Carousel> IPage = new Page<>(pageNum, pageSize);
        IPage<Carousel> page = carouselService.page(IPage);
        int total = (int) page.getTotal();
        List<Carousel> records = page.getRecords();
        PageData<Carousel> objectPageData = new PageData(total, records);
        return Result.success(objectPageData);
    }
}
