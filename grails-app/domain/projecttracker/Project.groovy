package projecttracker

import static org.junit.Assert.*;

import org.junit.Test;

// http://localhost:8080/ProjectTracker/dbconsole/ -->config de la base
class Project {
	//columnas
	String name
	String description
	Date dueDate
	String billingType
	//dropdown list
	String toString(){
		"${name}"
	}
	
	//relacion, hijo de EndUser modelo
	static belongsTo = [owner:EndUser]
	//hijos
	static hasMany = [task:Task]

    static constraints = {
		//Orden para la lista de scaffold
		//blank false=requerido , unique = true->no sea repetido
		name(blank:false, unique:true)
		description()
		//min: no pueda entrar una fecha anterior a la de hoy
		dueDate(min: new Date())
		//Los valores que quiero que tenga
		billingType(blank:false,inList: ["Hourly","Milestone","Non-billable"])
    }
}
