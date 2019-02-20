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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.product.service.model.Product;
import com.liferay.product.service.service.base.ProductServiceBaseImpl;
import com.liferay.product.service.service.persistence.impl.ProductFinderImpl;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the product remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.product.service.service.ProductService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductServiceBaseImpl
 * @see com.liferay.product.service.service.ProductServiceUtil
 */
@ProviderType
public class ProductServiceImpl extends ProductServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.product.service.service.ProductServiceUtil} to access the product remote service.
	 */
	private static final Log log = LogFactoryUtil.getLog(ProductServiceImpl.class);
	
	public List<Product> getProductByPrice(long price) throws SQLException {
		  log.info(price);
		  System.out.println(price);
		  return productFinder.getProductByPrice(price);
		 }
}