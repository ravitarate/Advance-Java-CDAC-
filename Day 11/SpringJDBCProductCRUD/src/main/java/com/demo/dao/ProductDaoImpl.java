package com.demo.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	 @Autowired
     JdbcTemplate jdbcTemplate;

	public void saveProduct(Product p) {
		int n=jdbcTemplate.update("insert into product values(?,?,?,?,?)",new Object[] {
				p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getMfgdate()
		});
		/*if(n>0) {
			System.out.println("product added");
		}else {
			System.out.println("error");
		}*/
		
	}

	@Override
	public List<Product> findAllProduct() {
		List<Product>plist= jdbcTemplate.query("select * from product",new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int num) throws SQLException {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setQty(rs.getInt(3));
				p.setPrice(rs.getDouble(4));
				Date dt=rs.getDate(5);
				LocalDate ldt=dt.toLocalDate();
				p.setMfgdate(ldt);
				return p;
			}
			
		});
		/*List<Product> plist=jdbcTemplate.query("select * from product",(rs,num)=>{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			Date dt=rs.getDate(5);
			LocalDate ldt=dt.toLocalDate();
			p.setMfgdate(ldt);
			return p;
		});*/
		return plist;
	}
}
