package action;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.GuitarDao;
import dao.dataAccess;
import model.Builder;
import model.Guitar;
import model.GuitarSpec;
import model.Inventory;
import model.Type;
import model.Wood;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.GuitarService;

public class GuitarAction extends ActionSupport {
	private String serialNumber;
	private String builder; 
	private String model;
	private String type;
	private String backWood;
	private String topWood;
	private double price;
	private int numStrings;
	private JSONObject jsonObject =new JSONObject();
	private JSONArray jsonArray=new JSONArray();

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBuilder() {
		return builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumStrings() {
		return numStrings;
	}

	public void setNumStrings(int numStrings) {
		this.numStrings = numStrings;
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



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String search() throws SQLException {
		Builder	builders=Builder.fromString(builder);
		Type types=Type.fromString(type);
		Wood backwood=Wood.fromString(backWood);
		Wood topwood=Wood.fromString(topWood);
		GuitarSpec searchSpec = new GuitarSpec(builders, model, types, numStrings, backwood, topwood);
		GuitarService guitarService = new GuitarService();
		Inventory inventory = guitarService.getInventory();
		List<Guitar> matchingGuitars = inventory.search(searchSpec);
		if (!matchingGuitars.isEmpty()) {
		      System.out.println("Erin, you might like these guitars:");
		      for (Guitar g:matchingGuitars) {
		    	  JSONObject jo = new JSONObject();
				  jo.put("serialNumber", g.getSerialNumber());
				  jo.put("price", g.getPrice());
				  jo.put("builder", g.getSpec().getBuilder());
				  jo.put("model", g.getSpec().getModel());
				  jo.put("type", g.getSpec().getType());
				  jo.put("backWood", g.getSpec().getBackWood());
				  jo.put("topWood", g.getSpec().getTopWood());
				  jo.put("numStrings", g.getSpec().getNumStrings());
				  jsonArray.add(jo);
		      }
		     return "jsonArray";
	    } else {
	      System.out.println("Sorry, Erin, we have nothing for you.");
	      return ERROR;
	    }
	}
	
	public String add() throws SQLException{
		jsonObject.put("status", "ok");
		Builder	builders=Builder.fromString(builder);
		Type types=Type.fromString(type);
		Wood backwood=Wood.fromString(backWood);
		Wood topwood=Wood.fromString(topWood);
		GuitarSpec spec = new GuitarSpec(builders, model, types, numStrings, backwood, topwood);
		GuitarService guitarService = new GuitarService();
		Guitar guitar = new Guitar(serialNumber,price,spec);
		guitarService.addGuitar(guitar);
		return "jsonObject";
	}
	
	public String delect() throws SQLException{
		GuitarService guitarService = new GuitarService();
		Guitar guitar = new Guitar(serialNumber, 0, null);
		guitarService.deleteGuitar(guitar);
		return SUCCESS;
	}

}
