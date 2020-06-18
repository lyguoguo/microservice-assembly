/**
 * 
 */
package com.gly.common.utils;

import java.util.UUID;

public class UUIDUtil {
	public static String createUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static void main(String[] args) {
		System.out.println(createUUID());
	}
}
