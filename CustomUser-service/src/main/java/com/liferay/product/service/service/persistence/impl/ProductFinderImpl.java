/**
 * 
 */
package com.liferay.product.service.service.persistence.impl;

import java.util.List;

import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.product.service.model.Product;
import com.liferay.product.service.model.impl.ProductImpl;
import com.liferay.product.service.service.persistence.ProductFinder;

/**
 * @author Fercho
 *
 */
public class ProductFinderImpl extends ProductFinderBaseImpl implements ProductFinder {

	
	 public List<Product>  getProductByPrice(long price){
		  Session session=null;
		  try{
		   //open ORM Session
		                        session=openSession();
		                      //get sql query return in default.xml
		                        String sql=CustomSQLUtil.get(getClass(),"getAllProduct");
		   SQLQuery sqlQuery=session.createSQLQuery(sql);
		   sqlQuery.setCacheable(false);
		                       //Add entity to be searched
		                        sqlQuery.addEntity("Product",ProductImpl.class);
		                       //Replace positional parameters in the query
		                        QueryPos queryPos=QueryPos.getInstance(sqlQuery);
		   queryPos.add(price);
		                       //Execute query and return result
		                         return (List<Product>)sqlQuery.list();
		  }catch(Exception e){
		   
		  }finally {
		   closeSession(session);
		  }
		  return null;
		 }
	
}
