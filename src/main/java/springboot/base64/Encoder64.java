 package springboot.base64;
 
 import java.io.BufferedWriter;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileOutputStream;
 import java.io.OutputStreamWriter;
 import java.io.PrintStream;
 import java.net.URL;
 import java.security.CodeSource;
 import java.security.ProtectionDomain;
 import java.text.DecimalFormat;
 import java.util.Base64;
 import java.util.Base64.Decoder;
 import java.util.Base64.Encoder;
 
 public class Encoder64
 {
   public static void main(String[] args)
     throws Exception
   {
     CheckFile.checkParameter(args);
 
     String path01 = new Encoder64().getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
     System.out.println("jar包所在路径：" + path01);
     if (CheckFile.checkOS() > 1) return;
     if (CheckFile.checkOS() == CheckFile.OS_WIN) path01 = path01.substring(1);
 
     File file = new File(path01.substring(0, path01.lastIndexOf("/") + 1) + args[0]);
     System.out.println("文件路径：" + file.getPath());
     if (!file.exists()) {
       System.out.println("对应文件不存在");
       return;
     }
 
     FileInputStream fis = new FileInputStream(file);
     FileOutputStream fos = new FileOutputStream(new File(file.getAbsolutePath() + "base64_" + args[0]));
     BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(fos));
 
     byte[] b = new byte[1024];
     int length = 0;
     StringBuffer sb = new StringBuffer();
     int i = 0;
     int size = 0;
     DecimalFormat df = new DecimalFormat("#0.00");
     while ((length = fis.read(b)) != -1) {
       if (length == b.length) {
         i++;
         fw.write(new String(encryptBASE64(b)));
         System.out.println("编码进度：" + df.format(i * length * 100 / file.length()) + "%");
       } else {
         byte[] bb = new byte[length];
         System.arraycopy(b, 0, bb, 0, length);
         fw.write(new String(encryptBASE64(b)));
       }
     }
 
     fis.close();
     fos.close();
     fw.close();
   }
 
   public static byte[] decryptBASE64(String key)
     throws Exception
   {
     return Base64.getDecoder().decode(key);
   }
 
   public static byte[] encryptBASE64(byte[] key)
     throws Exception
   {
     return Base64.getEncoder().encode(key);
   }
 }
