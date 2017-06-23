myMethods = Object.private_instance_methods(false)
#p myMethods
myMethods = myMethods - [:import, :java_import]