package projecttracker

class TaskController {
	def scaffold = true
	
	def beforeInterceptor = [action:this.&auth]
			
	def auth () {
		if(!session.user){
			redirect(controller:"EndUser", action:"login")
			return false
		}
	}
	
//    def index() {
//		redirect (action:list)
//	}
}
