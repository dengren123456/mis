package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionSupport;

import model.Course;
import model.Professor;
import model.Student;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.PersonService;
import service.PlanOfStudyService;

/**
* <p>Title: PlanOfStudyAction</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月29日
*/
public class PlanOfStudyAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String ssn;

	private JSONObject jsonObject = new JSONObject();
	private JSONArray jsonArray = new JSONArray();
	
	
	/**
	 * 
	* <p>Title: FindAllPlan</p>
	* <p>Description: 查询所有PlanOfStudy</p>
	* @return
	 */
	public String findAllPlan(){
		PlanOfStudyService planOfStudyService = new PlanOfStudyService();
		PersonService personService = new PersonService();
		HashMap<String, Student> students = personService.findAllStudents();
		List<Course> courses = planOfStudyService.findByStudent(students.get(ssn));
		for(Course c : courses){
			JSONObject jo = new JSONObject();
			jo.put("courseNo", c.getCourseNo());
			jo.put("courseName", c.getCourseName());
			jo.put("credits", c.getCredits());
			jsonArray.add(jo);
		}
		return "jsonArray";
	}
	

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
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
