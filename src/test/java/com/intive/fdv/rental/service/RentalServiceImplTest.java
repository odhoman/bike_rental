package com.intive.fdv.rental.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.intive.fdv.rental.config.AppConfig;
import com.intive.fdv.rental.exception.service.RentalServiceException;
import com.intive.fdv.rental.exception.service.RentalServiceValidationException;
import com.intive.fdv.rental.exception.service.WrongComboSelectedServiceException;
import com.intive.fdv.rental.exception.service.WrongRentalTypeSelectedServiceException;
import com.intive.fdv.rental.mode.Item.RentalItem;
import com.intive.fdv.rental.mode.Item.RentalType;
import com.intive.fdv.rental.mode.Item.RentalTypeEnum;
import com.intive.fdv.rental.mode.bike.BikeEnum;
import com.intive.fdv.rental.mode.combo.RentalCombo;
import com.intive.fdv.rental.mode.combo.RentalComboEnum;

/** RentalService Unit Test */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
public class RentalServiceImplTest {

	@Autowired
	RentalService rentalService;
	
	/** Family rental Discount Verification */
	
	@Test
	public void testFamilyRental() {
		try {
			RentalCombo rentalCombo = rentalService.createNewRentalCombo(RentalComboEnum.FAMILY_COMBO_RENTAL);
			RentalType rentalTypeHours = rentalService.createRentalType(RentalTypeEnum.RENTAL_BY_HOURS); // $5
			RentalType rentalTypeDay = rentalService.createRentalType(RentalTypeEnum.RENTAL_BY_DAY); // $20
			RentalType rentalTypeWeek = rentalService.createRentalType(RentalTypeEnum.RENTAL_BY_WEEK); // $60

			rentalService.addRentalItem(new RentalItem(BikeEnum.BIKE_1, rentalTypeHours, 2), rentalCombo); // $10
			rentalService.addRentalItem(new RentalItem(BikeEnum.BIKE_2, rentalTypeDay, 3), rentalCombo); // $60
			rentalService.addRentalItem(new RentalItem(BikeEnum.BIKE_3, rentalTypeWeek, 1), rentalCombo); // $60

			// Validate familiar combo - OK
			rentalService.validateRentalCombo(rentalCombo);

			// 10 + 60 + 60 = 130 - (30%) = 91
			assertEquals("Right Total Price", 91D, rentalCombo.getTotalPrice(), 0.0);

		} catch (RentalServiceException e) {
			fail("Unexpected Error");
		}
	}

	/** Max bikes rental validation in Family rental   */
	
	@Test(expected = RentalServiceValidationException.class)
	public void testFamilyRentalMaxItemsValidation() throws RentalServiceValidationException {
		try {
			RentalCombo rentalCombo = rentalService.createNewRentalCombo(RentalComboEnum.FAMILY_COMBO_RENTAL);
			RentalType rentalTypeHours = rentalService.createRentalType(RentalTypeEnum.RENTAL_BY_HOURS); // $5
			RentalType rentalTypeDay = rentalService.createRentalType(RentalTypeEnum.RENTAL_BY_DAY); 	 // $20
			RentalType rentalTypeWeek = rentalService.createRentalType(RentalTypeEnum.RENTAL_BY_WEEK);   // $60

			// 6 Items
			rentalService.addRentalItem(new RentalItem(BikeEnum.BIKE_1, rentalTypeHours, 2), rentalCombo); // $10
			rentalService.addRentalItem(new RentalItem(BikeEnum.BIKE_2, rentalTypeDay, 3), rentalCombo);   // $60
			rentalService.addRentalItem(new RentalItem(BikeEnum.BIKE_3, rentalTypeWeek, 1), rentalCombo);  // $60
			rentalService.addRentalItem(new RentalItem(BikeEnum.BIKE_4, rentalTypeWeek, 1), rentalCombo);  // $60
			rentalService.addRentalItem(new RentalItem(BikeEnum.BIKE_5, rentalTypeWeek, 1), rentalCombo);  // $60
			rentalService.addRentalItem(new RentalItem(BikeEnum.BIKE_6, rentalTypeWeek, 1), rentalCombo);  // $60

			// Validate familiar combo - No OK
			rentalService.validateRentalCombo(rentalCombo);

		} catch (RentalServiceValidationException e) {
			throw e;
		} catch (RentalServiceException e) {
			fail("Unexpected Exception");
		}
		fail("Exception Expected");
	}

	/** Min bikes rental validation in Family rental */
	
	@Test(expected = RentalServiceValidationException.class)
	public void testFamilyRentalMinItemsValidation() throws RentalServiceValidationException {
		try {
			RentalCombo rentalCombo = rentalService.createNewRentalCombo(RentalComboEnum.FAMILY_COMBO_RENTAL);
			RentalType rentalTypeHours = rentalService.createRentalType(RentalTypeEnum.RENTAL_BY_HOURS); // $5
			RentalType rentalTypeDay = rentalService.createRentalType(RentalTypeEnum.RENTAL_BY_DAY); // $20

			// 2 Items
			rentalService.addRentalItem(new RentalItem(BikeEnum.BIKE_1, rentalTypeHours, 2), rentalCombo); // $10
			rentalService.addRentalItem(new RentalItem(BikeEnum.BIKE_2, rentalTypeDay, 3), rentalCombo); // $60

			// Validate familiar combo - No OK
			rentalService.validateRentalCombo(rentalCombo);

		} catch (RentalServiceValidationException e) {
			throw e;
		} catch (RentalServiceException e) {
			fail("Unexpected Exception");
		}
		fail("Exception Expected");
	}

	/** Regular rental Verification */
	
	@Test
	public void testRegularRental() {
		try {
			RentalCombo rentalCombo = rentalService.createNewRentalCombo(RentalComboEnum.REGULAR_COMBO_RENTAL);
			RentalType rentalTypeHours = rentalService.createRentalType(RentalTypeEnum.RENTAL_BY_HOURS); // $5
			RentalType rentalTypeDay = rentalService.createRentalType(RentalTypeEnum.RENTAL_BY_DAY); // $20
			RentalType rentalTypeWeek = rentalService.createRentalType(RentalTypeEnum.RENTAL_BY_WEEK); // $60

			rentalService.addRentalItem(new RentalItem(BikeEnum.BIKE_1, rentalTypeHours, 3), rentalCombo); // $15
			rentalService.addRentalItem(new RentalItem(BikeEnum.BIKE_2, rentalTypeDay, 4), rentalCombo); // $80
			rentalService.addRentalItem(new RentalItem(BikeEnum.BIKE_3, rentalTypeWeek, 2), rentalCombo); // $120

			// Validate regular combo - OK
			rentalService.validateRentalCombo(rentalCombo);

			// 15 + 50 + 120 = 215
			assertPrice(rentalCombo.getTotalPrice(), 215D);

		} catch (RentalServiceException e) {
			fail("Unexpected Error");
		}
	}
	
	/** Null type rental creation validation */
	
	@Test(expected = WrongRentalTypeSelectedServiceException.class)
	public void testCreateNullRentalTypeError() throws WrongRentalTypeSelectedServiceException {
		try {
			rentalService.createRentalType(null);
		} catch (WrongRentalTypeSelectedServiceException e) {
			throw e;
		}catch (RentalServiceException e) {
			fail("Unexpected Exception");
		}
	}
	
	/** Not implemented type rental creation validation */
	
	@Test(expected = WrongRentalTypeSelectedServiceException.class)
	public void testCreateNotImplementedRentalTypeError() throws WrongRentalTypeSelectedServiceException {
		try {
			rentalService.createRentalType(RentalTypeEnum.RENTAL_NOT_IMPLEMENTED);
		} catch (WrongRentalTypeSelectedServiceException e) {
			throw e;
		}catch (RentalServiceException e) {
			fail("Unexpected Exception");
		}
	}
	
	/** Null selected  bike rental validation  */
	
	@Test(expected = WrongComboSelectedServiceException.class)
	public void testCreateNullRentalComboError() throws WrongComboSelectedServiceException {
		try {
			rentalService.createNewRentalCombo(null);
		} catch (WrongComboSelectedServiceException e) {
			throw e;
		}catch (RentalServiceException e) {
			fail("Unexpected Exception");
		}
	}
	
	/** Wrong bike rental selected validation */ 
	
	@Test(expected = WrongComboSelectedServiceException.class)
	public void testCreateNotImplementedRentalComboError() throws WrongComboSelectedServiceException {
		try {
			rentalService.createNewRentalCombo(RentalComboEnum.NOT_IMPLEMENTED_COMBO_RENTAL);
		} catch (WrongComboSelectedServiceException e) {
			throw e;
		}catch (RentalServiceException e) {
			fail("Unexpected Exception");
		}
	}

	private void assertPrice(Double actual, Double expected) {
		assertEquals("Right Total Price", actual, expected, 0.0);
	}

}
