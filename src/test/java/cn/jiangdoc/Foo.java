package cn.jiangdoc;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Foo {
	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Students s = new Students();
		s.setAlias("学生");
		s.setName("Jack");
		s.setId(123);
		HashMap h = new HashMap();
		h.put("key", "这是个Map的value");
		s.setMap(h);
		ArrayList a = new ArrayList();
		a.add("这是一个list");
		s.setList(a);
		
		FileOutputStream fos = new FileOutputStream("out.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		oos.close();
		
		FileInputStream fis = new FileInputStream("out.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Students ss = (Students)ois.readObject();
		System.out.println(ss);
		
		
	}
	
	public static Students getStudents() {
		Students s = new Students();
		s.setAlias("学生");
		s.setName("Jack");
		s.setId(123);
		HashMap<String, String> h = new HashMap<String, String>();
		h.put("key", "这是个Map的value");
		s.setMap(h);
		ArrayList<String> a = new ArrayList<String>();
		a.add("这是一个list");
		s.setList(a);
		return s;
	}
}
