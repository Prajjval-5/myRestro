package com.restro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.restro.model.restro;
import com.restro.service.restroService;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class controller {
	
		@Autowired
	    private restroService restroservice;


	    //add question
	    @PostMapping("add")
	    public ResponseEntity<restro> add(@RequestBody restro productname) {
	        return ResponseEntity.ok(this.restroservice.addProduct(productname));
	    }
	
	    
	    @GetMapping("{productId}")
	    public ResponseEntity<restro> getEmployeeById(@PathVariable("productId") Integer productId)
	    {
	     return new ResponseEntity<restro>(restroservice.getProductById(productId), HttpStatus.OK);    
	    }
	    
	    @GetMapping("/get")
	    public List<restro> get( restro productname) {
	        return this.restroservice.getProduct(productname);
	    }
	    
	    @PutMapping("{productId}")
	    public ResponseEntity<restro> updateEmployee(@PathVariable("productId")Integer productId,
	            @RequestBody restro productname)
	    {
	        return new ResponseEntity<restro>(restroservice.updateProduct(productname, productId),HttpStatus.OK);
	    }
	    
	    @DeleteMapping("{productId}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable("productId") Integer productId)
	    {
	        //delete
	    	restroservice.deleteProduct(productId);
	        return new ResponseEntity<String>("product deleted Successfully!",HttpStatus.OK);
	    }

}
