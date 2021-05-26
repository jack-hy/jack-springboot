package springboot.redis;

import java.util.List;
import java.io.Serializable;
import java.util.Map;

public class Students implements Serializable{
	public String name;
	private String alias;
	int id;
	Map map;
	List list;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "Students [name=" + name + ", alias=" + alias + ", id=" + id + ", map=" + map + ", list=" + list + "]";
	}
	
}
