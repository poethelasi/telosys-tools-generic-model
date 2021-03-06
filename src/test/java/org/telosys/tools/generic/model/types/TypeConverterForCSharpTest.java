package org.telosys.tools.generic.model.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.telosys.tools.generic.model.types.AttributeTypeInfo.NONE;
import static org.telosys.tools.generic.model.types.AttributeTypeInfo.NOT_NULL;
import static org.telosys.tools.generic.model.types.AttributeTypeInfo.OBJECT_TYPE;
import static org.telosys.tools.generic.model.types.AttributeTypeInfo.PRIMITIVE_TYPE;
import static org.telosys.tools.generic.model.types.AttributeTypeInfo.SQL_TYPE;
import static org.telosys.tools.generic.model.types.AttributeTypeInfo.UNSIGNED_TYPE;

import org.junit.Test;

public class TypeConverterForCSharpTest  {

	private TypeConverter getTypeConverter() {
		return new TypeConverterForCSharp() ;
	}
	
	private LanguageType getType(AttributeTypeInfo typeInfo ) {
		LanguageType lt = getTypeConverter().getType(typeInfo);
		System.out.println( typeInfo + " --> " + lt );
		return lt ;
	}
	
	private LanguageType getType(String neutralType, int typeInfo ) {
		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(neutralType, typeInfo);
		return getType(attributeTypeInfo);
	}
	
	private void checkPrimitiveType( LanguageType lt, String primitiveType, String wrapperType) {
		assertNotNull(lt);
		assertTrue ( lt.isPrimitiveType() ) ;
		assertEquals(primitiveType, lt.getSimpleType() );
		assertEquals(primitiveType, lt.getFullType() );
		assertEquals(wrapperType, lt.getWrapperType() );
	}

	private void checkObjectType( LanguageType lt, String simpleType, String fullType) {
		assertNotNull(lt);
		assertFalse ( lt.isPrimitiveType() ) ;
		assertEquals(simpleType, lt.getSimpleType() );
		assertEquals(fullType,   lt.getFullType() );
		assertEquals(simpleType, lt.getWrapperType() );
	}
	
	@Test
	public void testString() {
		System.out.println("--- ");
		
		checkObjectType( getType(NeutralType.STRING, NONE ),            "String", "System.String");
		
		checkPrimitiveType( getType(NeutralType.STRING, NOT_NULL ),        "string", "String");
		checkPrimitiveType( getType(NeutralType.STRING, PRIMITIVE_TYPE ),  "string", "String");
		checkPrimitiveType( getType(NeutralType.STRING, UNSIGNED_TYPE ),   "string", "String");
		checkPrimitiveType( getType(NeutralType.STRING, PRIMITIVE_TYPE + UNSIGNED_TYPE ), "string", "String");
		
		checkObjectType( getType(NeutralType.STRING, OBJECT_TYPE),            "String", "System.String" );
		checkObjectType( getType(NeutralType.STRING, SQL_TYPE),               "String", "System.String" );
		checkObjectType( getType(NeutralType.STRING, OBJECT_TYPE + SQL_TYPE), "String", "System.String" );
	}

	@Test
	public void testBoolean() {
		System.out.println("--- ");
				
		checkObjectType( getType( NeutralType.BOOLEAN, NONE ),                  "Boolean", "System.Boolean" );

		checkPrimitiveType( getType( NeutralType.BOOLEAN, NOT_NULL ),        "boolean", "Boolean");
		checkPrimitiveType( getType( NeutralType.BOOLEAN, PRIMITIVE_TYPE ),  "boolean", "Boolean");
		checkPrimitiveType( getType( NeutralType.BOOLEAN, UNSIGNED_TYPE ),   "boolean", "Boolean");
		checkPrimitiveType( getType( NeutralType.BOOLEAN, PRIMITIVE_TYPE + UNSIGNED_TYPE ), "boolean", "Boolean");
		
		checkObjectType( getType( NeutralType.BOOLEAN, OBJECT_TYPE),            "Boolean", "System.Boolean" );
		checkObjectType( getType( NeutralType.BOOLEAN, SQL_TYPE),               "Boolean", "System.Boolean" );
		checkObjectType( getType( NeutralType.BOOLEAN, OBJECT_TYPE + SQL_TYPE), "Boolean", "System.Boolean" );
		checkObjectType( getType( NeutralType.BOOLEAN, NOT_NULL + OBJECT_TYPE), "Boolean", "System.Boolean" );
		checkObjectType( getType( NeutralType.BOOLEAN, NOT_NULL + SQL_TYPE),    "Boolean", "System.Boolean" );

	}

	@Test
	public void testShort() {
		System.out.println("--- ");
		TypeConverter tc = getTypeConverter() ;
		
		LanguageType lt ; 
		
		//-----------------------------------
//		
//		lt = getType(tc, NeutralType.SHORT, PRIMITIVE_TYPE + OBJECT_TYPE); // not compatible (primitive type has priority)
//		check(lt, short.class);		
//		lt = getType(tc, NeutralType.SHORT, PRIMITIVE_TYPE + SQL_TYPE); // not compatible (primitive type has priority)
//		check(lt, short.class);		
//		lt = getType(tc, NeutralType.SHORT, UNSIGNED_TYPE + OBJECT_TYPE ); // not compatible (primitive type has priority)
//		check(lt, short.class);		
//		lt = getType(tc, NeutralType.SHORT, UNSIGNED_TYPE + SQL_TYPE ); // not compatible (primitive type has priority)
//		check(lt, short.class);		
//
//		
//		check( getType(tc, NeutralType.SHORT, OBJECT_TYPE ), Short.class);
//		check( getType(tc, NeutralType.SHORT, OBJECT_TYPE + NOT_NULL), Short.class);
//		check( getType(tc, NeutralType.SHORT, SQL_TYPE), Short.class);
//		check( getType(tc, NeutralType.SHORT, SQL_TYPE + NOT_NULL), Short.class);
//		check( getType(tc, NeutralType.SHORT, SQL_TYPE + OBJECT_TYPE), Short.class);
	}

	@Test
	public void testDecimal() {
		System.out.println("--- ");
		TypeConverter tc = getTypeConverter() ;
		
//		// Supposed to always return BigDecimal (in any cases) 
//		check( getType(tc, NeutralType.DECIMAL, NONE ), BigDecimal.class);
//		check( getType(tc, NeutralType.DECIMAL, NOT_NULL ), BigDecimal.class);
//		
//		check( getType(tc, NeutralType.DECIMAL, PRIMITIVE_TYPE ), BigDecimal.class);
//		check( getType(tc, NeutralType.DECIMAL, UNSIGNED_TYPE ), BigDecimal.class);
//		check( getType(tc, NeutralType.DECIMAL, PRIMITIVE_TYPE + UNSIGNED_TYPE ), BigDecimal.class);
//		
//		check( getType(tc, NeutralType.DECIMAL, OBJECT_TYPE ), BigDecimal.class);
//		check( getType(tc, NeutralType.DECIMAL, SQL_TYPE ), BigDecimal.class);		
//		check( getType(tc, NeutralType.DECIMAL, NOT_NULL + OBJECT_TYPE ), BigDecimal.class);
//		check( getType(tc, NeutralType.DECIMAL, NOT_NULL + SQL_TYPE ), BigDecimal.class);
	}

	@Test
	public void testDate() {
		System.out.println("--- ");
//		TypeConverter tc = new TypeConverterForTypeScript() ;
//		
//		// Supposed to always return BigDecimal (in any cases) 
//		check( getType(tc, NeutralType.DATE, NONE ), java.util.Date.class);
//		check( getType(tc, NeutralType.DATE, NOT_NULL ), java.util.Date.class);
//		
//		check( getType(tc, NeutralType.DATE, PRIMITIVE_TYPE ), java.util.Date.class);
//		check( getType(tc, NeutralType.DATE, UNSIGNED_TYPE ), java.util.Date.class);
//		check( getType(tc, NeutralType.DATE, PRIMITIVE_TYPE + UNSIGNED_TYPE ), java.util.Date.class);
//		
//		check( getType(tc, NeutralType.DATE, OBJECT_TYPE ), java.util.Date.class);
//		check( getType(tc, NeutralType.DATE, NOT_NULL + OBJECT_TYPE ), java.util.Date.class);
//
//		check( getType(tc, NeutralType.DATE, SQL_TYPE ), java.sql.Date.class);	 // SQL Date	
//		check( getType(tc, NeutralType.DATE, NOT_NULL + SQL_TYPE ), java.sql.Date.class); // SQL Date	
//		check( getType(tc, NeutralType.DATE, OBJECT_TYPE + SQL_TYPE ), java.sql.Date.class); // SQL Date	
//		check( getType(tc, NeutralType.DATE, PRIMITIVE_TYPE + SQL_TYPE ), java.sql.Date.class); // not compatible (no Prim type => SQL Date)	
	}

	@Test
	public void testTime() {
		System.out.println("--- ");
//		TypeConverter tc = new TypeConverterForTypeScript() ;
//		
//		// Supposed to always return BigDecimal (in any cases) 
//		check( getType(tc, NeutralType.TIME, NONE ), java.util.Date.class);
//		check( getType(tc, NeutralType.TIME, NOT_NULL ), java.util.Date.class);
//		
//		check( getType(tc, NeutralType.TIME, PRIMITIVE_TYPE ), java.util.Date.class);
//		check( getType(tc, NeutralType.TIME, UNSIGNED_TYPE ), java.util.Date.class);
//		check( getType(tc, NeutralType.TIME, PRIMITIVE_TYPE + UNSIGNED_TYPE ), java.util.Date.class);
//		
//		check( getType(tc, NeutralType.TIME, OBJECT_TYPE ), java.util.Date.class);
//		check( getType(tc, NeutralType.TIME, NOT_NULL + OBJECT_TYPE ), java.util.Date.class);
//
//		check( getType(tc, NeutralType.TIME, SQL_TYPE ), java.sql.Time.class);	 // SQL Time	
//		check( getType(tc, NeutralType.TIME, NOT_NULL + SQL_TYPE ), java.sql.Time.class); // SQL Time	
//		check( getType(tc, NeutralType.TIME, OBJECT_TYPE + SQL_TYPE ), java.sql.Time.class); // SQL Time	
//		check( getType(tc, NeutralType.TIME, PRIMITIVE_TYPE + SQL_TYPE ), java.sql.Time.class); // not compatible (no Prim type => SQL Time)	
	}

	@Test
	public void testTimestamp() {
		System.out.println("--- ");
//		TypeConverter tc = new TypeConverterForTypeScript() ;
//		
//		// Supposed to always return BigDecimal (in any cases) 
//		check( getType(tc, NeutralType.TIMESTAMP, NONE ), java.util.Date.class);
//		check( getType(tc, NeutralType.TIMESTAMP, NOT_NULL ), java.util.Date.class);
//		
//		check( getType(tc, NeutralType.TIMESTAMP, PRIMITIVE_TYPE ), java.util.Date.class);
//		check( getType(tc, NeutralType.TIMESTAMP, UNSIGNED_TYPE ), java.util.Date.class);
//		check( getType(tc, NeutralType.TIMESTAMP, PRIMITIVE_TYPE + UNSIGNED_TYPE ), java.util.Date.class);
//		
//		check( getType(tc, NeutralType.TIMESTAMP, OBJECT_TYPE ), java.util.Date.class);
//		check( getType(tc, NeutralType.TIMESTAMP, NOT_NULL + OBJECT_TYPE ), java.util.Date.class);
//
//		check( getType(tc, NeutralType.TIMESTAMP, SQL_TYPE ), java.sql.Timestamp.class);	 // SQL Time	
//		check( getType(tc, NeutralType.TIMESTAMP, NOT_NULL + SQL_TYPE ), java.sql.Timestamp.class); // SQL Time	
//		check( getType(tc, NeutralType.TIMESTAMP, OBJECT_TYPE + SQL_TYPE ), java.sql.Timestamp.class); // SQL Time	
//		check( getType(tc, NeutralType.TIMESTAMP, PRIMITIVE_TYPE + SQL_TYPE ), java.sql.Timestamp.class); // not compatible (no Prim type => SQL Time)	
	}

	@Test
	public void testPrimitiveTypes() {
		System.out.println("--- ");
//		TypeConverter tc = new TypeConverterForTypeScript() ;
//		LanguageType lt ;
//		
//		lt = getType(tc, NeutralType.BOOLEAN, PRIMITIVE_TYPE ) ;
//		assertEquals("boolean", lt.getSimpleType());
//		assertEquals("boolean", lt.getFullType());
//		assertEquals("Boolean", lt.getWrapperType());
//		assertTrue(lt.isPrimitiveType());
//		
//		lt = getType(tc, NeutralType.SHORT, PRIMITIVE_TYPE ) ;
//		assertEquals("short", lt.getSimpleType());
//		assertEquals("short", lt.getFullType());
//		assertEquals("Short", lt.getWrapperType());
//		assertTrue(lt.isPrimitiveType());
//
//		lt = getType(tc, NeutralType.INTEGER, PRIMITIVE_TYPE ) ;
//		assertEquals("int", lt.getSimpleType());
//		assertEquals("int", lt.getFullType());
//		assertEquals("Integer", lt.getWrapperType());
//		assertTrue(lt.isPrimitiveType());
//
//		lt = getType(tc, NeutralType.LONG, PRIMITIVE_TYPE ) ;
//		assertEquals("long", lt.getSimpleType());
//		assertEquals("long", lt.getFullType());
//		assertEquals("Long", lt.getWrapperType());
//		assertTrue(lt.isPrimitiveType());
	}
	
	@Test
	public void testObjectTypes() {
		System.out.println("--- ");
//		TypeConverter tc = new TypeConverterForTypeScript() ;
//		LanguageType lt ;
//		
//		lt = getType(tc, NeutralType.BOOLEAN, OBJECT_TYPE ) ;
//		assertEquals("Boolean", lt.getSimpleType());
//		assertEquals("java.lang.Boolean", lt.getFullType());
//		assertEquals("Boolean", lt.getWrapperType());
//		assertFalse(lt.isPrimitiveType());
//
//		lt = getType(tc, NeutralType.SHORT, OBJECT_TYPE ) ;
//		assertEquals("Short", lt.getSimpleType());
//		assertEquals("java.lang.Short", lt.getFullType());
//		assertEquals("Short", lt.getWrapperType());
//		assertFalse(lt.isPrimitiveType());
//
//		lt = getType(tc, NeutralType.INTEGER, OBJECT_TYPE ) ;
//		assertEquals("Integer", lt.getSimpleType());
//		assertEquals("java.lang.Integer", lt.getFullType());
//		assertEquals("Integer", lt.getWrapperType());
//		assertFalse(lt.isPrimitiveType());
//
	}
}
