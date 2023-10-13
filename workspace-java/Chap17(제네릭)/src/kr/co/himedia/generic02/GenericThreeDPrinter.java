package kr.co.himedia.generic02;

public class GenericThreeDPrinter<T extends Material> {

	private T material;

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return material.toString();
	}
	
	public void print() {
		material.doPrint();
	}
}
