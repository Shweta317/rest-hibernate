package com.test;

import com.entities.Employee;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.Matchers;
import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testEmployeeExistsById() throws ClientProtocolException, IOException { 
		// whenUserInformationIsRetrieved > thenRetrievedResourceIsCorrect

		// Given
		HttpUriRequest request = new HttpGet("http://127.0.0.1:8080/Enviance/employee/getEmployeeById/1");
		
		// When
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		
		// Then
		Employee emp = RetrieveClassUtil.retrieveResourceFromResponse(response, Employee.class);
		assertThat(new Integer(1), Matchers.is(emp.getEmployeeId()));
	}
	
	@Test
	public void testEmployeeDoesNotExists() {
		// whenUserInfoIsNotRetrieved > then404IsReceived
		try{
			// Given ---- parameter does not exist in DB
			final HttpUriRequest request = new HttpGet("http://127.0.0.1:8080/Enviance/employee/getEmployeeById/12");
	
			// When
			final HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
	
			// Then
			assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NO_CONTENT));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEmployeeWrongRequestURL() {
		// whenUserInfoIsNotRetrieved > then404IsReceived
		try{
			// Given ---- URL Request is Incorrect
			final HttpUriRequest request = new HttpGet("http://127.0.0.1:8080/Enviance/employee/getEmploy/12");
	
			// When
			final HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
	
			// Then
			assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
