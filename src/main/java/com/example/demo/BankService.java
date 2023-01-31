package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
@Autowired	
BankRepo repob;

public Bank insertamt(Bank b)
{
	return repob.save(b);
}
public Bank findbalance(int id)
{
	return repob.getById(id);
}

}
