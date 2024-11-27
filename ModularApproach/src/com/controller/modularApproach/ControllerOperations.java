package com.controller.modularApproach;
import com.service.modularApproach.ServiceOperations;

// This is the main class used for calling operations that contains main method 
public class ControllerOperations {

	public static void main(String[] args) throws Exception{
		ServiceOperations so=new ServiceOperations();
//		so.serviceInsert();
//		so.serviceUpdate();
//		so.serviceDelete();
		so.serviceFetch();
	}

}

//DAO stands for the Data Access Object it is a kind of design pattern in java which seperate data persistence logic into
//seperate layer

//dao->service->controller 
//controller will send the request to the service 
//service sends that request to the dao 
//dao will interact with database perform its operations
//sends the response to the service and then service will format the response object and send it to the controller 