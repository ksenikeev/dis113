package semestrii.gui.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PurchaseDto {
 /**  UID код генерируется при создании покупки  */
 private String sellUid;
 /** Покупатель */
 private ManufacturerDto manufacturer;
 /** дата покупки */
 private Date purchaseDate;
}
