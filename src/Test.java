public class Test {
	public static void main(String[] args) {
		int i = 0;
		i |= 1;
		i |= 2;
		System.out.println(i);

		System.out.println(i & 1 << 1);
	}
}