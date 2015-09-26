package com.github.javafxd3.api.ease;

import com.github.javafxd3.api.wrapper.JavaScriptObject;

import javafx.scene.web.WebEngine;
import netscape.javascript.JSObject;

/**
 * JSNI easing functions.
 * <p>
 * 
 * 
 *
 */
public class JavascriptEasingFunction extends JavaScriptObject implements EasingFunction {

	// #region CONSTRUCTORS

	/**
	 * @param webEngine
	 * @param wrappedJsObject
	 */
	public JavascriptEasingFunction(WebEngine webEngine, JSObject wrappedJsObject) {
		super(webEngine);
		setJsObject(wrappedJsObject);

	}

	// #end region

	// #region METHODS

	
	@Override
	public  double ease(double t){
		String command = "this("+t+")";
		Double result = evalForDouble(command);
		return result;
	}
	
	//#end region
}
