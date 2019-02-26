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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductService
 * @generated
 */
@ProviderType
public class ProductServiceWrapper implements ProductService,
	ServiceWrapper<ProductService> {
	public ProductServiceWrapper(ProductService productService) {
		_productService = productService;
	}

	@Override
	public int addProduct(java.lang.String uuid, java.lang.String productId,
		java.lang.String companyId, java.lang.String productName,
		java.lang.String productPrice) throws java.sql.SQLException {
		return _productService.addProduct(uuid, productId, companyId,
			productName, productPrice);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _productService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.product.service.model.Product> getProductByPrice(
		long price) throws java.sql.SQLException {
		return _productService.getProductByPrice(price);
	}

	@Override
	public ProductService getWrappedService() {
		return _productService;
	}

	@Override
	public void setWrappedService(ProductService productService) {
		_productService = productService;
	}

	private ProductService _productService;
}