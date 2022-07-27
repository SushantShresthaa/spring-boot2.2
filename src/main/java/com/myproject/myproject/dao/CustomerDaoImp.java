/*
 * package com.myproject.myproject.dao;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.jdbc.core.BeanPropertyRowMapper; import
 * org.springframework.jdbc.core.JdbcTemplate; import
 * org.springframework.stereotype.Repository;
 * 
 * @Repository public class CustomerDaoImp implements CustomerDao {
 * 
 * @Autowired private JdbcTemplate jdbcTemplate;
 * 
 * @Override public void deleteById(int id) { String sql =
 * "delete from customers where id=?;"; jdbcTemplate.update(sql, new Object[] {
 * id }); }
 * 
 * @Override public void save(CustomerData customers) { String sql =
 * "insert into customers(name, address, phone, dob, image, password) values (?,?,?,?,?,?);"
 * ;
 * 
 * jdbcTemplate.update(sql, new Object[] { customers.getName(),
 * customers.getAddress(), customers.getPhone(), customers.getDob(),
 * customers.getImage(), customers.getPassword()
 * 
 * }); }
 * 
 * @Override public List<CustomerData> findAll() { String sql =
 * "select id, name, password, address, phone, dob, image from customers;";
 * List<CustomerData> customers = jdbcTemplate.query(sql, new
 * BeanPropertyRowMapper<>(CustomerData.class));
 * 
 * return customers; }
 * 
 * 
 * @Override public CustomerData findById(int id) { String sql =
 * "select id, name, password, address, phone, dob, image from customers where id=?;"
 * ; List<CustomerData> customers = jdbcTemplate.query(sql, new Object[] { id },
 * new BeanPropertyRowMapper<>(CustomerData.class)); return customers.get(0); }
 * 
 * @Override public void update(CustomerData customers) { String sql =
 * "update customers set name=?,password=?, address=?, phone=?, dob=?, image=? where id=?;"
 * ; jdbcTemplate.update(sql, new Object[] { customers.getName(),
 * customers.getAddress(), customers.getPhone(), customers.getDob(),
 * customers.getImage(), customers.getPassword()
 * 
 * }); }
 * 
 * @Override public CustomerData findByNameAndPasseword(String name, String
 * password) { String sql=
 * "select id, name, password, address, phone, dob, image from customers where name=? and password=?;"
 * ; List<CustomerData> customer= jdbcTemplate.query(sql, new Object[] {name,
 * password}, new BeanPropertyRowMapper<>(CustomerData.class)); return
 * customer.size() >0? customer.get(0): null; }
 * 
 * @Override public List<CustomerData> findUserByName(String name) { String sql=
 * "select id, name, password, address, phone, dob, image from customers where name=?;"
 * ; List<CustomerData> customer= jdbcTemplate.query(sql, new Object[] {name},
 * new BeanPropertyRowMapper<>(CustomerData.class)); return customer; }
 * 
 * 
 * @Override public CustomerData findByName(String name) { String sql =
 * "select password from customers where name=?;"; List<CustomerData> customers
 * = jdbcTemplate.query(sql, new Object[] { name }, new
 * BeanPropertyRowMapper<>(CustomerData.class)); return customers.size() >0?
 * customers.get(0): null; }
 * 
 * @Override public void updatePassword(String name, String password) { String
 * sql = "update customers set password=? where name=?;";
 * jdbcTemplate.update(sql, new Object[] {password, name}); }
 * 
 * 
 * }
 * 
 * 
 */