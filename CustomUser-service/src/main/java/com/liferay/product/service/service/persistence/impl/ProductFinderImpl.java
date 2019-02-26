/**
 * 
 */
package com.liferay.product.service.service.persistence.impl;

import java.sql.SQLException;
import java.util.List;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.product.service.model.Product;
import com.liferay.product.service.model.impl.ProductImpl;
import com.liferay.product.service.service.persistence.ProductFinder;

/**
 * @author Fercho
 *
 */
public class ProductFinderImpl extends ProductFinderBaseImpl implements ProductFinder {
	private static final Log log = LogFactoryUtil.getLog(ProductFinderImpl.class);
    
	
	 public List<Product>  getProductByPrice(long price) throws SQLException{
		  CustomSQL _customSQL = new CustomSQL(); 
		  Session session=null;
		  try{
			 System.out.println("ProductFinderImpl"+price);
		   //open ORM Session
		   session=openSession();
		   //get sql query return in default.xml
		   String sql=_customSQL.get(getClass(),"getAllProduct");
		   SQLQuery sqlQuery=session.createSQLQuery(sql);
		   log.info(sql);
		   System.out.println(sql);
		   sqlQuery.setCacheable(false);
		                       //Add entity to be searched
		   sqlQuery.addEntity("Product",ProductImpl.class);
		                       //Replace positional parameters in the query
		   QueryPos queryPos=QueryPos.getInstance(sqlQuery);
		   queryPos.add(price);
		                       //Execute query and return result
		   System.out.println(sqlQuery.list().toString());
		   return (List<Product>)sqlQuery.list();
		  }catch(Exception e){
		   e.printStackTrace();
		  }finally {
		   closeSession(session);
		  }
		  return null;
		 }
	 
	 public int addInventory(String uuid, 
			 				 String productId, 
			 				 String companyId,
			 				 String productName,
			 				 String productPrice
				) throws SQLException {
		 CustomSQL _customSQL = new CustomSQL();	
		 Session session = null;
			try {
				session = openSession();
				String sql=_customSQL.get(getClass(),"addProduct");
				System.out.println(sql);
				SQLQuery queryObject = session.createSQLQuery(sql);
				queryObject.setCacheable(false);
				queryObject.addEntity("Product",ProductImpl.class);
				QueryPos qPos = QueryPos.getInstance(queryObject);
				qPos.add(uuid);
				qPos.add(productId);
				qPos.add(companyId);
				qPos.add(productName);
				qPos.add(productPrice);
				return queryObject.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			closeSession(session);
			}
			return 0;
		}
	
	 	
}
