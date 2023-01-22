//Nandini Patel

package ca.sheridancollege.panandin.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.panandin.beans.Furniture;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void insertFurniture(String roomType, String furnitureCategory, String furnitureName, 
			String furnitureColor, Long furniturePrice) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO furniture(roomType, furnitureCategory, furnitureName, furnitureColor, furniturePrice)"
				+ "VALUES(:roomType, :furnitureCategory, :furnitureName, :furnitureColor, :furniturePrice)";
		namedParameters.addValue("roomType", roomType);
		namedParameters.addValue("furnitureCategory", furnitureCategory);
		namedParameters.addValue("furnitureName", furnitureName);
		namedParameters.addValue("furnitureColor", furnitureColor);
		namedParameters.addValue("furniturePrice", furniturePrice);
		
		int rowsAffected=jdbc.update(query, namedParameters);
		if(rowsAffected > 0)
			System.out.println("Inserted item into database.");
	}
	
	public List<Furniture> getFurniture(){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM furniture";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Furniture>(Furniture.class));
	}
	
	public void deleteFurniture(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "DELETE FROM furniture WHERE id = :id";
		namedParameters.addValue("id",id);
		int rowsAffected = jdbc.update(query, namedParameters);
		if(rowsAffected > 0)
			System.out.println("Deleted Item from database");
	}
	
	public List<Furniture> getFurnitureById(Long id){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM furniture WHERE id = :id";
		namedParameters.addValue("id",id);
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Furniture>(Furniture.class));
	}
}
