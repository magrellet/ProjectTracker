package projecttracker

class EndUser {
	String userName
	String password
	String fullName
	//dropdown list
	String toString(){
		"${fullName}"
	}
	
	//hijos
	static hasMany = [projects : Project, tasks : Task]
	
    static constraints = {
		fullName()
		userName()
		//
		password(password:true)
    }
}
