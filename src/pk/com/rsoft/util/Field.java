package pk.com.rsoft.util;

public class Field {
	private String Name;
	private String Value;
	private COMPARISION_OPERATOR operator;
	private FIELD_TYPE fieldType;
	public Field() {
		// TODO Auto-generated constructor stub
		this("", COMPARISION_OPERATOR.EQUAL, "");
	}
	public Field(String name,String value)
	{
		this(name,COMPARISION_OPERATOR.EQUAL,value);
	}
	public Field(String name, COMPARISION_OPERATOR operator, String value)
	{
		this(name,operator,value,FIELD_TYPE.STRING);
	}
	public Field(String name, COMPARISION_OPERATOR operator, String value,FIELD_TYPE type) {
		this.setName(name);
		this.setValue(value);
		this.setOperator(operator);
		this.setFieldType(type);
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	public COMPARISION_OPERATOR getOperator() {
		return operator;
	}

	public void setOperator(COMPARISION_OPERATOR operator) {
		this.operator = operator;
	}

	public enum COMPARISION_OPERATOR {
		EQUAL, LIKE, LESS_THAN, GREATER_THAN, NOT_EQUAL;
		public static String toJPQL(COMPARISION_OPERATOR operator) {
			String retVal = "=";
			switch (operator) {
			case EQUAL:
				retVal = "=";
				break;
			case LIKE:
				retVal = "LIKE";
				break;
			case LESS_THAN:
				retVal = "<";
				break;
			case GREATER_THAN:
				retVal = ">";
				break;
			case NOT_EQUAL:
				retVal = "<>";
				break;
			default:
				break;
			}

			return retVal;
		}
	}
	
	
	public enum FIELD_TYPE {
		LONG,INTEGER,FLOAT,DOUBLE,STRING,OBJECT, BOOLEAN;
	}
	
	@Override
	public String toString()
	{
		return this.getName()+" " + COMPARISION_OPERATOR.toJPQL(this.operator)+" :"+getName();
	}
	public FIELD_TYPE getFieldType() {
		return fieldType;
	}
	public void setFieldType(FIELD_TYPE fieldType) {
		this.fieldType = fieldType;
	}
}
