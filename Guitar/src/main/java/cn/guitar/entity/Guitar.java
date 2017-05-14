package cn.guitar.entity;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="guitar",uniqueConstraints = { @UniqueConstraint(columnNames = "serialNumber")})
public class Guitar implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String serialNumber;
	private double price;
	private GuitarSpec spec;
 
	
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="serialNumber",unique=true,nullable=false,length=30)
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	@Column(name="price")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="guitarSpec",referencedColumnName="guitarSpecSn")
	public GuitarSpec getSpec() {
		return spec;
	}
	public void setSpec(GuitarSpec spec) {
		this.spec = spec;
	}
	
	

	
	
	
	
	
}
