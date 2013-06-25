package com.storchti.mapreduceframework;


/**
 * Mapper Interface
 * @author Mauro Storch
 *
 */
public interface Mapper<T> {

	public void doMap();
	
	public T getResult();
	
}
