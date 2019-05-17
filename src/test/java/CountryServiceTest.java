import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.spring.dao.CountryDAO;
import com.spring.model.Country;
import com.spring.service.CountryService;
import static org.mockito.ArgumentMatchers.any;

//@SuppressWarnings("deprecation")
//@RunWith(MockitoJUnitRunner.class)
public class CountryServiceTest {
	@Mock
	CountryDAO countryDao;
	@Mock
	Country country;

	@InjectMocks
	CountryService countryService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveCoutry() {
		System.out.println("testing save country");
		assertNotNull(country);
		assertNotNull(countryDao);
		country = new Country(1, "Tunisie", 3000);
		// Mocking dao saveCountry method
		when(countryDao.addCountry(any(Country.class))).thenReturn(country);

		// Call saveCountry method
		Country result = countryService.addCountry(country);

		// Assert expected results
		assertNotNull(result);
		assertEquals(country.getCountryName(), result.getCountryName());
		assertEquals(country.getPopulation(), result.getPopulation());
		System.out.println("TEST OK");
	}

}
