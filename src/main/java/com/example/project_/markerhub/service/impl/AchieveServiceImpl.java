package com.example.project_.markerhub.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.project_.common.lang.Result;
import com.example.project_.markerhub.entity.Achieve;
import com.example.project_.markerhub.entity.News;
import com.example.project_.markerhub.entity.PageData;
import com.example.project_.markerhub.mapper.AchieveMapper;
import com.example.project_.markerhub.service.AchieveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Service
public class AchieveServiceImpl extends ServiceImpl<AchieveMapper, Achieve> implements AchieveService {
    @Autowired
    AchieveService achieveService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private BeanPropertyRowMapper<Achieve> AchieveMapper = new BeanPropertyRowMapper<>(Achieve.class);

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Object> getMapper(String sql){
        List achieve = new ArrayList();
        achieve = jdbcTemplate.query(sql,AchieveMapper);
        return achieve;
    }
    //查询所有
    @Override
    public List<Achieve> findALL() {
        return jdbcTemplate.query("select * from achieve;", AchieveMapper);
    }

    //根据条件查询  按标题查询
    @Override
    public List<Achieve> findByCondition(Integer key){
        String sql="SELECT * FROM achieve WHERE sort = ?";
        Object[] args={key};
        int[] argTypes={Types.INTEGER};
        return jdbcTemplate.query(sql,args,argTypes,AchieveMapper);
    }
    //根据条件查询  按标题查询
    @Override
    public List<Achieve> findByTitle(String value){
        String sql="SELECT * FROM  achieve"+" WHERE title LIKE '%"+value+"%' AND sort = 1";
        List achieve = getMapper(sql);
        return achieve;
    }
    //更新数据
    @Override
    public void update(Achieve achieve){
        String sql ="update achieve set title =?,content =?,time =?,hot =?,participant_member =?,sort =?,achieve_name =?,img =? where id =?";
        jdbcTemplate.update(sql,achieve.getTitle(),achieve.getContent(),achieve.getTime(),achieve.getHot(),achieve.getParticipantMember(),achieve.getSort(),achieve.getAchieveName(),achieve.getImg(),achieve.getId());
    }
    //添加数据
    @Override
    public void insert(Achieve achieve){
        String sql="insert into achieve values(null,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,achieve.getTitle(),achieve.getContent(),achieve.getTime(),achieve.getHot(),achieve.getParticipantMember(),achieve.getSort(), achieve.getAchieveName(),achieve.getImg());
    }
    //删除数据
    @Override
    public void delete(Integer id){
        String sql="delete from achieve where id =?";
        Object[] args={id};
        int[] argTypes={Types.INTEGER};
        jdbcTemplate.update(sql,args,argTypes);
    }

    @Override
    public Achieve searchById(Integer id){
        Achieve achieve;
        String sql = "select * from achieve where id=?";
        Object[] args = {id};
        int[] argTypes = {Types.INTEGER};
        achieve = jdbcTemplate.queryForObject(sql,args,argTypes,AchieveMapper);
        return achieve;
    }
    @Override
    public Result getPageList(int pageNum, int pageSize) {
        IPage<Achieve> IPage = new Page<>(pageNum, pageSize);
        IPage<Achieve> page =  achieveService.page(IPage);
        int total = (int) page.getTotal();
        List<Achieve> records = page.getRecords();
        PageData<Achieve> objectPageData = new PageData(total, records);
        return Result.success(objectPageData);
    }
}