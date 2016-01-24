package projecttracker

class EndUser {
	String userName
	String password
	String fullName
	
	//hijos
	static hasMany = [projects : Project, tasks : Task]
	
    static constraints = {
    }
}
