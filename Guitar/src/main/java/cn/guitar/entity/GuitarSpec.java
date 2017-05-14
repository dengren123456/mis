package cn.guitar.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="guitarSpec",uniqueConstraints = { @UniqueConstraint(columnNames = "guitarSpecSn")})
public class GuitarSpec implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String guitarSpecSn;
	private Builder builder; 
	private String model;
	private Type type;
	private Wood backWood;
	private Wood topWood;
	private int numStrings;

	
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="guitarSpecSn",length=30)
	public String getGuitarSpecSn() {
		return guitarSpecSn;
	}

	public void setGuitarSpecSn(String guitarSpecSn) {
		this.guitarSpecSn = guitarSpecSn;
	}
	
	@Column(name="builder",length=30)
	public Builder getBuilder() {
		return builder;
	}

	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
	
	@Column(name="model",length=30)
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	@Column(name="type",length=30)
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	@Column(name="backWood",length=30)
	public Wood getBackWood() {
		return backWood;
	}
	public void setBackWood(Wood backWood) {
		this.backWood = backWood;
	}
	
	@Column(name="topWood",length=30)
	public Wood getTopWood() {
		return topWood;
	}

	public void setTopWood(Wood topWood) {
		this.topWood = topWood;
	}
	
	@Column(name="numStrings",length=30)
	public int getNumStrings() {
		return numStrings;
	}
	public void setNumStrings(int numStrings) {
		this.numStrings = numStrings;
	}
	
}
