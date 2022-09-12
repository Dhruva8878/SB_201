package ASS_1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Collage {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int collageId;
	private String collageName;
	private String collageAddress;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "Collage")
	private List<Student> list=new ArrayList<>();
	
	
	
	public int getCollageId() {
		return collageId;
	}

	public void setCollageId(int collageId) {
		this.collageId = collageId;
	}

	public String getCollageName() {
		return collageName;
	}

	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}

	public String getCollageAddress() {
		return collageAddress;
	}

	public void setCollageAddress(String collageAddress) {
		this.collageAddress = collageAddress;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Collage [collageId=" + collageId + ", collageName=" + collageName + ", collageAddress=" + collageAddress
				+ ", list=" + list + "]";
	}
	
	

}
