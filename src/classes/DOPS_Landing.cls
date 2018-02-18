global without sharing class DOPS_Landing{


    webservice static boolean perSet(){
    	for(User  u : [Select Id, FirstName from User]){
    		u.FirstName = 'Updated' + u.FirstName;
    		update u;
    	}
    }


}
