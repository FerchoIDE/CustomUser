/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.product.service.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.product.service.model.Product;
import com.liferay.product.service.service.base.ProductLocalServiceBaseImpl;

/**
 * The implementation of the product local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.product.service.service.ProductLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductLocalServiceBaseImpl
 * @see com.liferay.product.service.service.ProductLocalServiceUtil
 */

import aQute.bnd.annotation.ProviderType;

@ProviderType
public class ProductLocalServiceImpl extends ProductLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.product.service.service.ProductLocalServiceUtil} to access the product local service.
	 */
//	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	 @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Product> getProductByPrice(long price) throws SQLException {
		  return productFinder.getProductByPrice(price);
		 }
	 
	 private int addProduct(String uuid,
			 					String productId,
			 					String companyId,String productName,
			 					String productPrice) throws SQLException {
		// TODO Auto-generated method stub
		 return productFinder.addInventory(uuid, productId, companyId, productName, productPrice);

	}

	
}