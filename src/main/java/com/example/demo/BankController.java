package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BankController {
@Autowired
BankService serviceb;
@Autowired
ProductService servicep;


@PostMapping("/insertbank")
public Bank insertAmt(@RequestBody Bank b)
{
	return serviceb.insertamt(b);
}
@RequestMapping("/payment")
public ModelAndView bankcontrol(HttpServletRequest request,HttpServletResponse response)
{
	ModelAndView mv= new ModelAndView();
	Product p =new Product();
	p.setPrice(Float.parseFloat(request.getParameter("price")));
    float pricee=p.getPrice();
    Bank b= new Bank();
    b.setId(Integer.parseInt(request.getParameter("id")));
	int bid=b.getId();
	Bank bal=serviceb.findbalance(bid);
	float balance=bal.getBankbalance();
     if(pricee<balance) {
	mv.setViewName("payment.jsp");

}
     else
     {
    	 mv.setViewName("paymentfail.jsp");
     }
return mv;
}
}

