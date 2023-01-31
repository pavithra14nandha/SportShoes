package com.example.demo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProductController {
@Autowired
ProductService service;
Logger log= Logger.getAnonymousLogger();
String FOLDER_PATH="C:\\images\\";
/*@RequestMapping("/insert")
public ModelAndView insert(HttpServletRequest request,HttpServletResponse response,@RequestParam("name")String name,
		@RequestParam("brand")String brand,@RequestParam("price")float price,@RequestParam("fpath") MultipartFile fpath)
{
	log.info("entered in insertproduct");
		ModelAndView mv= new ModelAndView();
	Product p = new Product();
	p.setPname(name);
	p.setPbrand(brand);
	p.setPrice(price);
	String fileinfo=FOLDER_PATH+fpath.getOriginalFilename();
	p.setPath(fileinfo);
	Product product=service.insert(p);
	if(product!=null)
	{
		mv.setViewName("display.jsp");
	}
	return mv;
}*/
@PostMapping("/insertproduct")
public ResponseEntity<?> insert(@RequestParam("pname")String pname,@RequestParam("pbrand")String pbrand,
		@RequestParam("price")Float price,@RequestParam("path")MultipartFile path) throws IllegalStateException, IOException
{
	String response=service.insert(pname, pbrand, price, path);
return ResponseEntity.status(HttpStatus.OK).body(response);
}

@RequestMapping("/getall")
public ModelAndView getall(HttpServletRequest request,HttpServletResponse response)
{
	log.info("entered in display");
		ModelAndView mv =new ModelAndView();
	List<Product> list=service.getall();
	mv.setViewName("displaydata.jsp");
	mv.addObject("list", list);
	return mv;
}
@RequestMapping("/getalladmin")
public ModelAndView getalladmin(HttpServletRequest request,HttpServletResponse response)
{
	log.info("entered in display");
		ModelAndView mv =new ModelAndView();
	List<Product> list=service.getall();
	mv.setViewName("adminproduct.jsp");
	mv.addObject("list", list);
	return mv;
}
@DeleteMapping("/deleteproduct/{id}")
public String deletebyId(@PathVariable("id")int id)
{
	service.deletebyid(id);
	return "deleted the product "+ id;
}
@PutMapping("/updateproduct")
public Product updateproduct(@RequestBody Product p)
{
	return service.update(p);
}
@RequestMapping("/getprice")
public float getprice(@RequestParam("pid") int pid )
{
	return service.findprice(pid);
}
}
