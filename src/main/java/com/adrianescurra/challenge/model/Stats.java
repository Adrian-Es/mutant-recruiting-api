package com.adrianescurra.challenge.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

/**
 * Stats
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Stats {

  private Integer id;

  private Integer countMutantDNA;

  private Integer countHumanDNA;

  private Float ratio;

  public Stats id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Stats countMutantDNA(Integer countMutantDNA) {
    this.countMutantDNA = countMutantDNA;
    return this;
  }

  /**
   * Get countMutantDNA
   * @return countMutantDNA
  */
  
  @Schema(name = "countMutantDNA", example = "40", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("countMutantDNA")
  public Integer getCountMutantDNA() {
    return countMutantDNA;
  }

  public void setCountMutantDNA(Integer countMutantDNA) {
    this.countMutantDNA = countMutantDNA;
  }

  public Stats countHumanDNA(Integer countHumanDNA) {
    this.countHumanDNA = countHumanDNA;
    return this;
  }

  /**
   * Get countHumanDNA
   * @return countHumanDNA
  */
  
  @Schema(name = "countHumanDNA", example = "100", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("countHumanDNA")
  public Integer getCountHumanDNA() {
    return countHumanDNA;
  }

  public void setCountHumanDNA(Integer countHumanDNA) {
    this.countHumanDNA = countHumanDNA;
  }

  public Stats ratio(Float ratio) {
    this.ratio = ratio;
    return this;
  }

  /**
   * Get ratio
   * @return ratio
  */
  
  @Schema(name = "ratio", example = "0.4", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ratio")
  public Float getRatio() {
    return ratio;
  }

  public void setRatio(Float ratio) {
    this.ratio = ratio;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Stats stats = (Stats) o;
    return Objects.equals(this.id, stats.id) &&
        Objects.equals(this.countMutantDNA, stats.countMutantDNA) &&
        Objects.equals(this.countHumanDNA, stats.countHumanDNA) &&
        Objects.equals(this.ratio, stats.ratio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, countMutantDNA, countHumanDNA, ratio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Stats {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    countMutantDNA: ").append(toIndentedString(countMutantDNA)).append("\n");
    sb.append("    countHumanDNA: ").append(toIndentedString(countHumanDNA)).append("\n");
    sb.append("    ratio: ").append(toIndentedString(ratio)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

