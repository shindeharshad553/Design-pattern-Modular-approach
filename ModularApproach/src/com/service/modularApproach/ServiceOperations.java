package com.service.modularApproach;
import com.dao.modularApproach.databaseOperations;

//serviceOperations are used to perform business logic 
public class ServiceOperations {
	//lets create the object of dao (databaseOperations class)

	public databaseOperations da=new databaseOperations();
	public void serviceInsert() throws Exception{
		da.insertData();
	}
	
	public void serviceUpdate() throws Exception{
		da.updateData();
	}
	
	public void serviceDelete() throws Exception{
		da.deleteData();
	}
	
	public void serviceFetch() throws Exception{
		da.fetchData();
	}
}
