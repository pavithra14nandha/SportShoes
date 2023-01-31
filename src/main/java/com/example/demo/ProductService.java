package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {
@Autowired
ProductRepo repop;

private final String FOLDER_PATH="C:\\images\\";
public String insert(String pname,String pbrand,float price,MultipartFile file) throws IllegalStateException, IOException
{
	Product pp= new Product();
	String fileinfo=FOLDER_PATH+file.getOriginalFilename();
	
	pp.setPname(pname);
	pp.setPbrand(pbrand);
	pp.setPrice(price);
	pp.setPath(fileinfo);
	
	Product pro=repop.save(pp);
	file.transferTo(new File(fileinfo));
	return "product uploaded";
	}
public List<Product> getall()
{
	return repop.findAll();
}
public void deletebyid(int id)
{
	repop.deleteById(id);
}
public Product update(Product p)
{
	
	Product pp= repop.findById(p.getPid()).orElse(null);
	pp.setPname(p.getPname());
	pp.setPbrand(p.getPbrand());
	pp.setPrice(p.getPrice());
	return repop.save(pp);
	}
public Float findprice(int id)
{
	float pric=repop.findprice(id);
	return pric;
}
}
