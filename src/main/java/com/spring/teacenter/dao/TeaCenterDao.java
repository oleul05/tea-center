package com.spring.teacenter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;  
import com.spring.teacenter.Util.DBUtil;
import com.spring.teacenter.controller.HomeController;
import com.spring.teacenter.model.Customer;
import com.spring.teacenter.model.Product;

public class TeaCenterDao {
	
	private static final Logger logger = LoggerFactory.getLogger(TeaCenterDao.class);
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}

	public static boolean checkClient(String username, String password) {
		boolean st = false;

		try {
			Connection con = DBUtil.getConnection();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM owner WHERE username =? and password =?");
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			st = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return st;
	}
	
	public static boolean customerLogin(String username, String password) {
		boolean st = false;

		try {
			Connection con = DBUtil.getConnection();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM customer WHERE username =? and password =?");
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			st = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return st;
	}
	
	public  int saveProduct(Product product) {
		int status = 0;
		
		try{  
        	Connection con = DBUtil.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into product(name) values (?)");  // insert the value into the client table
            ps.setString(1, product.getName());
            status = ps.executeUpdate(); // Exucute the query            
              
        }catch(Exception ex){
        	ex.printStackTrace();
        } 		
		return status;
	}
	
	public  int saveCustomer(Customer cus) {
		int status = 0;
		
		try{  
        	Connection con = DBUtil.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into customer(username, password, name, surname, floor, building, roomno, information) values (?,?,?,?,?,?,?,?)");  // insert the value into the client table
            ps.setString(1, cus.getUsername());
            ps.setString(2, cus.getPassword());
            ps.setString(3, cus.getName());
            ps.setString(4, cus.getSurname());
            ps.setString(5, cus.getFloor());
            ps.setString(6, cus.getBuilding());
            ps.setString(7, cus.getRoomno());
            ps.setString(8, cus.getInformation());
           
            status = ps.executeUpdate(); // Exucute the query            
              
        }catch(Exception ex){
        	ex.printStackTrace();
        } 		
		return status;
	}
	
	public int updateProduct(Product product) {
		int status = 0;
		try{  
        	Connection con = DBUtil.getConnection();  
            PreparedStatement ps=con.prepareStatement("update product set name = ? where id =?");
            ps.setString(1, product.getName());
            ps.setInt(2, product.getId());
            status = ps.executeUpdate();         
              
        }catch(Exception ex){
        	ex.printStackTrace();
        }
		return status;
	}
	
	public int updateCustomer(Customer customer) {
		int status = 0;
		
		try{  
        	Connection con = DBUtil.getConnection();  
            PreparedStatement ps=con.prepareStatement("update customer set username = ?,password =?, name=?,surname=?,floor=?,building=?,roomno=?,information=? where id =?");
            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getPassword());
            ps.setString(3, customer.getName());
            ps.setString(4, customer.getSurname());
            ps.setString(5, customer.getFloor());
            ps.setString(6, customer.getBuilding());
            ps.setString(7, customer.getRoomno());
            ps.setString(8, customer.getInformation());
            ps.setInt(9, customer.getId());
            /*ps.setString(1, product.getName());
            ps.setInt(2, product.getId());*/
            status = ps.executeUpdate();         
              
        }catch(Exception ex){
        	ex.printStackTrace();
        }
		
		return status;
	}
	public int deleteProduct(int id) {
		int status = 0;
		try {
			Connection con = DBUtil.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from product where id =?");
            ps.setInt(1, id);
            status = ps.executeUpdate();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public int deleteCustomer(int id) {
		int status = 0;
		try {
			Connection con = DBUtil.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from customer where id =?");
            ps.setInt(1, id);
            status = ps.executeUpdate();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public List<Product> getAllProduct() {
		List<Product> product = new ArrayList<Product>();
		try{  
			 Connection con = DBUtil.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from product");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){   
	            	Product p = new Product();  
	            	
	            	p.setId(rs.getInt(1));
	            	p.setName(rs.getString(2));
	            	
	            	product.add(p);
	            }  
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
		return product;
	}
	
	public List<Customer> getAllCustomer() {
		List<Customer> customerList = new ArrayList<Customer>();
		
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from customer");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt(1));
				c.setUsername(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setName(rs.getString(4));
				c.setSurname(rs.getString(5));
				c.setFloor(rs.getString(6));
				c.setBuilding(rs.getString(7));
				c.setRoomno(rs.getString(8));
				c.setInformation(rs.getString(9));
				
				customerList.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return customerList;
	}
	
	public Product getProduct(int id) {
		Product product = new Product();
		
		try {
			Connection con = DBUtil.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from product where id =?"); 
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){    
            	product.setId(rs.getInt(1));
            	product.setName(rs.getString(2));
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public Customer getCustomerById(int id) {
		Customer customer = new Customer();
		try {
			Connection con = DBUtil.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from customer where id =?"); 
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){    
            	customer.setId(rs.getInt(1));
            	customer.setUsername(rs.getString(2));
            	customer.setPassword(rs.getString(3));
            	customer.setName(rs.getString(4));
            	customer.setSurname(rs.getString(5));
            	customer.setFloor(rs.getString(6));
            	customer.setBuilding(rs.getString(7));
            	customer.setRoomno(rs.getString(8));
            	customer.setInformation(rs.getString(9));
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
}
