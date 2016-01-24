package projecttracker

import java.util.Date;

class Task {
	String name
	String description
	Date dueDate
	
	//Apuntando a 2 diferentes padres. Ponemos la relacion
	static belongsTo = [assignee:EndUser , project:Project]
	
    static constraints = {
    }
}
