package fr.epsi.atlas.monnaie.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Monnaie {

	/**
	 * le code ISO-4217
	 */
	@Id
	private String code;

	@NotNull(message = "Le taux de change doit être positif")
	@Min(value = 0, message = "Le taux de change doit être positif")
	private BigDecimal tauxDeChange;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getTauxDeChange() {
		return tauxDeChange;
	}
	public void setTauxDeChange(BigDecimal tauxDeChange) {
		this.tauxDeChange = tauxDeChange;
	}
}
