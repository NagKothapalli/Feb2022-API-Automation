package parseJsonRespone;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Test;

import com.google.gson.Gson;

public class ReadFlightInformation
{
	@Test
	public void readFlightData() throws FileNotFoundException
	{
		Gson gson = new Gson();
		FileReader myfile = new FileReader("APIData/Request.json");
		MyFlightInfo flightData = gson.fromJson(myfile, MyFlightInfo.class);
		String myflightData = gson.toJson(flightData);
		System.out.println("Flight info before updating       :" + myflightData);
		System.out.println(flightData.requestInfo.correlationId);
		System.out.println(flightData.clientInfo.agency_code);
		System.out.println(flightData.segment_info.segment_id);
		System.out.println(flightData.segment_info.flight_info.flight_number);
		System.out.println(flightData.seat_action);	
		flightData.requestInfo.correlationId = "661e9d57-e26d-4296-alde-500f35fc92e5";
		flightData.clientInfo.agency_code = "AGCD";
		flightData.segment_info.segment_id = 1010 ;
		flightData.segment_info.flight_info.flight_number = "A1122";
		flightData.seat_action = 1;
		myflightData = gson.toJson(flightData);
		//We will provide this json string as payload the API Endpoint
		System.out.println("Flight info after deserialization :" + myflightData);
	}

}

//import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
//import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
class MyFlightInfo{
	 public RequestInfo requestInfo;
	 public ClientInfo clientInfo;
	 public SegmentInfo segment_info;
	 public int seat_action;
}
class RequestInfo{
 public String correlationId;
 public String transactionId;
 public String version;
}

class ClientInfo{
 public String client_context;
 public int channel_type;
 public String channel_id;
 public String requester;
 public String agency_code;
 public String iata_number;
 public String pseudo_city_code;
 public String agent_city_code;
 public String country_code;
 public String currency_code;
 public String supplier_type;
 public String lniata;
 public String lock_id;
 public String sell_city;
 public String travel_agent_indicator;
 public String agent_sine_city;
 public String agent_sign;
}

class FlightInfo{
 public String airline_code;
 public String flight_number;
 public String scheduled_departure_date;
 public String departure_airport_code;
 public String arrival_airport_code;
 public String operational_suffix;
}

class SegmentInfo{
 public int segment_id;
 public int supplier_type;
 public String booking_class_code;
 public int seatmap_view_type;
 public FlightInfo flight_info;
}




