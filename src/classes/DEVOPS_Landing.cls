public with sharing class DOPS_Landing{

	public static boolean perSet(){
    	for(User  u : [Select Id, FirstName from User]){
    		u.FirstName = 'Updated' + u.FirstName;
    		update u;
    	}
    	return null;
    }
}
