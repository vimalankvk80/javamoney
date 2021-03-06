/*
 *  Copyright (c) 2012, 2013, Credit Suisse (Anatole Tresch), Werner Keil.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package javax.money.function;

import java.math.BigDecimal;
import java.math.MathContext;

import javax.money.MonetaryAmount;
import javax.money.MonetaryOperator;

/**
 * This class allows to extract the reciprocal value (multiplcative inversion)
 * of a {@link MonetaryAmount} instance.
 * 
 * @author Anatole Tresch
 */
public final class Reciprocal implements MonetaryOperator {

	/**
	 * The shared instance of this class.
	 */
	private Reciprocal INSTANCE = new Reciprocal();

	/**
	 * Access the shared instance of {@link Reciprocal} for use.
	 * 
	 * @return the shared instance, never {@code null}.
	 */
	private Reciprocal() {
	}

	public Reciprocal of() {
		return INSTANCE;
	}

	/**
	 * Gets the amount as reciprocal / multiplcative inversed value (1/n).
	 * <p>
	 * E.g. 'EUR 2.0' will be converted to 'EUR 0.5'.
	 * 
	 * @return the reciprocal / multiplcative inversed of the amount
	 * @throws ArithmeticException
	 *             if the arithmetic operation failed
	 */
	@Override
	public MonetaryAmount apply(MonetaryAmount amount) {
		return fromAmount(amount);
	}

	/**
	 * Gets the amount as reciprocal / multiplcative inversed value (1/n).
	 * <p>
	 * E.g. 'EUR 2.0' will be converted to 'EUR 0.5'.
	 * 
	 * @return the reciprocal / multiplcative inversed of the amount
	 * @throws ArithmeticException
	 *             if the arithmetic operation failed
	 */
	@SuppressWarnings("unchecked")
	public static <T extends MonetaryAmount> T fromAmount(T amount) {
		if (amount == null) {
			throw new IllegalArgumentException("Amount required.");
		}
		return (T) amount.from(BigDecimal.ONE.divide(
				amount.asType(BigDecimal.class), MathContext.DECIMAL128));
	}

}
