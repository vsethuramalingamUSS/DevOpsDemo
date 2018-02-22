public without sharing class DEVOPS_Landing{

	public static boolean perSet(){
    	for(User  u : [Select Id, FirstName from User]){
    		u.FirstName = 'Updated' + u.FirstName;
    		
    	}
    	return null;
    }
}
