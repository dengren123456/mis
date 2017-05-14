package cn.guitar.action;

import java.util.Iterator;
import java.util.List;

import cn.guitar.entity.Builder;
import cn.guitar.entity.Guitar;
import cn.guitar.entity.GuitarSpec;
import cn.guitar.entity.Type;
import cn.guitar.entity.Wood;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GuitarAction extends BaseAction<Guitar> {
	
	private static final long serialVersionUID = 1L;
	private String serialNumber;
	private double price;
	private Builder builder;
	private String guitarModel;
	private Type type;
	private Wood backWood;
	private Wood topWood;
	private int numStrings;
	private JSONObject jsonObject = new JSONObject();
	private JSONArray jsonArray = new JSONArray();
	
	
	public String searchGuitar(){
		GuitarSpec guitarSpec = new GuitarSpec();
		guitarSpec.setBuilder(builder);
		guitarSpec.setModel(guitarModel);
		guitarSpec.setType(type);
		guitarSpec.setBackWood(backWood);
		guitarSpec.setTopWood(topWood);
		guitarSpec.setNumStrings(numStrings);
		jsonArray = JSONArray.fromObject(guitarSpecService.searchGuitarSpec(guitarSpec));
		for(int i = 0; i < jsonArray.size(); i++){
			JSONObject getJsonObj = jsonArray.getJSONObject(i);
			jsonArray = guitarService.getByGuitarSpecSn(getJsonObj.getString("guitarSpecSn"));
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

	public String getGuitarModel() {
		return guitarModel;
	}
	public void setGuitarModel(String guitarModel) {
		this.guitarModel = guitarModel;
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


	public int getNumStrings() {
		return numStrings;
	}


	public void setNumStrings(int numStrings) {
		this.numStrings = numStrings;
	}


	public void setBuilder(Builder builder) {
		this.builder = builder;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public void setBackWood(Wood backWood) {
		this.backWood = backWood;
	}


	public void setTopWood(Wood topWood) {
		this.topWood = topWood;
	}
	
	
	
	
	

}
