package projecttracker

import java.util.Date;

class Task {
	String name
	String description
	Date dueDate
	//dropdown list
	String toString(){
		"${name}"
	}
	
	//Apuntando a 2 diferentes padres. Ponemos la relacion
	static belongsTo = [assignee:EndUser , project:Project]
	
    static constraints = {
		name()
		description()
		dueDate()
    }
}
