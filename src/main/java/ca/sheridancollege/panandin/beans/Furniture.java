//Nandini Patel

package ca.sheridancollege.panandin.beans;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Furniture implements Serializable{
	
	private Long id;
	private String roomType;
	private String furnitureCategory;
	private String furnitureName;
	private String furnitureColor;
	private String furniturePrice;
}
