package kr.co.himedia.field02;

import java.util.Arrays;

public class FieldInit {
	
	//기본형
	byte byteField;					// 1 byte
	short shortField;				// 2 byte
	int intField;					// 4 byte
	long longField;					// 8 byte
	
	boolean booleanField;			// 1 byte
	char charField;					// 2
	
	float floatField;				// 4
	double doubleField;				// 8
	
	//참조형
	String strField;				// 4
	int[] arrField;					// 4
	
	@Override
	public String toString() {
		return "FieldInitTest [byteField=" + byteField + ", shortField=" + shortField + ", intField=" + intField
				+ ", longField=" + longField + ", booleanField=" + booleanField + ", charField=" + charField
				+ ", floatField=" + floatField + ", doubleField=" + doubleField + ", strField=" + strField
				+ ", arrField=" + Arrays.toString(arrField) + "]";
	}
	
	
}
