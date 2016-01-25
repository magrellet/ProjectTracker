package projecttracker

import org.springframework.dao.DataIntegrityViolationException

class EndUserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
//        redirect(action: "login", params: params)
		redirect(action: "list", params: params)
    }
	
	def login = {}
	
	def authenticate = {
		def user = EndUser.findByUserNameAndPassword(params.userName, params.password)
		if(user){
			session.user = user
			flash.message="Buenas ${user.fullName}!"
			redirect(action:"login")
		}	
		else{
			flash.message = "Login incorrecto ${params.userName}. Intente de nuevo"
			redirect(action:"login")
		}
		
	}
	
	def logout = {
		flash.message = "Chau ${session.fullName}"
		session.user = null
		redirect(action:"login")
	}

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [endUserInstanceList: EndUser.list(params), endUserInstanceTotal: EndUser.count()]
    }

    def create() {
        [endUserInstance: new EndUser(params)]
    }

    def save() {
        def endUserInstance = new EndUser(params)
        if (!endUserInstance.save(flush: true)) {
            render(view: "create", model: [endUserInstance: endUserInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'endUser.label', default: 'EndUser'), endUserInstance.id])
        redirect(action: "show", id: endUserInstance.id)
    }

    def show() {
        def endUserInstance = EndUser.get(params.id)
        if (!endUserInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'endUser.label', default: 'EndUser'), params.id])
            redirect(action: "list")
            return
        }

        [endUserInstance: endUserInstance]
    }

    def edit() {
        def endUserInstance = EndUser.get(params.id)
        if (!endUserInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'endUser.label', default: 'EndUser'), params.id])
            redirect(action: "list")
            return
        }

        [endUserInstance: endUserInstance]
    }

    def update() {
        def endUserInstance = EndUser.get(params.id)
        if (!endUserInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'endUser.label', default: 'EndUser'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (endUserInstance.version > version) {
                endUserInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'endUser.label', default: 'EndUser')] as Object[],
                          "Another user has updated this EndUser while you were editing")
                render(view: "edit", model: [endUserInstance: endUserInstance])
                return
            }
        }

        endUserInstance.properties = params

        if (!endUserInstance.save(flush: true)) {
            render(view: "edit", model: [endUserInstance: endUserInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'endUser.label', default: 'EndUser'), endUserInstance.id])
        redirect(action: "show", id: endUserInstance.id)
    }

    def delete() {
        def endUserInstance = EndUser.get(params.id)
        if (!endUserInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'endUser.label', default: 'EndUser'), params.id])
            redirect(action: "list")
            return
        }

        try {
            endUserInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'endUser.label', default: 'EndUser'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'endUser.label', default: 'EndUser'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
