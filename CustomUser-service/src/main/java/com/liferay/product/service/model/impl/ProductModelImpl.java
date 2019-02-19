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

package com.liferay.product.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.product.service.model.Product;
import com.liferay.product.service.model.ProductModel;
import com.liferay.product.service.model.ProductSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Product service. Represents a row in the &quot;product_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ProductModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProductImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductImpl
 * @see Product
 * @see ProductModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class ProductModelImpl extends BaseModelImpl<Product>
	implements ProductModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a product model instance should use the {@link Product} interface instead.
	 */
	public static final String TABLE_NAME = "product_details";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "productId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "productName", Types.VARCHAR },
			{ "productPrice", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("productId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("productName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("productPrice", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table product_details (uuid_ VARCHAR(75) null,productId LONG not null primary key,companyId LONG,productName VARCHAR(75) null,productPrice LONG)";
	public static final String TABLE_SQL_DROP = "drop table product_details";
	public static final String ORDER_BY_JPQL = " ORDER BY product.productId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY product_details.productId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.consistent.queries.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.product.service.model.Product"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.consistent.queries.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.product.service.model.Product"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.consistent.queries.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.product.service.model.Product"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long UUID_COLUMN_BITMASK = 2L;
	public static final long PRODUCTID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Product toModel(ProductSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Product model = new ProductImpl();

		model.setUuid(soapModel.getUuid());
		model.setProductId(soapModel.getProductId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setProductName(soapModel.getProductName());
		model.setProductPrice(soapModel.getProductPrice());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Product> toModels(ProductSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Product> models = new ArrayList<Product>(soapModels.length);

		for (ProductSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.consistent.queries.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.product.service.model.Product"));

	public ProductModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _productId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProductId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _productId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Product.class;
	}

	@Override
	public String getModelClassName() {
		return Product.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("productId", getProductId());
		attributes.put("companyId", getCompanyId());
		attributes.put("productName", getProductName());
		attributes.put("productPrice", getProductPrice());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String productName = (String)attributes.get("productName");

		if (productName != null) {
			setProductName(productName);
		}

		Long productPrice = (Long)attributes.get("productPrice");

		if (productPrice != null) {
			setProductPrice(productPrice);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getProductId() {
		return _productId;
	}

	@Override
	public void setProductId(long productId) {
		_productId = productId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public String getProductName() {
		if (_productName == null) {
			return StringPool.BLANK;
		}
		else {
			return _productName;
		}
	}

	@Override
	public void setProductName(String productName) {
		_productName = productName;
	}

	@JSON
	@Override
	public long getProductPrice() {
		return _productPrice;
	}

	@Override
	public void setProductPrice(long productPrice) {
		_productPrice = productPrice;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Product.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Product toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Product)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProductImpl productImpl = new ProductImpl();

		productImpl.setUuid(getUuid());
		productImpl.setProductId(getProductId());
		productImpl.setCompanyId(getCompanyId());
		productImpl.setProductName(getProductName());
		productImpl.setProductPrice(getProductPrice());

		productImpl.resetOriginalValues();

		return productImpl;
	}

	@Override
	public int compareTo(Product product) {
		long primaryKey = product.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Product)) {
			return false;
		}

		Product product = (Product)obj;

		long primaryKey = product.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ProductModelImpl productModelImpl = this;

		productModelImpl._originalUuid = productModelImpl._uuid;

		productModelImpl._originalCompanyId = productModelImpl._companyId;

		productModelImpl._setOriginalCompanyId = false;

		productModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Product> toCacheModel() {
		ProductCacheModel productCacheModel = new ProductCacheModel();

		productCacheModel.uuid = getUuid();

		String uuid = productCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			productCacheModel.uuid = null;
		}

		productCacheModel.productId = getProductId();

		productCacheModel.companyId = getCompanyId();

		productCacheModel.productName = getProductName();

		String productName = productCacheModel.productName;

		if ((productName != null) && (productName.length() == 0)) {
			productCacheModel.productName = null;
		}

		productCacheModel.productPrice = getProductPrice();

		return productCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", productId=");
		sb.append(getProductId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", productName=");
		sb.append(getProductName());
		sb.append(", productPrice=");
		sb.append(getProductPrice());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.product.service.model.Product");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productId</column-name><column-value><![CDATA[");
		sb.append(getProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productName</column-name><column-value><![CDATA[");
		sb.append(getProductName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productPrice</column-name><column-value><![CDATA[");
		sb.append(getProductPrice());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Product.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Product.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _productId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private String _productName;
	private long _productPrice;
	private long _columnBitmask;
	private Product _escapedModel;
}