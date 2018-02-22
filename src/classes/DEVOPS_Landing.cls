public with sharing class DEVOPS_Landing{

    public DEVOPS_Landing(){
        String SobjectName = 'User';
        String soqlQuery = 'Select Id,FirstName FROM '+ SobjectName +' WHERE FirstName <> NULL';
        List<User> userList = Database.query(soqlQuery);
        ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.INFO,'Number of Active Users in this org are: '+ userList.size()));
    }
}