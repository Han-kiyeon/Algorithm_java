package SWEA.d2;

import java.io.*;
import java.util.*;

public class D2_1928_Base64Decoder {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/D2_1928_Base64Decoder.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			String tmpString = "";
			for (int i = 0; i < input.length(); i++) {

				char charin = input.charAt(i);

				if ('A' <= charin && charin <= 'Z')
					charin -= 65;
				else if ('a' <= charin && charin <= 'z')
					charin -= 71;
				else if (charin == '+')
					charin = 62;
				else if (charin == '/')
					charin = 63;
				else if ('0' <= charin && charin <= '9')
					charin += 4;
				String c = Integer.toBinaryString(charin);
				String tmp = "";
				for (int j = c.length(); j < 6; j++) {
					tmp += "0";
				}
				tmpString += tmp + c;
			}
			System.out.print("#" + tc + " ");
			int start = 0, end = 8;
			while (end <= tmpString.length()) {
				String outTmp = tmpString.substring(start, end);
				start = end;
				end += 8;
				char out = (char) Integer.parseInt(outTmp, 2);
				System.out.print(out);
			}
			System.out.println();

		}
		br.close();
	}
}
