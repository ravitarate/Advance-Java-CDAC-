package com.demo.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
				p.getPid(),p.getPname(),p.getPrice(),p.getQty(),p.getMfgdate()
		});
		/*if(n>0) {
			System.out.println("product added");
		}else {
			System.out.println("error");
		}*/
		
	}

	@Override
	public List<Product> findAllProduct() {
		/*List<Product>plist= jdbcTemplate.query("select * from product",new RowMapper() {

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
			
		});*/
		List<Product> plist=jdbcTemplate.query("select * from product",(rs,num)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(4));
			p.setPrice(rs.getDouble(3));
			Date dt=rs.getDate(5);
			LocalDate ldt=dt.toLocalDate();
			p.setMfgdate(ldt);
			return p;
		});
		return plist;
		
		
		
		
	}

	@Override
	public Product findById(int id) {
		Product p=jdbcTemplate.queryForObject("select * from product where pid=?", new Object[] {id},
				BeanPropertyRowMapper.newInstance(Product.class));
		return p;
	}

	@Override
	public List<Product> findByQuantity(int qty) {
		List<Product> plist=jdbcTemplate.query("select * from product where qty<?",new Object[] {qty},(rs,num)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(4));
			p.setPrice(rs.getDouble(3));
			Date dt=rs.getDate(5);
			LocalDate ldt=dt.toLocalDate();
			p.setMfgdate(ldt);
			return p;
		});
		if(plist.size()>0)
		    return plist;
		return null;
	}

	@Override
	public List<Product> findAllProductSorted() {
		List<Product> plist=jdbcTemplate.query("select * from product order by price",(rs,num)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(4));
			p.setPrice(rs.getDouble(3));
			Date dt=rs.getDate(5);
			LocalDate ldt=dt.toLocalDate();
			p.setMfgdate(ldt);
			return p;
		});
		return plist;
	}

	@Override
	public boolean updateById(int id, int qty, double price) {
		int n=jdbcTemplate.update("update product set qty=?,price=? where pid=?",new Object[] {qty,price,id});
		return n>0;
	}

	@Override
	public boolean removeById(int id) {
		int n=jdbcTemplate.update("delete from product where pid=?",new Object[] {id});
		return n>0;
	}
}
