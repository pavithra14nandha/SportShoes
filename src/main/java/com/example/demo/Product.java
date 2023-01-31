package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int pid;
private String pname;
private String pbrand;
private float price;
private String path;


}
