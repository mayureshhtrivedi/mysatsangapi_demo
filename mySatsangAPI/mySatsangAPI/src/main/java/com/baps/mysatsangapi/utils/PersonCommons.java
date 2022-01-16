package com.baps.mysatsangapi.utils;

public interface PersonCommons {

	String CREATED = "201";
	String OK = "200";
	String UNSUPPORTED_MEDIA_TYPE = "415";
	String INTERNAL_SERVER_ERROR = "500";
	String UNAUTHORIZED = "401";
	String BAD_REQUEST = "400";

	String MYSATSANG_API = "service.http_requests";
	String HTTP_RESPONSE = "status_code";
	String CREATE_PERSON_REQUEST = "create_person_request";
	String CREATE_PERSON = "create_person";

	String UPDATE_PERSON_REQUEST = "update_person_request";
	String UPDATE_PERSON = "update_person";

	String GET_PERSON_REQUEST = "get_person_request";
	String GET_PERSON = "get_person";
	
	String GET_ALL_PERSON_REQUEST = "get_person_request";
	String GET_ALL_PERSON = "get_person";

	String REMOVE_PERSON_REQUEST = "remove_person_request";
	String REMOVE_PERSON = "remove_person";

	double INCREMENT_AMOUNT = 1.0;
}
