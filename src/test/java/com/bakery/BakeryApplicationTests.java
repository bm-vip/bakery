package com.bakery;

import com.bakery.dto.ResultDto;
import com.bakery.model.ProductEntity;
import com.bakery.service.ProductService;
import com.bakery.service.PurchaseService;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BakeryApplicationTests {

	@Autowired
	PurchaseService purchaseService;
	@Autowired
    ProductService productService;

	@Test
	public void testVS5() {
        ProductEntity productEntity = productService.findByCode("VS5");
        Assertions.assertThat(productEntity).isNotNull();
        ResultDto resultDto1 = purchaseService.calc(10, productEntity.getId());
		Assertions.assertThat(resultDto1.getTotal()).isEqualTo("10 VS5 => 17.98$");
	}

	@Test
	public void testMB11() {
        ProductEntity productEntity = productService.findByCode("MB11");
        Assertions.assertThat(productEntity).isNotNull();
		ResultDto resultDto2 = purchaseService.calc(14, productEntity.getId());
		Assert.assertEquals(resultDto2.getTotal(), "14 MB11 => 41.90$");
	}

	@Test
	public void testCF() {
        ProductEntity productEntity = productService.findByCode("CF");
        Assertions.assertThat(productEntity).isNotNull();
		ResultDto resultDto3 = purchaseService.calc(13, productEntity.getId());
		Assert.assertEquals(resultDto3.getTotal(), "13 CF => 22.94$");
	}

}
