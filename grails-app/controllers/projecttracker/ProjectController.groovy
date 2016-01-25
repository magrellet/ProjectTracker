package projecttracker

class ProjectController {
	
	def scaffold = true
	
	//metodo default
	def index = {
		//redirecciono a otro controlador
		//redirect (action:current)
		redirect (action:list)
	}
    def current= {
		//mensaje al explorador
//		render "<h1>Project tracker example</h1>"
		//variables
//		def projectName = "Project tracker example"
//		def dueDate = "18/01/2015"
		
		def allProject = Project.list()
		[allProject:allProject]
		
		//groovy
		//key:value , key estara en la vista
		//[project:projectName, date:dueDate]
				
		
	}
	
	def overdue = {
		render "Order Packages"
	}
	
	
}
