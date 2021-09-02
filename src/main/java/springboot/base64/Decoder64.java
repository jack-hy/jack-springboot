package springboot.base64;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Base64;

public class Decoder64 {
	public static void main(String[] args) throws Exception {
		//测试
		//args = new String[] {"base64_wh.txt"};
		CheckFile.checkParameter(args);

		String path01 = new Encoder64().getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		System.out.println("jar包所在路径：" + path01);
		if (CheckFile.checkOS() > 1)
			return;
		if (CheckFile.checkOS() == CheckFile.OS_WIN)
			path01 = path01.substring(1);

		File file = new File(path01.substring(0, path01.lastIndexOf("/") + 1) + args[0]);
		System.out.println("文件路径：" + file.getPath());
		if (!file.exists()) {
			System.out.println("对应文件不存在");
			return;
		}

		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(
				new File(path01.substring(0, path01.lastIndexOf("/") + 1) + "解码_" + args[0]));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		byte[] b = new byte[1024];
		String str = new String();
		int length = 0;
		int i = 0;
		DecimalFormat df = new DecimalFormat();
		while ((str = br.readLine()) != null) {
			System.out.println("解码进度：" + df.format(i * length * 100 / file.length()) + "%");
			byte[] base64Decoder = decryptBASE64(str);
			fos.write(base64Decoder);
		}

		System.out.println("解码完成");

		fis.close();
		fos.flush();
		fos.close();
		br.close();
	}

	public static byte[] decryptBASE64(String key) throws Exception {
		return Base64.getDecoder().decode(key);
	}

	public static byte[] encryptBASE64(byte[] key) throws Exception {
		return Base64.getEncoder().encode(key);
	}
}
