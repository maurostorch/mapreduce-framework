/**
 * 
 */
package com.storchti.mapreduceframework.example;

import java.util.List;
import java.util.Random;

import com.storchti.mapreduceframework.MapReduce;
import com.storchti.mapreduceframework.Mapper;
import com.storchti.mapreduceframework.Reducer;
import com.storchti.mapreduceframework.SimpleMapReduce;

/**
 * @author Mauro_Storch
 *
 */
public class RandomCounter {
	
	MapReduce<Integer, Integer> mr;
		
	public Integer getResult(){
		return (Integer)mr.getResult();
	}
	
	public void init(){
		Reducer<Integer, Mapper<Integer>,Integer> r = new Reducer<Integer, Mapper<Integer>,Integer>() {
			public Integer doReducer(List<Mapper<Integer>> mappers){
				int s=0;
				for(int i=0;i<mappers.size();i++)
					s+=mappers.get(i).getResult();
				return s;
			}
		};
		mr = new SimpleMapReduce<Integer,Integer>(2, r);
		Mapper<Integer> m;
		for(int i=0;i<1000;i++){
			m = new Mapper<Integer>() {
				Random r = new Random();
				int s=0;
				public void doMap(){
					for(int i=0;i<1000;i++){
						r.setSeed(System.currentTimeMillis());
						s +=r.nextInt(1000);
					}
				}
				public Integer getResult(){
					return s;
				}
			};
			mr.addMapper(m);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RandomCounter rc = new RandomCounter();
		System.out.println("---- Stating...");
		long t1 = System.currentTimeMillis();
		rc.init();
		int r = rc.getResult();
		long t2 = System.currentTimeMillis();
		System.out.println("---- Result: "+r);
		System.out.println("Time:"+(t2-t1));

	}

}
