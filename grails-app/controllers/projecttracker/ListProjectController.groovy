package projecttracker

class ListProjectController {
	
	//metodo default
	def index = {
		//redirecciono a otro controlador
		redirect (action:current)
	}
    def current= {
		//mensaje al explorador
//		render "<h1>Project tracker example</h1>"
		//variables
//		def projectName = "Project tracker example"
//		def dueDate = "18/01/2015"
		
		def allProject = ListProject.list()
		[allProject:allProject]
		
		//groovy
		//key:value , key estara en la vista
		//[project:projectName, date:dueDate]
				
		
	}
	
	def overdue = {
		render "Order Packages"
	}
	
	
}
