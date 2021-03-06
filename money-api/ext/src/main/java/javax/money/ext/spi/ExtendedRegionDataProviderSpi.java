/*
 * CREDIT SUISSE IS WILLING TO LICENSE THIS SPECIFICATION TO YOU ONLY UPON THE
 * CONDITION THAT YOU ACCEPT ALL OF THE TERMS CONTAINED IN THIS AGREEMENT.
 * PLEASE READ THE TERMS AND CONDITIONS OF THIS AGREEMENT CAREFULLY. BY
 * DOWNLOADING THIS SPECIFICATION, YOU ACCEPT THE TERMS AND CONDITIONS OF THE
 * AGREEMENT. IF YOU ARE NOT WILLING TO BE BOUND BY IT, SELECT THE "DECLINE"
 * BUTTON AT THE BOTTOM OF THIS PAGE. Specification: JSR-354 Money and Currency
 * API ("Specification") Copyright (c) 2012-2013, Credit Suisse All rights
 * reserved.
 */
package javax.money.ext.spi;

import java.util.Collection;

import javax.money.ext.Region;

/**
 * Implementation of this interface provide arbitrary additional data for a
 * region.
 * 
 * @author Anatole Tresch
 */
public interface ExtendedRegionDataProviderSpi {

	/**
	 * Get the extended data types, that can be accessed from this
	 * {@link Region} by calling {@link #getRegionData(Class)}.
	 * 
	 * @param region
	 *            the region for which addition data is requested.
	 * @return the collection of supported region data, may be {@code empty} but
	 *         never {@code null}.
	 */
	public Collection<Class> getExtendedRegionDataTypes(Region region);

	/**
	 * Access the additional region data, using its type.
	 * 
	 * @param region
	 *            the region for which addition data is requested.
	 * @param type
	 *            The region data type, not {@code null}.
	 * @return the corresponding data item.
	 * @throws IllegalArgumentException
	 *             if the type passed is not supported. See
	 *             {@link #getRegionDataTypes()}.
	 */
	public <T> T getExtendedRegionData(Region region, Class<T> type);

}
