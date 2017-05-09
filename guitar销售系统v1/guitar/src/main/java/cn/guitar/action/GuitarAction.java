package cn.guitar.action;

import cn.guitar.entity.Guitar;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GuitarAction extends BaseAction<Guitar> {
	
	private static final long serialVersionUID = 1L;
	private String serialNumber;
	private double price;
	private String builder;
	private String guitarModel;
	private String type;
	private String backWood;
	private String topWood;
	private JSONObject jsonObject = new JSONObject();
	private JSONArray jsonArray = new JSONArray();
	
	
	public String searchGuitar(){
		if(guitarService.search(price, builder, guitarModel, type, backWood, topWood)==null){
			return ERROR;
		}else{
			jsonArray=guitarService.search(price, builder, guitarModel, type, backWood, topWood);
		}
		return "jsonArray";
	}
	
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public String getGuitarModel() {
		return guitarModel;
	}
	public void setGuitarModel(String guitarModel) {
		this.guitarModel = guitarModel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBackWood() {
		return backWood;
	}
	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}
	public String getTopWood() {
		return topWood;
	}
	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}
	public JSONObject getJsonObject() {
		return jsonObject;
	}
	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
	public JSONArray getJsonArray() {
		return jsonArray;
	}
	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}
	
	
	
	
	

}
