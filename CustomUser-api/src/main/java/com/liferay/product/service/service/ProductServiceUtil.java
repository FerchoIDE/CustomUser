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

package com.liferay.product.service.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Product. This utility wraps
 * {@link com.liferay.product.service.service.impl.ProductServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ProductService
 * @see com.liferay.product.service.service.base.ProductServiceBaseImpl
 * @see com.liferay.product.service.service.impl.ProductServiceImpl
 * @generated
 */
@ProviderType
public class ProductServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.product.service.service.impl.ProductServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static int addProduct(java.lang.String uuid,
		java.lang.String productId, java.lang.String companyId,
		java.lang.String productName, java.lang.String productPrice)
		throws java.sql.SQLException {
		return getService()
				   .addProduct(uuid, productId, companyId, productName,
			productPrice);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.product.service.model.Product> getProductByPrice(
		long price) throws java.sql.SQLException {
		return getService().getProductByPrice(price);
	}

	public static ProductService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProductService, ProductService> _serviceTracker =
		ServiceTrackerFactory.open(ProductService.class);
}