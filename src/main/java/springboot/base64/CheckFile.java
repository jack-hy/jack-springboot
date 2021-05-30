 package springboot.base64;

public class CheckFile
 {
   static int OS_WIN = 0;
   static int OS_LINUX = 1;
   static int OS_MAC = 2;
   static int OS_NUL = 3;
 
   public static boolean checkParameter(String[] args)
   {
     System.out.println("参数长度：" + args.length);
     return args.length != 0;
   }
 
   public static int checkOS()
   {
     String property = System.getProperty("os.name");
     System.out.println("操作系统：" + property);
     if (property.toLowerCase().contains("win"))
       return OS_WIN;
     if (property.toLowerCase().contains("linux"))
       return OS_LINUX;
     if (property.toLowerCase().contains("mac")) {
       System.out.println("mac 不支持");
       return OS_MAC;
     }
     System.out.println("未知系统");
     return OS_NUL;
   }
 }

