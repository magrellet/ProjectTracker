package projecttracker

class ListProjectController {
	
	//metodo default
	def index = {
		//redirecciono a otro controlador
		redirect (action:current)
	}
    def current= {
		//mensaje al explorador
		render "<h1>Project tracker example</h1>"
	}
	
	def overdue = {
		render "Order Packages"
	}
}
