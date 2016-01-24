package projecttracker

import static org.junit.Assert.*;

import org.junit.Test;

// http://localhost:8080/ProjectTracker/dbconsole/ -->config de la base
class Project {
	//columnas
	String name
	String description
	Date dueDate
	
	//relacion, hijo de EndUser modelo
	static belongsTo = [owner:EndUser]
	//hijos
	static hasMany = [task:Task]

    static constraints = {
    }
}
