package com.place.model;


//import com.place.model.dto.PlaceRequestDTO;
//import com.place.model.dto.PlaceResponseDTO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

/** Entity model for Place. */
@Entity
@Table(name = "place")
@EntityListeners(AuditingEntityListener.class)
public class Place {

  /** Place id, primary key of the place table. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long placeId;

  /** name about the Place. */
  @Column(name = "name", nullable = false)
  private String name;

  /** slug about the Place. */
  @Column(name = "slug", nullable = false)
  private String slug;

  /** city about the Place. */
  @Column(name = "city", nullable = false)
  private String city;

  /** state  about the Place. */
  @Column(name = "state", nullable = false)
  private String state;

  /** Place creation date. */
  @CreatedDate
  @Column(name = "created_at", nullable = true, updatable = false)
  private Timestamp createdAt;

  /** Place last modification date. */
  @LastModifiedDate
  @Column(name = "updated_at", nullable = true)
  private Timestamp updatedAt;

  public Place() {

  }

  public Place(String name) {
    this.name = name;
  }

  public long getPlaceId() {
    return placeId;
  }

  public void setPlaceId(long placeId) {
    this.placeId = placeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

  /**
   * Method responsible for generating a hash code value for the object.
   *
   * @return unique hash code for the object.
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (placeId ^ (placeId >>> 32));
    return result;
  }

  /**
   * Method responsible for comparing this object with another.
   *
   * @param obj Object for comparison.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Place other = (Place) obj;
    return placeId == other.placeId;
  }
}
