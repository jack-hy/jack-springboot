package springboot.util;

import java.util.List;
import java.util.Map;

public class ResponseResult {
	String message = "";
	List list;
	List<Map> listmap;
	Map map;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public List<Map> getListmap() {
		return listmap;
	}

	public void setListmap(List<Map> listmap) {
		this.listmap = listmap;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "toStrong: ResponseResult [message=" + message + ", list=" + list + ", listmap=" + listmap + ", map=" + map + "]";
	}
	

}
