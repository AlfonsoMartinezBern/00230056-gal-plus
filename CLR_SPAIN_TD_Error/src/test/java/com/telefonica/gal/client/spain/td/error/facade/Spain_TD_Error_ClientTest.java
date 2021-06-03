package com.telefonica.gal.client.spain.td.error.facade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;
import com.telefonica.gal.client.spain.td.error.msg.ErrorResponse;


@SpringBootTest
class Spain_TD_Error_ClientTest {

	@Autowired
	Spain_TD_Error_Client spain_CLR;
	
	@ParameterizedTest
	@CsvSource(value = {
			"UserProductsManagement;SPAIN_TD_ServicesConsolidation;409001;ServicesConsolidation;Consolidation;OK",
			}, delimiter = ';')
	void testDynamicRouting_Integration(String operationApi, String serviceApi, String errorCode, String errorCodeInterface, String errorCodeOperation, String result) {
		 ErrorResponse response = spain_CLR.search(new ErrorKey( errorCode, errorCodeInterface, errorCodeOperation));
		 System.out.println( response.getErrorInfo().getErrorCode());
		assertEquals(result, response.getResult());
	}
}
