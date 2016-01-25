package projecttracker

class TaskController {
	def scaffold = true
    def index() {
		redirect (action:list)
	}
}
