package io.oasp.gastronomy.restaurant.offermanagement.logic.api.to;

import java.sql.Date;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * @author mopiela
 *
 */
public class SpecialSearchCriteriaTo extends SearchCriteriaTo {

  /**
   *
   */
  private static final long serialVersionUID = 3557242808372124289L;

  private String name;

  private Long offerNumber;

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return offerNumber
   */
  public Long getOfferNumber() {

    return this.offerNumber;
  }

  /**
   * @param offerNumber new value of {@link #getofferNumber}.
   */
  public void setOfferNumber(Long offerNumber) {

    this.offerNumber = offerNumber;
  }

  /**
   * @return date
   */
  public Date getDate() {

    return this.date;
  }

  /**
   * @param date new value of {@link #getdate}.
   */
  public void setDate(Date date) {

    this.date = date;
  }

  private Date date;

}
