package demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJdbcTest {

    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test(){

        //创建连接池
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.1.8:3306/spring");
        dataSource.setUsername("root");
        dataSource.setPassword("xinran0949@mySql");

        //创建jdbc模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("insert into account values (null,?,?)","xixi",100d);
    }

    @Test
    public void test2(){

        //创建连接池
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://172.23.6.92:3306/mml_syj");
        dataSource.setUsername("testuser");
        dataSource.setPassword("test&20190911");

        //创建jdbc模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("update pa_sale_red_packet set Status=1 where SaleOrgId=210996");
    }

    @Test
    public void test3(){

        jdbcTemplate.update("update pa_sale_red_packet set Status=1 where SaleOrgId=210996");
    }

    @Test
    public void test4(){//查询操作：查询单个字段

        //String.class指定查询结果返回值类型
        String result =
                jdbcTemplate.queryForObject("select ConfigJson from mml_syj.pa_sale_red_packet where SaleOrgId=?",String.class,210996);

        System.out.println("打印查询结果：\n\t" + result);
    }

    @Test
    public void test5(){//查询操作：查询多个字段，返回对象的集合
        //rowMapper接收
        List<SaleRedPacket> list = jdbcTemplate.query("select * from mml_syj.pa_sale_red_packet", new MyRowMapper());

        for (SaleRedPacket s:list){
            System.out.println(s.toString());
        }
    }


}

class MyRowMapper implements RowMapper<SaleRedPacket>{

    @Override
    public SaleRedPacket mapRow(ResultSet resultSet, int i) throws SQLException {
        SaleRedPacket saleRedPacket = new SaleRedPacket();
        saleRedPacket.setPaId(resultSet.getInt("PaId"));
        saleRedPacket.setSaleOrgId(resultSet.getInt("SaleOrgId"));
        saleRedPacket.setStatus(resultSet.getInt("Status"));
        saleRedPacket.setConfigJson(resultSet.getString("ConfigJson"));
        saleRedPacket.setUpdateTime(resultSet.getTimestamp("UpdateTime"));
        saleRedPacket.setMinBalance(resultSet.getDouble("ShowOfMinBalance"));
        saleRedPacket.setMinServFee(resultSet.getDouble("MinSevFee"));
        saleRedPacket.setPercent(resultSet.getDouble("Percent"));

        return saleRedPacket;
    }
}
