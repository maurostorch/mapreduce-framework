/**
 * 
 */
package com.storchti.mapreduceframework;

/**
 * @author Mauro_Storch
 *
 */
public interface MapReduce<T,M> {
	
	public boolean addMapper(Mapper<M> mapper);
	
	public T getResult();

}
