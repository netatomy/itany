package zqc.corejava.generics;

public class Box<T> {

	private T obj;

	public Box(T obj) {
		this.obj = obj;

	}

	public T getValue() {
		return obj;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("Box: ");
		sb.append("value - ");
		sb.append(getValue());
		return sb.toString();
	}
}
