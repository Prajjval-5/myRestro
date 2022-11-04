package com.restro.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restro.dao.restroDao;
import com.restro.exception.ResourceNotFoundException;
import com.restro.model.restro;
import com.restro.service.restroService;

@Service
public class retroServiceImpl implements restroService{

	@Autowired
	private restroDao restrodao;
	
	public retroServiceImpl(restroDao restrodao) {
		super();
		this.restrodao = restrodao;
	}


	@Override
	public restro addProduct(restro productname) {
		return this.restrodao.save(productname);
	}
	
    @Override
    public List<restro> getProduct(restro productname) {
        return this.restrodao.findAll();
    }
    

	@Override
	public restro getProductById(Integer productId) {
        return restrodao.findById(productId).orElseThrow( ()->
        new ResourceNotFoundException("product", "Id", productId));
	}
    


    @Override
    public restro updateProduct(restro productname, Integer productId)
    {
        //We need to check whether employee with the given id is exsits in the DB or not
        restro existingProduct = restrodao.findById(productId).orElseThrow( ()->
        new ResourceNotFoundException("product","Id",productId));;
        
        //if the id found then we need to set the new values to update
        existingProduct.setProductDesc(productname.getProductDesc());
        existingProduct.setProductName(productname.getProductName());
        existingProduct.setProductPrice(productname.getProductPrice());
        existingProduct.setProductImg(productname.getProductImg());
        //save the exiting the employee
        restrodao.save(existingProduct);
        return existingProduct;
    }


	@Override
	public void deleteProduct(Integer productId) {
		        //we need to check whether employee record exists in the DB or not
		restrodao.findById(productId).orElseThrow( ()->
		new ResourceNotFoundException("product","Id",productId));
		restrodao.deleteById(productId);
		}		
}
