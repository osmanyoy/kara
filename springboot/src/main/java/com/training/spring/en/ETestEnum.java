package com.training.spring.en;

public enum ETestEnum implements ITestEnumInt {
	STATE1(1,"osman1"){
		@Override
		public String getRealName() {
			return "test2";
		}

		@Override
		public int test() {
			return 101;
		}

	}
	
	,STATE2(2,"osman2");
	
	private int index;
	private String name;

	private ETestEnum(int index,String nameParam) {
		this.index = index;
		name = nameParam;
		
	}

	public int getIndex() {
		return index;
	}

	public String getName() {
		return name;
	}
	
	public int test() {
		return 100;
	}

	@Override
	public String getRealName() {
		return null;
	}
	
	
}
