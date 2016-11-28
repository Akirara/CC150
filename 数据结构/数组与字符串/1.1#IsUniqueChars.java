/**
 * 判断字符串的所有字符是否不同
 *
 * 1 确认是ASCII字符串还是Unicode字符串，ASCII占一个字节，共256个字符（前128个为标准ASCII）
 * 2 使用位向量可以将空间占用减少为1/8，boolean（1字节）-> 1 bit
 * 3 不使用额外数据结构，先对字符串原地排序，再遍历
 */

public class IsUniqueChars {
	public static boolean isUniqueChars1(String s) {
		if (s.length() > 128) {
			return false;
		}
		int checker = 0;
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= 1 << val;
		}
		return true;
	}

	public static boolean isUniqueChars2(String s) {
		if (s.length() > 128) {
			return false;
		}
		boolean[] charSet = new boolean[128];
		for (int i = 0; i < s.length; i++) {
			int val = s.charAt(i);
			if (charSet[val]) {
				return false;
			}
			charSet[val] = true;
		}
		return true;
	}
}