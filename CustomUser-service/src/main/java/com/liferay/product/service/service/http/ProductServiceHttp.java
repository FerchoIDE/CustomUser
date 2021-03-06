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

package com.liferay.product.service.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.liferay.product.service.service.ProductServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link ProductServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductServiceSoap
 * @see HttpPrincipal
 * @see ProductServiceUtil
 * @generated
 */
@ProviderType
public class ProductServiceHttp {
	public static java.util.List<com.liferay.product.service.model.Product> getProductByPrice(
		HttpPrincipal httpPrincipal, long price) throws java.sql.SQLException {
		try {
			MethodKey methodKey = new MethodKey(ProductServiceUtil.class,
					"getProductByPrice", _getProductByPriceParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, price);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.sql.SQLException) {
					throw (java.sql.SQLException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.product.service.model.Product>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int addProduct(HttpPrincipal httpPrincipal,
		java.lang.String uuid, java.lang.String productId,
		java.lang.String companyId, java.lang.String productName,
		java.lang.String productPrice) throws java.sql.SQLException {
		try {
			MethodKey methodKey = new MethodKey(ProductServiceUtil.class,
					"addProduct", _addProductParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, uuid,
					productId, companyId, productName, productPrice);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.sql.SQLException) {
					throw (java.sql.SQLException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ProductServiceHttp.class);
	private static final Class<?>[] _getProductByPriceParameterTypes0 = new Class[] {
			long.class
		};
	private static final Class<?>[] _addProductParameterTypes1 = new Class[] {
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class
		};
}