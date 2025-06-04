package com.demo.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	 @Autowired
	 JdbcTemplate jdbcTemplate;

	public List<Product> findAllProduct() {
		return jdbcTemplate.query("select * from product",(rs,num)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(4));
			p.setPrice(rs.getDouble(3));
			p.setMfgdate(rs.getDate(5).toLocalDate());
			return p;
		});
	}

	@Override
	public void insertProduct(@Valid Product product) {
		jdbcTemplate.update("insert into product values(?,?,?,?,?)",new Object[] {product.getPid(),
				product.getPname(),product.getPrice(),product.getQty(),product.getMfgdate()});
		
	}

	@Override
	public Product findById(int pid) {
		return jdbcTemplate.queryForObject("select * from product where pid=?",new Object[] {pid},
				BeanPropertyRowMapper.newInstance(Product.class));
	}

	@Override
	public void modifyProduct(Product product) {
		jdbcTemplate.update("update product set pname=?,price=?,qty=?,mfgdate=? where pid=?)",new Object[] {
				product.getPname(),product.getPrice(),product.getQty(),product.getMfgdate(),product.getPid()});
		
		
	}

	@Override
	public void removeById(int pid) {
		jdbcTemplate.update("delete from product where pid=?",new Object[] {pid});
		
	}
}
