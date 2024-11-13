package com.adrianescurra.challenge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

/**
 * DNA
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class DNA {

  private List<String> dna;

  public DNA dna(List<String> dna) {
    this.dna = dna;
    return this;
  }

  public DNA addDnaItem(String dnaItem) {
    if (this.dna == null) {
      this.dna = new ArrayList<>();
    }
    this.dna.add(dnaItem);
    return this;
  }

  /**
   * Get dna
   * @return dna
  */
  
  @Schema(name = "dna", example = "[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dna")
  public List<String> getDna() {
    return dna;
  }

  public void setDna(List<String> dna) {
    this.dna = dna;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DNA DNA = (DNA) o;
    return Objects.equals(this.dna, DNA.dna);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dna);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DNA {\n");
    sb.append("    dna: ").append(toIndentedString(dna)).append("\n");
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

