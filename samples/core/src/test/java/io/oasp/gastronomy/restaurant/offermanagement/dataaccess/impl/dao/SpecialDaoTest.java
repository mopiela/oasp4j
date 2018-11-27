package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.impl.dao;

import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.WeeklyPeriodEmbeddable;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.OfferDao;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SpecialDao;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * @author mopiela
 *
 */
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(classes = { SpringBootApp.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpecialDaoTest {

  @Autowired
  private SpecialDao specialDao;

  @Autowired
  private OfferDao offerDao;

  @Test
  public void shouldFindByName() {

    SpecialEntity specialEntity = prepareSpecial();

    this.specialDao.save(specialEntity);

    SpecialSearchCriteriaTo criteria = new SpecialSearchCriteriaTo();
    criteria.setName("superOferta");

    PaginatedListTo<SpecialEntity> result = this.specialDao.findSpecials(criteria);

    assertThat(result.getResult().size(), org.hamcrest.Matchers.is(1));

  }

  private SpecialEntity prepareSpecial() {

    SpecialEntity specialEntity = new SpecialEntity();

    WeeklyPeriodEmbeddable weeklyPeriodEmbeddable = new WeeklyPeriodEmbeddable();
    weeklyPeriodEmbeddable.setStartingDay(DayOfWeek.WEDNESDAY);
    weeklyPeriodEmbeddable.setStartingHour(12);
    weeklyPeriodEmbeddable.setEndingHour(15);
    weeklyPeriodEmbeddable.setEndingDay(DayOfWeek.SATURDAY);

    specialEntity.setActivePeriod(weeklyPeriodEmbeddable);
    specialEntity.setName("superOferta");
    specialEntity.setSpecialPrice(new Money(12));

    specialEntity.setOffer(this.offerDao.find(1L));

    return specialEntity;
  }

}
