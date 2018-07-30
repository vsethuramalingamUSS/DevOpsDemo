
public with sharing class DOPS_Landing{

	public static boolean perSet(){
	//Test Comment to Check Delta package Functionality Updated
    	for(User  u : [Select Id, FirstName from User]){
    		u.FirstName  = 'Updated' + u.FirstName;
    		update u;
    	}
		
    	return null;
    }
}
