package com.storchti.mapreduceframework;

import java.util.List;

/**
 * Reducer Interface
 * @author Mauro Storch
 * @param <M>
 *
 */
public interface Reducer<T,V extends Mapper<M>, M> {

	public T doReducer(List<V> mappers);
	
}
