package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;


public class UniversityDatabase {
	
	//TODO: Complete this class according to the studio instructions
	
	Map <String, Student> map;
//	private int StudentCounter = 0;
	
	public UniversityDatabase() {
		this.map = new HashMap<String, Student>();
	}
	public void addStudent(String accountName, Student student) {
		map.put(accountName, student);
	}

	public int getStudentCount() {
		return map.size();
	}

	public String lookupFullName(String accountName) {
		// TODO: Complete according to studio instructions
		if (map.get(accountName) == null) {
			return null;
		} else {
			return map.get(accountName).getFullName();
		}
	}

	//gets All the bearbucks in the map
	public double getTotalBearBucks() {
		double numBucks = 0;
		for (String s: map.keySet()) {
			numBucks += map.get(s).getBearBucksBalance();
		}
		
		return numBucks;
	}
}
