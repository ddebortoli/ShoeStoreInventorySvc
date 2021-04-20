package enums;

import enums.Sizes;

public enum Sizes {
    SIZE_31(31),
    SIZE_32(32),
    SIZE_33(33),
    SIZE_34(34);
	
	private int size;

	Sizes(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	public static Sizes fromSizeNumber(int sizeNumber) {
		for (Sizes size:Sizes.values()) {
			if(size.getSize() == sizeNumber) {
				return size;
			}
		}
		return null;
	}
	
	public String toString() {
		return String.valueOf(this.size);
	}
}