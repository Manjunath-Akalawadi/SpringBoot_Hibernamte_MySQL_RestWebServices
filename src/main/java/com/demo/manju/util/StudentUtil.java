package com.demo.manju.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class StudentUtil {
	
	public List<Map<String,Object>> generateKeyValueObjects(List<Object[]> objectList, String[] keys){

		Map<String, Object> data ;
		List<Map<String,Object>> returnData=new ArrayList<Map<String,Object>>();
		//TODO need to check constraint
		for(Object[] objectData : objectList) {
			data = new HashMap<String,Object>();
			for(int i=0;i<keys.length;i++) {
				data.put(keys[i], objectData[i]);
			}

			returnData.add(data);
		}
		return returnData;
	}

}
