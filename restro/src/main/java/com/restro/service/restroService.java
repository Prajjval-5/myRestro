package com.restro.service;

import java.util.List;

//import java.util.List;

import com.restro.model.restro;

public interface restroService {

    public restro addProduct(restro productname);
	public List<restro> getProduct(restro productname);
    //FindByID
    restro getProductById(Integer productId);
    public restro updateProduct(restro productname, Integer productId);
    //Delete
    public void deleteProduct(Integer productId);
	

}
