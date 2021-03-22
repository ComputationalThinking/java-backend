package com.example.project_.markerhub.service.impl;

import com.example.project_.markerhub.entity.Achieve;
import com.example.project_.markerhub.mapper.AchieveMapper;
import com.example.project_.markerhub.service.AchieveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.List;

@Service
public class AchieveServiceImpl extends ServiceImpl<AchieveMapper, Achieve> implements AchieveService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private BeanPropertyRowMapper<Achieve> AchieveMapper = new BeanPropertyRowMapper<>(Achieve.class);

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //查询所有
    @Override
    public List<Achieve> findALL() {
        return jdbcTemplate.query("select * from achieve;", AchieveMapper);
    }

    //根据条件查询  按标题查询
    @Override
    public List<Achieve> findByCondition(String value){
        String sql="SELECT * FROM achieve WHERE title LIKE '%' ? '%'";
        Object[] args={value};
        int[] argTypes={Types.VARCHAR};
        return jdbcTemplate.query(sql,args,argTypes,AchieveMapper);
    }
    //更新数据
    @Override
    public void update(Achieve achieve){
        String sql ="UPDATE achieve SET title =?,content =?,time =?,hot =?,participant_member =?,sort =?,achieve_name =?,img =?WHERE id =?";
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
}