global without sharing class MPOT_Landing{


    webservice static boolean perSet(){
    
       set<string> sAssignedPS = MPOT_Util.getPermissionSetNames(userInfo.getUserId());
        if(sAssignedPS.contains('MPOT_Full_Active') || sAssignedPS.contains('MPOT_General_Plus') ){
             return true;
        }else{
             return false;
        }
        return null;
    }


}
