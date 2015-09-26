package com.github.javafxd3.api.interpolators;

import com.github.javafxd3.api.D3;
import com.github.javafxd3.api.core.Value;
import com.github.javafxd3.api.wrapper.JavaScriptObject;

import javafx.scene.web.WebEngine;
import netscape.javascript.JSObject;

/**
 * An interpolator factory returned by JSNI.
 * <p>
 * This class is used by {@link D3} to allow java code to invoke built-in interpolator factories. You should not instanciate this object
 * unless you know what you are doing.
 * <p>
 * 
 * 
 * @param <O> 
 * 
 */
public class JSNIInterpolatorFactory<O> extends JavaScriptObject implements InterpolatorFactory<O> {

	//#region CONSTRUCTORS
	/**
	 * Constructor
	 * @param webEngine
	 */
	public JSNIInterpolatorFactory(WebEngine webEngine) {
		super(webEngine);
	}
	
	//#end region

	//#region METHODS
	@Override
	public final JSObject asJSOFunction() {
		JSObject result = this.getJsObject();
		return result;
	}

	@Override
	public final <I> Interpolator<O> create(final I a, final I b) {
		return new JavascriptFunctionInterpolatorDecorator<O>(createInterpolator(a, b)) {
			@Override
			public O cast(final Value v) {
				return v.as();
			}
		};
	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	public  <I> JavascriptFunctionInterpolator createInterpolator(final I a, final I b){
		throw new IllegalStateException("not yet implemented");
		//JSObject result = eval(command);
		//return this(a, b);
	}
	
	//#end region

}
