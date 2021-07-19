package pk.com.rsoft.util;

public class Operator {
	private OPERATOR_TYPE opType;
	public Operator(OPERATOR_TYPE op) {
		// TODO Auto-generated constructor stub
		this.opType = op;
	}

	enum OPERATOR_TYPE {
		AND, OR, NOT;
	};
	
	public String toString()
	{
		return opType.toString();
	}
}
