/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wiser.flinkafka;

/**
 *
 * @author Brenno Mello <brennodemello.bm at gmail.com>
 */

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class Splitter implements FlatMapFunction<String, Tuple2<String, Double>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void flatMap(String value, Collector<Tuple2<String, Double>> out) throws Exception {

		if (null != value && value.contains(",")) {
			String parts[] = value.split(",");
			out.collect(new Tuple2<String, Double>(parts[2], Double.parseDouble(parts[1])));
		}
	}

}