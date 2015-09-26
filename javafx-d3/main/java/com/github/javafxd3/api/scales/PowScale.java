package com.github.javafxd3.api.scales;


import com.github.javafxd3.api.core.Formatter;

import javafx.scene.web.WebEngine;
import netscape.javascript.JSObject;

/**
 * Power scales are similar to linear scales, except there's an exponential
 * transform that is applied to the input domain value before the output range
 * value is computed.
 * <p>
 * The mapping to the output range value y can be expressed as a function of the
 * input domain value x: y = mx^k + b, where k is the exponent value.
 * <p>
 * Power scales also support negative values, in which case the input value is
 * multiplied by -1, and the resulting output value is also multiplied by -1.
 * <p>
 * As with {@link LinearScale}s, power scales can also accept more than two
 * values for the domain and range, thus resulting in polypower scale.
 * <p>
 * 
 * 
 * 
 */
public class PowScale extends ContinuousQuantitativeScale<PowScale> {

	// #region CONSTRUCTORS

	/**
	 * Constructor
	 * 
	 * @param webEngine
	 * @param wrappedJsObject
	 */
	public PowScale(WebEngine webEngine, JSObject wrappedJsObject) {
		super(webEngine, wrappedJsObject);

	}

	// #end region

	// #region METHODS

	// =========== base ==========
	/**
	 * Returns the current exponent, which defaults to 1.
	 * 
	 * @return the current exponent
	 */
	public  double exponent(){
		return this.exponent();
	}

	/**
	 * Sets the current exponent to the given numeric value.
	 * 
	 * @return the current scale
	 */
	public  PowScale exponent(double e){
		return this.exponent(e);
	}

	// =========== nice ==========

	/**
	 * Extends the domain so that it starts and ends on nice round values.
	 * <p>
	 * This method typically modifies the scale's domain, and may only extend
	 * the bounds to the nearest round value.
	 * <p>
	 * The precision of the round value is dependent on the extent of the domain
	 * dx according to the following formula: exp(round(log(*dx*)) - 1).
	 * <p>
	 * Nicing is useful if the domain is computed from data and may be
	 * irregular.
	 * <p>
	 * For example, for a domain of [0.20147987687960267, 0.996679553296417],
	 * the nice domain is [0.2, 1]. If the domain has more than two values,
	 * nicing the domain only affects the first and last value.
	 * <p>
	 * 
	 * @return the current scale
	 */
	public  PowScale nice(){
		return this.nice();
	}

	/**
	 * Same as {@link #nice()} but with more control.
	 * <p>
	 * The tick count argument allows greater control over the step size used to
	 * extend the bounds, guaranteeing that the ticks returned by
	 * {@link #ticks(int)} will exactly cover the domain.
	 * <p>
	 * 
	 * @return the current scale
	 */
	public  PowScale nice(int count){
		return this.nice(count);
	}

	// =========== ticks ==========

	/**
	 * Returns approximately count representative values from the scale's input
	 * domain.
	 * <p>
	 * The returned tick values are uniformly spaced, have human-readable values
	 * (such as multiples of powers of 10), and are guaranteed to be within the
	 * extent of the input domain.
	 * <p>
	 * Ticks are often used to display reference lines, or tick marks, in
	 * conjunction with the visualized data. The specified count is only a hint;
	 * the scale may return more or fewer values depending on the input domain.
	 * <p>
	 * @param count 
	 * 
	 * @return
	 */
	public  <T> T[] ticks(int count){
		throw new IllegalStateException("not yet implemented");
		//return this.ticks(count);
	}

	/**
	 * Alias for {@link #ticks(int) ticks(10)}.
	 * 
	 * @return the array of reference ticks
	 */
	public  <T> T[] ticks(){
		throw new IllegalStateException("not yet implemented");
		//return this.ticks(count);
	}

	// =========== tickFormat ==========

	/**
	 * Returns a number format function suitable for displaying a tick value.
	 * <p>
	 * The returned tick format is implemented as d.toPrecision(1).
	 * <p>
	 * 
	 * @return the number format
	 */
	public  Formatter tickFormat(){
		return this.tickFormat();
	}

	/**
	 * Returns a number format function suitable for displaying a tick value.
	 * <p>
	 * The specified count should have the same value as the count that is used
	 * to generate the tick values you want to display.
	 * <p>
	 * You don't have to use the scale's built-in tick format, but it
	 * automatically computes the appropriate precision based on the fixed
	 * interval between tick values.
	 * <p>
	 * 
	 * @param the
	 *            number of ticks to take into account to create the
	 *            {@link Formatter}.
	 * @return a number format
	 */
	public  Formatter tickFormat(int count){
		return this.tickFormat(count);
	}

	/**
	 * Returns a number format function suitable for displaying a tick value.
	 * <p>
	 * This is the same as {@link #tickFormat(int)}, except that the format
	 * argument allows a format specifier to be specified.
	 * <p>
	 * If the format specifier doesn’t have a defined precision, the precision
	 * will be set automatically by the scale, returning the appropriate format.
	 * <p>
	 * This provides a convenient, declarative way of specifying a format whose
	 * precision will be automatically set by the scale.
	 * <p>
	 * 
	 * @param the
	 *            number of ticks to take into account to create the
	 *            {@link Formatter}.
	 * @param the
	 *            format specified, as documented in {@link Formatter}, to be
	 *            used as a basis of the Formatter.
	 * @return a number format
	 */
	public  Formatter tickFormat(int count, String formatSpecifier){
		return this.tickFormat(count, formatSpecifier);
	}

	@Override
	protected PowScale createScale(WebEngine webEngine, JSObject result) {
		return new PowScale(webEngine, result);	
	}

}
