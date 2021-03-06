/**
 *  Copyright (C) 2008-2015  Telosys project org. ( http://www.telosys.org/ )
 *
 *  Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.gnu.org/licenses/lgpl.html
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.telosys.tools.generic.model.types;

/**
 * Type converter for "C#" language
 * 
 * @author Laurent Guerin
 *
 */
public class TypeConverterForCSharp extends TypeConverter {

	public TypeConverterForCSharp() {
		super();
		
		//--- Object types 
		declareObjectType( buildObjectType(NeutralType.STRING,    "String",   "System.String"  ) );
		declareObjectType( buildObjectType(NeutralType.BOOLEAN,   "Boolean",  "System.Boolean" ) );
		declareObjectType( buildObjectType(NeutralType.BYTE,      "SByte",    "System.SByte"   ) );
		declareObjectType( buildObjectType(NeutralType.SHORT,     "Int16",    "System.Int16"   ) );
		declareObjectType( buildObjectType(NeutralType.INTEGER,   "Int32",    "System.Int32"   ) );
		declareObjectType( buildObjectType(NeutralType.LONG,      "Int64",    "System.Int64"   ) );
		declareObjectType( buildObjectType(NeutralType.FLOAT,     "Single",   "System.Single"  ) );
		declareObjectType( buildObjectType(NeutralType.DOUBLE,    "Double",   "System.Double"  ) );
		declareObjectType( buildObjectType(NeutralType.DECIMAL,   "Decimal",  "System.Decimal" ) );
		declareObjectType( buildObjectType(NeutralType.DATE,      "DateTime", "System.DateTime" ) );
		declareObjectType( buildObjectType(NeutralType.TIME,      "DateTime", "System.DateTime" ) );
		declareObjectType( buildObjectType(NeutralType.TIMESTAMP, "DateTime", "System.DateTime" ) );
//		declareObjectType( NeutralType.BINARY );

		//--- Object SQL types :
		// No specific SQL types for C#
//		declareObjectSqlType(NeutralType.DATE,  xxxx );
		
		//--- Primitive types :
		declarePrimitiveType( buildPrimitiveType(NeutralType.STRING,   "string",  "String"         ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.BOOLEAN,  "boolean", "Boolean"        ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.BYTE,     "sbyte",   "System.SByte"   ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.SHORT,    "short",   "System.Int16"   ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.INTEGER,  "int",     "System.Int32"   ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.LONG,     "long",    "System.Int64"   ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.FLOAT,    "float",   "System.Single"  ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.DOUBLE,   "double",  "System.Double"  ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.DECIMAL,  "decimal", "System.Decimal" ) );
		// DATE => No primitive type
		// TIME => No primitive type
		// TIMESTAMP => No primitive type
		declarePrimitiveType( buildPrimitiveType(NeutralType.BINARY, "byte[]", "byte[]" )  ); // No Wrapper type for binary / byte[] ?
		
		//--- Unsigned primitive types : 
		declarePrimitiveUnsignedType( buildPrimitiveType(NeutralType.BYTE,    "byte",   "System.Byte"   ) );
		declarePrimitiveUnsignedType( buildPrimitiveType(NeutralType.SHORT,   "ushort", "System.UInt16" ) );
		declarePrimitiveUnsignedType( buildPrimitiveType(NeutralType.INTEGER, "uint",   "System.UInt32" ) );
		declarePrimitiveUnsignedType( buildPrimitiveType(NeutralType.LONG,    "ulong",  "System.UInt64" ) );
	}

	private LanguageType buildPrimitiveType(String neutralType, String primitiveType, String wrapperType) {
		return new LanguageType(neutralType, primitiveType,  primitiveType, true, wrapperType );
	}

	private LanguageType buildObjectType(String neutralType, String simpleType, String fullType) {
		return new LanguageType(neutralType, simpleType,  fullType, false, simpleType );
	}

}
